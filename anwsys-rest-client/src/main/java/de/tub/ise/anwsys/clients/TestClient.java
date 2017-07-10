package de.tub.ise.anwsys.clients;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TestClient {
	
	public static void main(String[] args) throws IOException, UnirestException {
		
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

}
