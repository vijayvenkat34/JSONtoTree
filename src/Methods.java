import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Methods {
	
	JSONObject readJSON(String filename){
		JSONParser parser = new JSONParser();
		
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader(filename));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	void printJSONObject(JSONObject obj,String parent){
		
		for(Object key : obj.keySet()){
			
			//System.out.println("\n"+obj.keySet().toString());
			String keyStr = (String)key;
			Object keyvalue = obj.get(keyStr);
			//String temp = keyvalue.toString();
			
			//System.out.println(keyStr);
			
			
			if(keyvalue instanceof JSONObject){
				
				printJSONObject((JSONObject)keyvalue,keyStr);
				
			}
			else if(keyvalue instanceof JSONArray){
				
				if(((JSONArray) keyvalue).get(0) instanceof JSONObject)
					
					printJSONObject((JSONObject) ((JSONArray) keyvalue).get(0),keyStr);
				
				//System.out.println(((JSONArray) keyvalue).get(0));
			}
			
			Node n = new Node();
			n.data = keyStr;
			n.parent = parent;
			
			System.out.println(n.data+" , "+n.parent);
			
		}
	}
}
