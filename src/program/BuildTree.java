package program;

import type.GraphViz;
import type.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.lang.Math;

public class BuildTree {
	/**初始属性信息*/
	private static String[] attribute;
	private static String[] continuity;
	/**训练集*/
	private static ArrayList<String[]> trainSet=new ArrayList<>();	
	
	/*以下变量用于每次迭代过程中,统计当前数据集的相关信息*/
	/**当前迭代过程中的数据数组*/
	private static ArrayList<String[]> train=new ArrayList<>();;
	/**当前所属类名数组,保存最终分类的名字*/
	private static ArrayList<String> classes;
	/**当前所属类数量数组,保存对应classes的各个分类的数量*/
	private static ArrayList<Integer> classesNum;
	/**对应某列属性,所有的对应属性取值*/
	private static ArrayList<String> value;	
	/**相应value属性取值的数量*/
	private static ArrayList<Integer> valueNum;
	/**value中各个属性取值对应的所属分类数量,
	 * 行号表示对应的属性取值下标,列号代表对应的分类名下标*/
	private static ArrayList<int[]> valueClassNum;
	
	/*以下信息用于保存当期数据集增益计算结果*/
	private double entropy,splitI;
	private static double info;
	
	/**所有构成决策树的节点集合*/
	public ArrayList<Node> node = new ArrayList<>();
	
	
	
