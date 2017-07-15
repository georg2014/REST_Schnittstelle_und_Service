package de.tub.ise.anwsys.clients;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

public class TestClient {

	public static void main(String[] args) throws IOException, UnirestException {
		
		/*
		 * 	Erstellen Sie eine 
			Client
			-
			Komponente
			, die Daten aus dem SMEmu Container liest und an Ihre 
			REST
			-
			Schnittstelle sendet.
		 */
		HttpResponse<JsonNode> responseMeters = Unirest.get("http://localhost:7878/meters").asJson();

		// get smartmeter array
		JSONArray meterArray = meters(responseMeters, "object", "meters");
		System.out.println("meterArray: "+meterArray);
		
		
		// go through all smartmeters
		for (int i = 0; i < meterArray.length(); i++) {
			
			//current smart meter id
			String meterId = meterArray.getString(i);
			// print every meter
			System.out.print("\nmeter " + i + " " + meterId + "\n ");

			// go to current smart meter
			HttpResponse<JsonNode> responseMeter = Unirest.get("http://localhost:7878/meters/" + meterArray.get(i))
					.asJson();
			
			//
			JSONArray metrics = metrics(responseMeter, "array");

			for (int x = 0; x < metrics.length(); x++) {
				HttpResponse<JsonNode> newMetric = Unirest.post("http://localhost:8080/smartMeter/metric")
						.header("accept", "application/json").header("Content-Type", "application/json")
						.body(metrics.getJSONObject(x)).asJson();
			}

			HttpResponse<JsonNode> newMeter = Unirest.post("http://localhost:8080/smartMeter")
					.header("accept", "application/json").header("Content-Type", "application/json")
					.body(new JSONObject("{meterId:" + meterId + ", metric:" + metrics + "}")).asJson();

			for (int n = 0; n < 2000; n++) {

				HttpResponse<JsonNode> responseMeasurement = Unirest.get("http://localhost:7878/meters/" + meterId + "/data").asJson();

				JSONObject measurement = new JSONObject(responseMeasurement);

				long timestamp = measurement.getJSONObject("body").getJSONObject("object").getLong("unixTimestamp");
				
				JSONArray measurements = measurement.getJSONObject("body").getJSONObject("object").getJSONArray("measurements");

				for (int ind = 0; ind<measurements.length();++ind) {

					double value = measurements.getJSONObject(ind).getDouble("value");
					
					JSONObject metric = new JSONObject("{metricId:"+measurements.getJSONObject(ind).getString("metricId")+"}");
					
					if(n<1) {System.out.println(timestamp); System.out.println(metric);};
					
					JSONObject meter = new JSONObject("{meterId:"+meterId+"}");

					HttpResponse<JsonNode> newMeas = Unirest
							.post("http://localhost:8080/smartMeter/" + meterId + "/measurement")
							.header("accept", "application/json").header("Content-Type", "application/json")
							.body(new JSONObject("{met:" + metric + ",smart:" + meter + ",timestamp:" + timestamp+ ",value:" + value + "}")).asJson();
				}
			}
		}
		
		/*
		 * 	Erfragen Sie mit Hilfe des Clients über Ihre API
			die 
			durchschnittlich 
			anliegende 
			Stromstärke für 
			ein beliebiges 15
			-
			min
			-
			Interval für 
			den Smart Meter mit der ID, die auf 
			„2“
			endet.
		 */
		//go through all meters and look for the one with the 2
		System.out.println("\n\n");
		for(int i=0; i < meterArray.length(); i++){
			//look via if
			String meterId = meterArray.getString(i);
			if(meterId.substring(meterId.length()-1).equals("2")){
				String metTxt = "Current(mA)";
				GetRequest responseMeter = Unirest.get("http://localhost:8080/smartMeter/" + meterId);
				JSONArray metrics = metricsObj(responseMeter.asJson(),"","").getJSONArray("array");
				String metId="";
				for(int j =0; j<metrics.length();j++){
					String currMetTxt = (String) metrics.getJSONObject(j).getString("metricText");
					if(currMetTxt.equals(metTxt)){
						metId = (String) metrics.getJSONObject(j).getString("metricId");
						String time = "1484266932"; //needs to be parsed to HH-mm-ss-dd-MM-yyyy now!!!
						HttpResponse<String> responseMeas = Unirest.get("http://localhost:8080/smartMeter/" + meterId + "/measurement/" + metId + "?time="+time).asString();
						System.out.println("The avrage current is: "+responseMeas.getBody().toString()+" for the time "+time+" (if theire is no current it is the wrong time). For the Smart Meter with the ID: "+meterId);
					}
				}
			}
		}
		
		
	}

	
	//helping methods
	public static JSONObject metricsObj(HttpResponse<JsonNode> response, String path1, String path2) {
		return (new JSONObject(response)).getJSONObject("body");
	}

	public static JSONArray meters(HttpResponse<JsonNode> response, String path1, String path2) {
		return (new JSONObject(response)).getJSONObject("body").getJSONObject(path1).getJSONArray(path2);
	}

	public static JSONArray metrics(HttpResponse<JsonNode> response, String path) {
		return (new JSONObject(response)).getJSONObject("body").getJSONArray(path);
	}

	public static JSONObject metricId(HttpResponse<JsonNode> response, String path, String path1) {
		return (new JSONObject(response)).getJSONObject("body").getJSONObject(path).getJSONObject(path1);
	}
}