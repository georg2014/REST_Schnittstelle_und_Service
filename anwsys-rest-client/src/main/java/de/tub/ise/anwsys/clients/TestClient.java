package de.tub.ise.anwsys.clients;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestClient 
{

	public static void main(String[] args) throws IOException, UnirestException 
	{

		HttpResponse<JsonNode> responseMeters = Unirest.get("http://localhost:7878/meters").asJson();

		// JSONObject myObject = new JSONObject(responseMeters);
		// JSONObject jsonGlossary = myObject.getJSONObject("body");
		//
		// jsonGlossary= jsonGlossary.getJSONObject("object");
		// JSONArray jsonGlossary2= jsonGlossary.getJSONArray("meters");

																		// get smartmeter array
		JSONArray meterArray = meters(responseMeters, "object", "meters");

																		// go through all smartmeters
		for (int i = 0; i < meterArray.length(); i++) 
		{
			String meterId = meterArray.getString(i);
																		//current smart meter id
			if(meterId.substring(meterId.length()-1).equals("2"))
			{
																		// print meter
				System.out.println("meter" + i + ": " + meterId + "\n ");
	
																		// go to current smart meter
				HttpResponse<JsonNode> responseMeter = Unirest.get("http://localhost:7878/meters/" + meterArray.get(i)).asJson();
																		//
				JSONArray metrics = metrics(responseMeter, "array");
	
				for (int x = 0; x < metrics.length(); x++) 
				{
					HttpResponse<JsonNode> newMetric = Unirest.post("http://localhost:8080/smartMeter/metric")
							.header("accept", "application/json").header("Content-Type", "application/json")
							.body(metrics.getJSONObject(x)).asJson();
				}

				HttpResponse<JsonNode> newMeter = Unirest.post("http://localhost:8080/smartMeter")
						.header("accept", "application/json").header("Content-Type", "application/json")
						.body(new JSONObject("{meterId:" + meterId + ", metric:" + metrics + "}")).asJson();
				double averagevalue=0;
				int i2=0;
				while(i2!=10)
				{
					averagevalue=0;
					for (int n = 0; n < 900; n++) 
					{
						HttpResponse<JsonNode> responseMeasurement = Unirest.get("http://localhost:7878/meters/" + meterId + "/data").asJson();
	
						JSONObject measurement = new JSONObject(responseMeasurement);
	
						long timestamp = measurement.getJSONObject("body").getJSONObject("object").getLong("unixTimestamp");
	
						JSONArray measurements = measurement.getJSONObject("body").getJSONObject("object").getJSONArray("measurements");
						
						double value = measurements.getJSONObject(0).getDouble("value");
						
						averagevalue=averagevalue+value;
						JSONObject metric = new JSONObject("{metricId:"+measurements.getJSONObject(0).getString("metricId")+"}");
						
						JSONObject meter = new JSONObject("{meterId:"+meterId+"}");
	
						HttpResponse<JsonNode> newMeas = Unirest
								.post("http://localhost:8080/smartMeter/" + meterId + "/data")
								.header("accept", "application/json").header("Content-Type", "application/json")
								.body(new JSONObject("{met:" + metric + ",smart:" + meter + ",timestamp:" + timestamp+ ",value:" + value + "}")).asJson();
					
					}
					System.out.println(averagevalue/900);
					i2++;
				}		
			}
		}


	}

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