	/**计算当前测试集合中最终分类的类名，存储在ArrayList<String> value中；
	 * 各类对应的数量，存储在ArrayList<Integer> valueNum中。*/
	public void countClass(){
		classes=new ArrayList<>();
		classesNum=new ArrayList<>();
		for(int i=0;i<train.size();i++){
			boolean f=false;
			int classIndex=attribute.length;	//类的下标
			if(i==0){
				classes.add(train.get(0)[classIndex]);
				classesNum.add(1);
			}
			else{
				for(int j=0;j<classes.size();j++)
					if(train.get(i)[classIndex].compareTo(classes.get(j))==0){
						f=true;
						int pl=classesNum.get(j);
						classesNum.set(j, pl+1);
						break;
					}
				if(f==false){
					classes.add(train.get(i)[classIndex]);
					classesNum.add(1);
				}
			}
		}
	}
	
	
	/**
	 * 构造方法,处理过程包含属性集合与数据集和的分离,对应变量的初始化
	 * @param arr 读取文件接受到的ArrayList型字符串数组
	 */
	public BuildTree(ArrayList<String[]> arr, String atts[], String cons[], PrintWriter out){
		attribute=atts;
		continuity=cons;
		/*参数arr即初始数据集中的第一行用于记录属性，不属于测试集*/ 
		for(String tmp[]:arr){
			trainSet.add(tmp);
			train.add(tmp);
		}
		countClass();	//计算初始其实分类情况，即最终分为几个类，分别的类名
		
		/*测试集文件读入信息显示*/
		out.println("************************************************************<br>");
		out.println("******************通过文件接受到的测试集信息*****************<br>");
		out.println("************************************************************<br>");
		out.print("测试数据集共有 \n  "+attribute.length+" 个属性，分别为: ");
		for(String t:attribute)
			out.print(t+" ");
		out.print("\n  "+trainSet.size()+" 项数据，");
		out.print("产生 "+classes.size()+" 个类--");
		for(int i=0;i<classes.size();i++)
			out.print(classes.get(i)+":"+classesNum.get(i)+"  ");
		out.println("<br>");
	}
	
	
	/**根据当前数据集最终分类的情况,即利用countClass()函数产生的
	 * 保存在变量classesNum)中的结果,计算当前数据集对应的Information*/
	public static double Info(){
		info=0;
		for(int num:classesNum){
			double p;
			p=(double)num/(double)train.size();
			info+=(-1)*p*Math.log(p)/Math.log(2);
		}
		return info;
	}
	
	
	/**
	 * 
	 * @param input	需要寻找的字符串
	 * @return	分类classes变量中相同分类的对应下标
	 */
	public static int Belong(String input){
		int index=-1;
		for(int i=0;i<classes.size();i++){
			String s=classes.get(i);
			if(s.compareTo(input)==0){
				index=i;
				break;
			}
		}
		return index;
	}
	
	
	/**
	 * 计算训练集某一个属性,即某列,对应的信息增益;同时更新相应属性取值名称，
	 * 数量以及对应的最终分类信息至全局变量中。
	 * @param arrIndex	需计算增益率的属性所对应的列号
	 * @param leaf	用于保存该属性各个取值产生的子数据集是否为叶子节点
	 * @return	信息增益率
	 */
	public double GainRatio(int arrIndex, ArrayList<Integer> leaf){
		/*对应全局变量(缓存计算结果)清空,用于当前数据集合的新一次的计算*/
		value=new ArrayList<>();
		valueNum=new ArrayList<>();
		valueClassNum=new ArrayList<>();
		double ratio=0;	//信息增益初始化
		/*遍历当前训练集合,统计该属性的所有取值、个数，以及对应的分类的数量*/
		for(int i=0;i<train.size();i++){
			String dat[]=train.get(i);
			boolean fla=false;
			if(i==0){
				value.add(dat[arrIndex]);
				valueNum.add(1);
				int[] a=new int[classes.size()];
				a[Belong(dat[attribute.length])]=1;
				valueClassNum.add(a);
				leaf.add(-1);
				continue;
			}
			for(int j=0;j<value.size();j++){
				if(value.get(j).compareTo(dat[arrIndex])==0){
					int tmp=valueNum.get(j);
					tmp++;
					valueNum.set(j, tmp);
					int[] a=valueClassNum.get(j);
					a[Belong(dat[attribute.length])]++;
					valueClassNum.set(j,a);
					fla=true;
					break;
				}
			}
			if(!fla){
					value.add(dat[arrIndex]);
					valueNum.add(1);
					int[] a=new int[classes.size()];
					a[Belong(dat[attribute.length])]++;
					valueClassNum.add(a);
					leaf.add(-1);
			}
		}
		/*根据属性取值对应分类的统计结果，如果该属性取值全部对应某一类，
		 * 则记其为叶子节点，通过修改leaf数组对应取值为类下标，
		 * 如不是叶子节点，则保留之前初始化的int值，-1*/
		for(int i=0;i<valueClassNum.size();i++)
			for(int j=0;j<classes.size();j++)
				if(valueClassNum.get(i)[j]==valueNum.get(i)){
					leaf.set(i,j);
					break;
				}
		entropy=0;
		splitI=0;
		/*计算该属性（该列）的Entropy和SplitI*/
		for(int i=0;i<valueNum.size();i++){
			double p;
			double tmp=0;
			p=(double)valueNum.get(i)/(double)train.size();
			if(p!=1)
				splitI+=(-1)*p*Math.log(p)/Math.log(2);
			for(int j=0;j<classes.size();j++){
				double q;
				q=(double)valueClassNum.get(i)[j]/(double)valueNum.get(i);
				if(q==0||q==1) tmp=0;
				else tmp+=(-1)*q*Math.log(q)/Math.log(2);
			}
			entropy+=(double)valueNum.get(i)/train.size()*tmp;
		}
		double information=Info();
		ratio=(information-entropy)/splitI;
		return ratio;
	}
	
	

	
	public void SetFather(String lastAtt, String attValue, int count, PrintWriter out){
		int fa=-1;
		for(int i=node.size()-1;i>=0;i--)
			if(node.get(i).name.compareTo(lastAtt)==0){
				fa=i;
				break;
			}
		if(fa==-1){
			out.println("未找到父节点！<br>");
			System.exit(-1);
		}
		
		for(int i=0;i<node.get(fa).value.size();i++)
			if(node.get(fa).value.get(i).compareTo(attValue)==0){
				node.get(fa).child.set(i, count);
				node.get(fa).childVal.set(i, node.get(count).name);
				node.get(count).father=fa;
				break;
			}
		return;
	}
	
	
	double fenjie;	//记录用于分界值
	public double ConHandle(ArrayList<String[]> oldSet, int index){
		//将连续性取值的所有数据保存到该数组
		double num[] = new double[oldSet.size()];
		for(int i=0;i<oldSet.size();i++)
			num[i] = Double.parseDouble(oldSet.get(i)[index]);
		//将整型数据按照从小到大的顺序排列
		for(int i=0;i<num.length-1;i++)
			for(int j=i+1;j<num.length;j++)
				if(num[i]>num[j]){
					double swap=num[i];
					num[i]=num[j];
					num[j]=swap;
				}
		double last=-1;	//记录上一次用于分界的整数
		double minEntr=100;
		double maxGain=-1;
		ArrayList<Integer> newLeaf;
		for(int i=0;i<num.length-1;i++){
			double now=num[i];		//获得分解值
			if(i!=0&&now==last)	//如果与上次分界值取值相同，跳过本次循环
				continue;
			int bigCount=0,smallCount=0;
			for(int j=0;j<oldSet.size();j++){
				String getVal[] = Arrays.copyOf(oldSet.get(j), oldSet.get(j).length);
				//获取该数据的对应整形取值
				int getCon = Integer.parseInt(getVal[index]);
				if(getCon>now){
					getVal[index]=">"+now;
					train.set(j,getVal);
					bigCount++;
				}else{
					getVal[index]="<="+now;
					train.set(j,getVal);
					smallCount++;
				}
			}
			if(smallCount<0.1*train.size()||bigCount<0.1*train.size())
				continue;
			
			newLeaf=new ArrayList<>();
			double tmp=	GainRatio(index,newLeaf);
			double nowEntr = entropy;	//全局变量entropy中保存得到的信息量
			//out.print(now+"-I:"+info+"-E:"+nowEntr+"-G:"+tmp+" ");
			if(nowEntr<minEntr){
				fenjie=now;
				minEntr=nowEntr;
				maxGain=tmp;
				}
			last=now;	//更新上一次的分界值
		}
		return maxGain;
	}
	
	
	String attValue,lastAtt;
	public void Run(ArrayList<String[]> oldSet, boolean use[], PrintWriter out){
		if(oldSet.size()==0)
			return;
			
		int count=0;
		for(boolean test:use)
			if(test==true)
				count++;
		if(count==attribute.length)
			return;
		
		ArrayList<Integer> newLeaf=new ArrayList<>();
		int index=0;
		double cmp=0;
		double newfenjie=0;
		for(int i=0;i<attribute.length;i++){
			newLeaf=new ArrayList<>();
			if(use[i]) continue;
			
			/*处理连续性取值*/
			if(continuity[i].equals("Num")){
				double gr = ConHandle(oldSet, i);
				if(cmp<gr){
					newfenjie=fenjie;
					index=i;
					cmp=gr;
				}
				//out.println();
				out.println(attribute[i]+" \t I = "+info+"， E = "+entropy+"， GR = "+gr+"， 分界值："+fenjie+"<br>");
			}else{
				//当该属性为普通的字符串String取值时
				double gr=GainRatio(i,newLeaf);
				if(cmp<gr){
					index=i;
					cmp=gr;
				}
				out.println(attribute[i]+" \t I = "+info+"， E = "+entropy+"， GR = "+gr+"<br>");
			}
		}
		if(continuity[index].equals("Num")){
			for(int j=0;j<oldSet.size();j++){
				String getVal[] = Arrays.copyOf(oldSet.get(j), oldSet.get(j).length);
				//获取该数据的对应整形取值
				int getCon = Integer.parseInt(getVal[index]);
				if(getCon>newfenjie){
					getVal[index]=">"+newfenjie;
					train.set(j,getVal);
				}else{
					getVal[index]="<="+newfenjie;
					train.set(j,getVal);
				}
			}
		}
		use[index]=true;
		newLeaf=new ArrayList<>();
		GainRatio(index,newLeaf);
		
		if(node.size()==0){		//根节点
			out.println("<br>");
			out.println("*************************************************************<br>");
			out.println("<br>");
			out.println("该节点为根节点<br>");
			Node tmp=new Node(attribute[index],value);
			for(int i=0;i<value.size();i++){
				if(newLeaf.get(i)==-1)
					tmp.childVal.add("Not Leaf！");
				else
					tmp.childVal.add(classes.get(newLeaf.get(i)));
			}
			node.add(tmp);
		}
		else{
			out.println("<br>");
			out.println("*************************************************************<br>");
			out.println("<br>");
			out.println("该节点为"+lastAtt+"的子节点,取值为"+attValue+"<br>");
			Node tmp=new Node(attribute[index],value);
			int indexTmp=node.size();
			for(int i=0;i<value.size();i++){
				if(newLeaf.get(i)==-1)
					tmp.childVal.add("Not Leaf！");
				else
					tmp.childVal.add(classes.get(newLeaf.get(i)));
			}
			node.add(tmp);
			SetFather(lastAtt,attValue,indexTmp,out);
		}
		out.println("节点名："+attribute[index]+"<br>");
		out.println("有"+value.size()+"个，属性取值，分别为：<br>");
		for(int i=0;i<value.size();i++)
			if(newLeaf.get(i)==-1)
				out.println(value.get(i)+"\t不是叶子节点<br>");
			else
				out.println(value.get(i)+"\t是"+classes.get(newLeaf.get(i))+"叶子节点<br>");
		
		ArrayList<String> valueTmp=new ArrayList<>();
		for(int i=0;i<value.size();i++)
			valueTmp.add(value.get(i));
		for(int x=0;x<valueTmp.size();x++){
			ArrayList<String[]> newSet=new ArrayList<>();
			boolean[] newUse=Arrays.copyOf(use,use.length);
			attValue=new String(valueTmp.get(x));
			train=new ArrayList<>();
			if(newLeaf.get(x)!=-1)		//如果为叶子节点，不需要迭代
				continue;
			for(int y=0;y<oldSet.size();y++){
				String s[]=oldSet.get(y);
				if(continuity[index].equals("Num")){
					String getVal[] = oldSet.get(y);
					double cmpInt=Double.parseDouble(getVal[index]);
					String cmpStr;
					if(cmpInt>newfenjie){
						cmpStr=">"+newfenjie;
					}else{
						cmpStr="<="+newfenjie;
					}
					if(cmpStr.equals(valueTmp.get(x))){
						newSet.add(s);
						train.add(s);
					}
				}else{
					if(s[index].compareTo(valueTmp.get(x))==0){
						newSet.add(s);
						train.add(s);
						}
					}
			}
			countClass();
			lastAtt=new String(attribute[index]);
			Run(newSet,newUse,out);
		}
	}
	
