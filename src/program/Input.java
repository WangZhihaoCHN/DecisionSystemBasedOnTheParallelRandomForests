package program;

import java.io.*;
import java.util.ArrayList;

public class Input{
	
	public static void main(String args[], PrintWriter out){
		int dataCounter=0,attCounter=0;
		int attnum;
		String atts[]=null;
		String cons[]=null;
		
		String tmp;
		String list[];
		ArrayList<String[]> tree=new ArrayList<>();
		try{
			//读数据文件
			BufferedReader attReader=new BufferedReader(
					new FileReader(args[1]));
			attnum=Integer.parseInt(attReader.readLine());
			atts = new String[attnum];
			cons = new String[attnum];
			for(int i=0;i<attnum;i++){
				String line[] = attReader.readLine().split(" ");
				atts[i] = line[0];
				cons[i] = line[1];
			}
			//读属性文件
			BufferedReader br=new BufferedReader(
					new FileReader(args[0]));
			attCounter=atts.length;
			while((tmp=br.readLine())!=null){
				dataCounter++;
				list=tmp.split("\\t+");			//根据Tab分割字符串
				if(list.length!=attCounter+1){
					out.println("Line "+dataCounter+" was missed!<br>");
					System.exit(-1);
				}
				tree.add(list);
			}
			br.close();
		}
		catch(Exception e){
			out.println("File not found!<br>");
		}
		
		BuildTree bt=new BuildTree(tree,atts,cons,out);
		bt.init(out, args);
	}

}
