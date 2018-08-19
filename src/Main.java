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

		Methods m = new Methods();
		
		JSONObject obj = m.readJSON("content.json");
		m.printJSONObject(obj,null);
		m.printNodeList();
	
	}
	
}
