package servlet;

import program.ConfusionMatrix;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadHandle
 */
@WebServlet("/UploadHandle")
public class UploadHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String enconding = "utf-8";	//防止文件名中文乱码
		String fileType = request.getParameter("type");	//区别该jsp上传的文件是数据集还是属性信息
		String adjunctname = null;	//要上传文件的文件名
		String address = "";		//保存到的绝对地址
		int maxFileSize = 2048 * 1024;	//文件大小限制
		int maxMemSize = 20 * 1024;		//内存限制
		String filePath = 
				"/home/hadoop/ParallelDecisionSystem/upload";
		if(ServletFileUpload.isMultipartContent(request)){	//判断是否是上传文件
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置内存中存储文件的最大值，也是服务器本地存储数据的最大值maxMemSize
			factory.setSizeThreshold(maxMemSize);
			//设置临时目录
			factory.setRepository(factory.getRepository());
			//创建一个新的文件上传处理程序
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding(enconding);	//防止文件名中文乱码
			//设置最大上传的文件大小
			//upload.setSizeMax(maxFileSize);
			List formlists = null;
			try{
				formlists = upload.parseRequest(request);
			}catch(FileUploadException e){
				e.printStackTrace();
			}
			Iterator iter = formlists.iterator();
			while(iter.hasNext()){
				FileItem formitem = (FileItem) iter.next();
				if(!formitem.isFormField()){		//忽略不是上传文件的表单域
	            	//获取上传文件的名称
	            	String name = formitem.getName();
					if(formitem.getSize()>maxFileSize){
						System.out.println("数据文件上传操作:上传失败,该用户上传的文件超过2M!");
		        		String result="上传的文件过大，请选择不超过2M的文件!";
			            request.setAttribute("result",result);
			            if(fileType.compareTo("data")==0)	//如果是数据文件
			            	request.getRequestDispatcher("upload_data.jsp").forward(request, response);
			            else if(fileType.compareTo("att")==0)
			            	request.getRequestDispatcher("upload_att.jsp").forward(request, response);
			            else
			            	request.getRequestDispatcher("upload_test.jsp").forward(request, response);
			            	
						return;
		        	}
	            	String adjunctsize = new Long(formitem.getSize()).toString();	//获取上传文件的大小
	            	if((name==null)||(name.equals(""))&&(adjunctsize.equals("0"))){	//如果上传文件为空
	            		System.out.println("数据文件上传操作:上传失败,该用户上传的文件为空!");
	            		String result="上传文件为空，请重新选择!";
	    	            request.setAttribute("result",result);
	    	            if(fileType.compareTo("data")==0)	//如果是数据文件
			            	request.getRequestDispatcher("upload_data.jsp").forward(request, response);
	    	            else if(fileType.compareTo("att")==0)
			            	request.getRequestDispatcher("upload_att.jsp").forward(request, response);
	    	            else
			            	request.getRequestDispatcher("upload_test.jsp").forward(request, response);
	    	            return;
	            	}
	            	adjunctname = name.substring(name.lastIndexOf("\\")+1,name.length());
	            	if(fileType.compareTo("data")==0){	//如果是数据文件
	            		address = filePath+"/data.txt";
	            	}else if(fileType.compareTo("att")==0){
		            	address = filePath+"/att.txt";
	            	}else{
	            		address = filePath+"/test.txt";
	            	}
	        		File saveFile = new File(address);
	        		//System.out.println(webPath);
	        		try{
	        			formitem.write(saveFile);
	        		}catch(Exception e){
	        			e.printStackTrace();
	        		}
		        }
			}
		}
    	String result="文件 "+adjunctname+" 上传成功，请继续填写!";
    	//System.out.println("文件："+fileName+",上传至服务器");
    	System.out.println("文件上传操作:上传成功,"+adjunctname+"重命名后放置于 "+address);
    	request.setAttribute("result",result);
    	if(fileType.compareTo("data")==0)	//如果是数据文件
			request.getRequestDispatcher("upload_data.jsp").forward(request, response);
    	else if(fileType.compareTo("att")==0)
        	request.getRequestDispatcher("upload_att.jsp").forward(request, response);	
    	else{	//上传测试集合成功后，跳转到结果显示界面
    		String args[] = new String[5];
    		args[0] = "/home/hadoop/ParallelDecisionSystem/splits/att/";	//属性分片文件
    		args[1] = "/home/hadoop/ParallelDecisionSystem/rules/rule";	//规则文件路径
    		args[2] = "/home/hadoop/ParallelDecisionSystem/upload/att.txt";	//原始属性文件
    		args[3] = "/home/hadoop/ParallelDecisionSystem/upload/test.txt";	//测试集合
    		args[4] = "/home/hadoop/ParallelDecisionSystem/output/ForestOutput.xls";	//测试结果表格存放路径
    		ConfusionMatrix cm = new ConfusionMatrix();
    		int matrix[][] = cm.matrixMain(args);
    		request.setAttribute("matrix",matrix);
    		String[] classValue = cm.classValue;
    		request.setAttribute("classValue",classValue); 
    		request.getRequestDispatcher("test_result.jsp").forward(request, response);
    	}	
    	return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}