	public void init(PrintWriter out, String args[]){

		out.println("<br>");
		out.println("************************************************************<br>");
		out.println("********************开始训练C4.5决策树模型*******************<br>");
		out.println("************************************************************<br>");
		boolean use[]=new boolean[attribute.length];	
		Run(trainSet,use,out);
		
		out.println("<br>");
		out.println("*************************************************************<br>");
		out.println("**********以下是用于绘制C4.5树形规则结构的GraphViz代码**********<br>");
		out.println("*************************************************************<br>");
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		for(int i=0;i<node.size();i++)
			gv.addln(i+"[label=\""+node.get(i).name+"\",shape=box];");
		int tmp=-1;
		for(int i=0;i<node.size();i++)
			for(int j=0;j<node.get(i).child.size();j++){
				int dex=node.get(i).child.get(j);
				if(dex==-1){
					gv.addln(tmp+"[label=\""+node.get(i).childVal.get(j)+"\"];");
					gv.addln(i+"->"+tmp+"[label=\""+node.get(i).value.get(j)+"\"];");
					tmp--;
				}
				else
					gv.addln(i+"->"+dex+"[label=\""+node.get(i).value.get(j)+"\"];");
				
			}
		gv.addln(gv.end_graph());
		out.println(gv.getDotSource()+"<br>");
		String type = "gif";
        File fileout = new File(args[2]+"/tree." + type);
        gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), fileout );
        fileout = new File(args[3]+"/tree." + type);
        gv.writeGraphToFile( gv.getGraph( gv.getDotSource(), type ), fileout );
	}
}
