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
		
//		HttpResponse<String> response = Unirest.get("https://google.com").asString();
//		System.out.println(String.format("Google's status code was: %d", response.getStatus()));
		HttpResponse<JsonNode> response = Unirest.get("http://localhost:7878/meters").asJson();
		JSONObject myObject = new JSONObject(response);
		System.out.println(myObject);
		JSONObject jsonGlossary = myObject.getJSONObject("body");
		System.out.println(jsonGlossary);
		jsonGlossary= jsonGlossary.getJSONObject("object");
		System.out.println(jsonGlossary);
		JSONArray jsonGlossary2= jsonGlossary.getJSONArray("meters");
		System.out.println(jsonGlossary2.get(1));
		
<<<<<<< HEAD
		ArrayList<JSONArray > meterIdList = new ArrayList<JSONArray>();
		for(int i=0; i<jsonGlossary2.length();i++){
//			meterIdList.add(jsonGlossary2.getInt(i));
		}

	
=======
		String url = "http://localhost:7878/meters";
//		HttpResponse<String> response = Unirest.get(url).asString();
//		System.out.println(String.format("Localhost:7878's status code was: %d", response.getStatus()));
		
		//CRUD
		//create via post
		//read via get
		System.out.println(
			"Test Client von"+url+".\n"
			+ "\n"
			+ "Check des Statuscodes: "+Unirest.get(url).asString().getStatus()+".\n"
			+"\n"
			+ "Das ist der Statustext: "+Unirest.get(url).asString().getStatusText()+".\n"
			+"\n"
			+ "Und das steht in dem ganzen drin:\n"+Unirest.get(url).asString().getBody()+"\n"
			+"\n"
			+ "Entity:\n"+Unirest.get(url).asJson().getRawBody().toString()
			);
		
		JSONArray args =  Unirest.get(url).asJson();
		JSONObject json_array = args.optJSONObject(0);

		Iterator<?> keys = json_array.keys();

		while( keys.hasNext() ) {
		    String key = (String) keys.next();
		    System.out.println("Key: " + key);
		    System.out.println("Value: " + json_array.get(key));
		}
		//update via put
		//delete via delete
		
	}
>>>>>>> origin/GeorgsBranchPlayAround1ToModelAfterClassDiagramm10

	}
}
