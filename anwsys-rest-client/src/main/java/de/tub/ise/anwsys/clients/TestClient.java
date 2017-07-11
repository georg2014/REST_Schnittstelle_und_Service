package de.tub.ise.anwsys.clients;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestClient {
	
	public static void main(String[] args) throws IOException, UnirestException {
		//POST
		JSONObject testmeter = new JSONObject("{meterId:03, metric:[{metId:1},{metId:2}]}");
		//post a new object
	    HttpResponse<JsonNode> jsonResponse = Unirest.post("http://localhost:8080/smartMeter").header("accept", "application/json")
            .header("Content-Type", "application/json").body(testmeter).asJson();
	
		
//		HttpResponse<String> response = Unirest.get("https://google.com").asString();
//		System.out.println(String.format("Google's status code was: %d", response.getStatus()));
		HttpResponse<JsonNode> responseMeters = Unirest.get("http://localhost:7878/meters").asJson();
		JSONObject myObject = new JSONObject(responseMeters);
		//print the hole jason with header and body
		System.out.println(myObject);
		JSONObject jsonGlossary = myObject.getJSONObject("body");
		//print the body
		System.out.println(jsonGlossary);
		jsonGlossary= jsonGlossary.getJSONObject("object");
		//print array of smart meters
		System.out.println(jsonGlossary);
		JSONArray jsonGlossary2= jsonGlossary.getJSONArray("meters");
		//print id of one smartmeter
		System.out.println(jsonGlossary2.get(1));
		
		ArrayList<JSONArray> meterIdList = new ArrayList<JSONArray>();
		
		//print testing loop
		System.out.println("\n\n TEST: LOOP \n\n");

		//get smartmeter array
		JSONArray meterArray = meters(responseMeters, "object", "meters");
		//print meters array
		System.out.println("MeterArray:\t"+meterArray);
		//go through all smartmeters
		for(int i=0; i<meterArray.length();i++){
			//print every meter
			System.out.print("\nmeter "+i+" "+meterArray.get(i)+" ");
			//go to current smart meter
			HttpResponse<JsonNode> responseMeter = Unirest.get("http://localhost:7878/meters/{id}").routeParam("id", jsonGlossary2.get(1).toString()).asJson();
			JSONArray metrics = metrics(responseMeter, "array");
			//print meter metrics
			System.out.println("\nmeter metrics:\t"+metrics);
//			JSONObject metricId = metricId(responseMeter, "array", "metricId");
			//print meter metrics
//			System.out.println("\nmetricId:\t"+metricId+"\n");
			for(int j=0; j<metrics.length();j++){
				//print meter details
				System.out.print("meter details "+j+" "+metrics.get(j)+" ");
				
			}
			//see data
//			HttpResponse<JsonNode> responseData = Unirest.get("http://localhost:7878/meters/{id}/data").routeParam("id", jsonGlossary2.get(1).toString()).asJson();
//			System.out.println(metricsObj(responseData,"",""));
		}
		HttpResponse<JsonNode> responseData = Unirest.get("http://localhost:7878/meters/ise1224hi5630/data").asJson();
		System.out.println("\nTEST 2: "+metricsObj(responseData,"",""));
		
	}
	
	public static JSONObject metricsObj(HttpResponse<JsonNode> response, String path1, String path2){
		return (new JSONObject(response)).getJSONObject("body");
	}
	public static JSONArray meters(HttpResponse<JsonNode> response, String path1, String path2){
		return (new JSONObject(response)).getJSONObject("body").getJSONObject(path1).getJSONArray(path2);
	}
	public static JSONArray metrics(HttpResponse<JsonNode> response, String path){
		return (new JSONObject(response)).getJSONObject("body").getJSONArray(path);
	}
	public static JSONObject metricId(HttpResponse<JsonNode> response, String path, String path1){
		return (new JSONObject(response)).getJSONObject("body").getJSONObject(path).getJSONObject(path1);
	}
}