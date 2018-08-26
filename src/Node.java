import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Node {
	
	//static JSONObject result = new JSONObject();
	
	String name;
	JSONArray children = new JSONArray();
	
	Node(){
		name = "";
	}
	void setName(String name){
		this.name = name;
	}
	
	void setChildren(JSONObject n){
		children.add(n);
	}
	
	JSONObject getNode(){
		JSONObject node = new JSONObject();
		
		node.put("name",this.name);
		if(children.isEmpty()){
			return node;
		}
		node.put("children",this.children);
		
		return node;
		
	}

	
}
