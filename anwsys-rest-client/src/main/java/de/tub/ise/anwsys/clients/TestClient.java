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
		 * 	Erstellen Sie eine Client-Komponente, die Daten aus dem SMEmu Container liest(get) und an Ihre REST-Schnittstelle sendet(post).
		 */
		//http get request on "http://localhost:7878/meters" as JSON
		HttpResponse<JsonNode> responseMeters = Unirest.get("http://localhost:7878/meters").asJson();

		//get smartmeter array from get request
		JSONArray meterArray = meters(responseMeters, "object", "meters");
		
		//go through all smartmeters [meterArray]
		for (int i = 0; i < meterArray.length(); i++) {
			
			//current smart meter id
			String meterId = meterArray.getString(i);
			//print current meter
			System.out.print("\nmeter " + i + " " + meterId + "\n ");

			//http get request on the current smart meter path as JSON
			HttpResponse<JsonNode> responseMeter = Unirest.get("http://localhost:7878/meters/" + meterArray.get(i))
					.asJson();
			
			//get current metric array of current smartmeter 
			JSONArray metrics = metrics(responseMeter, "array");

			//go through all metrics
			for (int x = 0; x < metrics.length(); x++) {
				//post current metric of the array to our REST-Gateway [http://localhost:8080/smartMeter/metric]
				HttpResponse<JsonNode> newMetric = Unirest.post("http://localhost:8080/smartMeter/metric")
						.header("accept", "application/json").header("Content-Type", "application/json")
						.body(metrics.getJSONObject(x)).asJson();
			}

			//post current meter to our REST-Gateway [http://localhost:8080/smartMeter]
			HttpResponse<JsonNode> newMeter = Unirest.post("http://localhost:8080/smartMeter")
					.header("accept", "application/json").header("Content-Type", "application/json")
					.body(new JSONObject("{meterId:" + meterId + ", metric:" + metrics + "}")).asJson();

			//do 2000 times
			for (int n = 0; n < 2000; n++) {

				//get measurement of current meter via id
				HttpResponse<JsonNode> responseMeasurement = Unirest.get("http://localhost:7878/meters/" + meterId + "/data").asJson();

				//cast responseMeasurement to JSONObject [measurement]
				JSONObject measurement = new JSONObject(responseMeasurement);

				//save unixTimestamp [timestamp] from current [measurement]
				long timestamp = measurement.getJSONObject("body").getJSONObject("object").getLong("unixTimestamp");
				
				//get [measurements] as JSONArray from current [measurement]
				JSONArray measurements = measurement.getJSONObject("body").getJSONObject("object").getJSONArray("measurements");

				//go through all [measurements]
				for (int ind = 0; ind<measurements.length();ind++) {

					//get [value] from current metric via current measurement
					double value = measurements.getJSONObject(ind).getDouble("value");
					
					//create new JSONObject [metric] with current metricId
					JSONObject metric = new JSONObject("{metricId:"+measurements.getJSONObject(ind).getString("metricId")+"}");
					
					//print [timestamp] and [metric] for the first measurement
					if(n<1) {System.out.println(timestamp); System.out.println(metric);};
					
					//create new JSONObject [metric] with current meterId
					JSONObject meter = new JSONObject("{meterId:"+meterId+"}");

					//post current meter to our REST-Gateway [http://localhost:8080/smartMeter/{meterId}/measurement]
					HttpResponse<JsonNode> newMeas = Unirest
							.post("http://localhost:8080/smartMeter/" + meterId + "/measurement")
							.header("accept", "application/json").header("Content-Type", "application/json")
							.body(new JSONObject("{met:" + metric + ",smart:" + meter + ",timestamp:" + timestamp+ ",value:" + value + "}")).asJson();
				}
			}
		}
		
		/*
		 * 	Erfragen Sie mit Hilfe des Clients ueber Ihre API die durchschnittlich anliegende Stromstaerke für ein beliebiges 15-min-Interval
		 *  für den Smart Meter mit der ID, die auf „2“endet.
		 */
		//go through all meters
		for(int i=0; i < meterArray.length(); i++){
			//save current [meterId]
			String meterId = meterArray.getString(i);
			//look for the meter with the id ending with 2
			if(meterId.substring(meterId.length()-1).equals("2")){
				//TODO save metricText of the typ to look for
				String metTxt = "Current(mA)";
				//get current meter
				GetRequest responseMeter = Unirest.get("http://localhost:8080/smartMeter/" + meterId);
				//get current metric array of current smartmeter
				JSONArray metrics = metricsObj(responseMeter.asJson(),"","").getJSONArray("array");
				String metId="";
				//go through all metrics
				for(int j =0; j<metrics.length();j++){
					//get current metricText
					String currMetTxt = (String) metrics.getJSONObject(j).getString("metricText");
					if(currMetTxt.equals(metTxt)){
						//save metricId
						metId = (String) metrics.getJSONObject(j).getString("metricId");
						//TODO time to look for: this is just implemented here so to get a wished avarage value
						String time = "12-22-00-16-01-2017"; //needs to be parsed to HH-mm-ss-dd-MM-yyyy now!!!
						//get measurment response from our REST-Gateway [http://localhost:8080/smartMeter/{meterId}/measurement/{metricId}?time=][time]
						HttpResponse<String> responseMeas = Unirest.get("http://localhost:8080/smartMeter/" + meterId + "/measurement/" + metId + "?time="+time).asString();
						//print the resulting 15-minute value out
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