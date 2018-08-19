import java.util.ArrayList;

public class Node {
	static ArrayList<Node> nodeList = new ArrayList<>();
	
	String data;
	String parent;
	boolean isLeaf;
	
	Node(){
		nodeList.add(this);
	}
	
}
