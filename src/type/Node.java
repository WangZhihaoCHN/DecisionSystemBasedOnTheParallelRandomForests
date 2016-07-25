package type;

import java.util.ArrayList;

public class Node{
	public int father;
	public String name;
	public String attVal;
	public ArrayList<String> value=new ArrayList<>();
	public ArrayList<String> childVal=new ArrayList<>();
	public ArrayList<Integer> child=new ArrayList<>();

	public Node(String n, ArrayList<String> val){
		father = -1;
		name=new String(n);
		for(int i=0;i<val.size();i++){
			value.add(val.get(i));
			child.add(-1);	
		}
	}
}