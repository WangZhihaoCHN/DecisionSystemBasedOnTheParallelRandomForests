package program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class FileSpliter {
	
	static int treeNum = 4;
	static double getLineRatio = 0.8; 
	static double getAttRatio = 0.7;
	
	//用于记录文件的属性个数
	static int attNum;
	//用于记录文件的记录个数（即行数）
	static int total;
	
	public FileSpliter(int tree, double lineRatio, double attRatio){
		treeNum = tree;
		getLineRatio = lineRatio;
		getAttRatio = attRatio;
	}
	
	/**
	 * 接收一个文件名，计算其有效数据的行数、属性的个数。
	 * @param fname	文件名
	 * @return	文件的行数
	 * @throws IOException
	 */
	static void countFileLineNum(String fname) throws IOException{
		total = 0;
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(fname)));
		String line = reader.readLine();
		while(line != null){
			if(total==0){
				String split[] = line.split(",");
				attNum = split.length - 1;
			}
			total++;
			line = reader.readLine();
		}
		reader.close();
	}
	
	/*
	 *    之后的两个函数完成的是快速排序，即通过参数接受一个整型数组以及其首尾下标，
	 * 将升序排列的数组作为返回值。
	 * */
	static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low];    //数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] > tmp) {
				high--;
			}
			list[low] = list[high];   //比中轴小的记录移到低端
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low];   //比中轴大的记录移到高端
		}
		list[low] = tmp;              //中轴记录到尾
		return low;                   //返回中轴的位置
	}
	
	static void quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high);  //将list数组进行一分为二
			quickSort(list, low, middle - 1);        //对低字表进行递归排序
			quickSort(list, middle + 1, high);       //对高字表进行递归排序
		}
	}
	
	static void splitAttFile(String in, String out,int att[]) throws IOException{
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(in)));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(out)));
		int currentLineNum = 0;
		int index = 0;
		String line;
		while(currentLineNum < attNum){
			line = reader.readLine();
			if(currentLineNum == att[index]){
				writer.write(line);
				writer.newLine();
				if(index < att.length - 1)
					index++;
			}
			currentLineNum++;
		}
		line = reader.readLine();
		writer.write(line);
		reader.close();
		writer.close();
	}
	
	/**
	 * 	  该方法接收原数据文件，根据已经形成的随机数下标抽取特定行数的数据，
	 * 其中每条数据只选择特定的下标，返回形成的新数据子文件。
	 * @param in	原数据文件地址
	 * @param out	输出文件地址
	 * @param total	原数据文件的行数
	 * @param random	应该选取的行数
	 * @param att	应该选取的属性下标
	 * @throws IOException
	 */
	static void splitFile(String in, String out, int total, 
			int random[], int att[]) throws IOException{
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(in)));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(out)));
		int currentLineNum = 0;
		int index = 0;
		String line,words;
		while(currentLineNum < total){
			currentLineNum++;
			line = reader.readLine();
			String split[] = line.split(",");
			if(currentLineNum == random[index]){
				words = "";
				for(int ind:att)
					words += (split[ind]+"\t");
				words += split[split.length-1];
				writer.write(words);
				writer.newLine();
				while(true){
					index++;
					if(index >= random.length){
						index--;
						break;
					}
					if(currentLineNum == random[index]){
						writer.write(words);
						writer.newLine();
					}else
						break;
				}
			}
		}
		reader.close();
		writer.close();
	}
	
	/**
	 * 该方法实现随机抽样，即不放回抽样
	 * @param range	抽取范围的最大值，如0~9，该值应为10
	 * @param count	要抽取的个数
	 * @return	随机抽样的得到的数的集合
	 */
	static int[] getSimple(int range, int count){
		int simple[] = new int[count];
		ArrayList<Integer> temp = new ArrayList<>();
		for(int i=0;i<range;i++)
			temp.add(i);
		int tmp;
		for(int i=0;i<count;i++){
			Random rand = new Random();
			tmp = Math.abs(rand.nextInt(range-i));
			simple[i] = temp.get(tmp); 
			temp.remove(tmp);
		}
		return simple;
	}
	
	public  void splitMain(String args[], PrintWriter out){
		//String fileName = "inputFile/Data.txt";
		//String outputFileName = "outputFile/split";
		String fileName = args[0];
		String attFileName = args[2];
		String outputFileName = args[1];
		int choose;
		try {
			countFileLineNum(fileName);
			choose = (int) (total*getLineRatio+0.5);
			out.println("<br/>数据集合共有"+total+"条，属性共有"+attNum+"个。<br/>");
			out.println("根据输入,选取行数的 "+getLineRatio+" 为每个分片的数据数目,计算并四舍五入后为 "
					+choose+" 条数据；选取属性的 "+getAttRatio+" 为每个分片所取属性个数,即 "
					+(int)(attNum*getAttRatio+0.5)+" 个。<br/><br/>");
			for(int i=0;i<treeNum;i++){
				out.println("<h2>第"+i+"片分割</h2>");
				String output = outputFileName+ "/data/data_" + i + ".txt";
				String attOutput = outputFileName+ "/att/att_" + i + ".txt";
				Random rand = new Random();
				//该数组用于保存当前树有放回随机抽样的文件行数
				int random[] = new int[choose];
				for(int j=0;j<choose;j++)
					//在制定范围内生成随机数
					random[j] = Math.abs(rand.nextInt(total)) + 1;
				//对数组进行快速排序
				quickSort(random,0,random.length-1);
				out.println("随机选择数据的行号为：<br/>");
				for(int j=0;j<choose;j++)
					out.print(random[j]+" ");
				out.println("<br/>");
				//该数组用于保存该文件分片应该选取的属性下标
				int getAttNume = (int)(getAttRatio*attNum+0.5);
				int randAtt[] = getSimple(attNum, getAttNume);
				quickSort(randAtt,0,randAtt.length-1);
				out.println("<br/>选取属性的下标为：<br/>");
				for(int j:randAtt)
					out.print(j+" ");
				out.println("<br/>");
				splitAttFile(attFileName,attOutput,randAtt);
				splitFile(fileName,output,total,random,randAtt);
				out.println("<br/>第"+i+"片分割完成!<br/><br/><br/>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}