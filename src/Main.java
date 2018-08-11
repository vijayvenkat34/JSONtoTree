import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		
		Object obj = null;
		try {
			obj = parser.parse(new FileReader("content.json"));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObject = (JSONObject) obj;
		
		Set<String> rootNodes = jsonObject.keySet();
		Iterator iterator = rootNodes.iterator();
		
		//stack
		Stack<String> stack = new Stack<String>();
		
		while(iterator.hasNext()){
			
			String temp = (String) iterator.next();
			System.out.println(temp);
			stack.push(temp);
			
			Set<String> tempSet = null;
			try{
				//for object
			JSONObject tempObj = (JSONObject) jsonObject.get(temp);
			tempSet = tempObj.keySet();
			}catch(Exception e){
				
				try{
					//for array
					JSONArray tempObj = (JSONArray) jsonObject.get(temp);
					//tempSet = tempObj.keySet();
					
				}catch(Exception e1){
					//for String
					String tempObj = (String) jsonObject.get(temp);
					System.out.println(tempObj);
				}
			}
			
			System.out.println(tempSet);
		}
	
		//System.out.println(jsonObject.keySet());
	}

}
