import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Methods {
	
	JSONObject obj;
	String resultObj;
	static ArrayList<JSONObject> childList = new ArrayList(); //used by printJSONObject
	static Node result = new Node(); //final JSON String
	
	Methods(){
		obj = new JSONObject();
		result.setName("root");
	}
	
	public JSONObject getJSONObject(){
		return this.obj;
	}
	
	public void printObj(){
		System.out.println(result.getNode());
	}
	void readJSON(String filename){
		JSONParser parser = new JSONParser();
		
		try {
			obj = (JSONObject) parser.parse(new FileReader(filename));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	void printJSONObject(JSONObject obj,boolean isRecursion){
		
		childList.clear();
		
		for(Object key : obj.keySet()){
			
			String keyStr = (String)key;
			Object keyvalue = obj.get(keyStr);
			
			Node n = new Node();
			n.setName(keyStr);
			
			//System.out.println(keyStr);
			
			if(keyvalue instanceof JSONObject){
				printJSONObject((JSONObject)keyvalue,true);
				//loop childList
				for(JSONObject e : childList){
					n.setChildren(e);
				}
				
			}
			else if(keyvalue instanceof JSONArray){
				n.setName("["+keyStr+"]");
				if(((JSONArray) keyvalue).get(0) instanceof JSONObject){
	
					printJSONObject((JSONObject) ((JSONArray) keyvalue).get(0),true);
					//loop childList
					for(JSONObject e : childList){
						n.setChildren(e);
					}
				}
			}
			
			childList.add(n.getNode());
			
			if(!isRecursion)//prints top level leaf node
				result.setChildren(n.getNode());
		}
	
		
	
	}
	

}
