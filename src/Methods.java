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
		
		JSONObject node = new JSONObject();//obj
		JSONArray listChild = new JSONArray();//arr of child
		
		for(Object key : obj.keySet()){
			
			
			String keyStr = (String)key;
			Object keyvalue = obj.get(keyStr);
			
			JSONObject child = new JSONObject();//child obj
			
			if(keyvalue instanceof JSONObject){
				//System.out.println(keyStr);
			
				printJSONObject((JSONObject)keyvalue,keyStr);
				//System.out.println(keyStr);

				
			}
			else if(keyvalue instanceof JSONArray){
				
				if(((JSONArray) keyvalue).get(0) instanceof JSONObject){
					node.put("name", keyStr);
					printJSONObject((JSONObject) ((JSONArray) keyvalue).get(0),keyStr);
					//System.out.println(keyStr);
				}else{
					//leaf
					System.out.println("leaf : "+keyStr);
				}
			}else{
				//leaf
				//System.out.println("leaf : "+keyStr);
				child.put("name", keyStr);
			}
			listChild.add(child);
		}
		//System.out.println("\nend of obj ");
		node.put("children", listChild);
		
		System.out.println(node.toString());
	}
	
	void printNodeList(){
		
		for(Node n : Node.nodeList){
			System.out.println(n.data.toString()+" , "+n.parent+" , "+n.isLeaf);
		}
	}
}
