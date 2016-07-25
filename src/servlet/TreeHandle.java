package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import program.ConfusionMatrix;

/**
 * Servlet implementation class TreeHandle
 */
@WebServlet("/TreeHandle")
public class TreeHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String attRes=null;
	public String dataRes=null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TreeHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String enconding = "utf-8";	//防止文件名中文乱码
		String fileType = request.getParameter("type");	//区别该jsp上传的文件是数据集还是属性信息
		String adjunctname = null;	//要上传文件的文件名
		String address = "";		//保存到的绝对地址
		int maxFileSize = 2048 * 1024;	//文件大小限制
		int maxMemSize = 20 * 1024;		//内存限制
		String filePath = 
				"/home/hadoop/ParallelDecisionSystem/DecisionTree";
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
			            if(fileType.compareTo("data")==0){	//如果是数据文件
			            	dataRes="上传的文件过大，请选择不超过2M的文件!";
			            	request.setAttribute("dataRes",dataRes);
			            	request.getRequestDispatcher("tree.jsp").forward(request, response);
			            }else{
			            	attRes="上传的文件过大，请选择不超过2M的文件!";
			            	request.setAttribute("attRes",attRes);
			            	request.getRequestDispatcher("tree.jsp").forward(request, response);
			            }
			            	
						return;
		        	}
	            	String adjunctsize = new Long(formitem.getSize()).toString();	//获取上传文件的大小
	            	if((name==null)||(name.equals(""))&&(adjunctsize.equals("0"))){	//如果上传文件为空
	            		System.out.println("数据文件上传操作:上传失败,该用户上传的文件为空!");
	            		String result="上传文件为空，请重新选择!";
	    	            request.setAttribute("result",result);
	    	            if(fileType.compareTo("data")==0){	//如果是数据文件
			            	dataRes="上传文件为空，请重新选择!";
			            	request.setAttribute("dataRes",dataRes);
			            	request.getRequestDispatcher("tree.jsp").forward(request, response);
	    	            }else{
			            	attRes="上传文件为空，请重新选择!";
			            	request.setAttribute("attRes",attRes);
			            	request.getRequestDispatcher("tree.jsp").forward(request, response);
	    	            }
	    	            return;
	            	}
	            	adjunctname = name.substring(name.lastIndexOf("\\")+1,name.length());
	            	if(fileType.compareTo("data")==0){	//如果是数据文件
	            		address = filePath+"/data.txt";
	            	}else{
		            	address = filePath+"/att.txt";
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
    	if(fileType.compareTo("data")==0){	//如果是数据文件
        	dataRes=result;
        	request.setAttribute("dataRes",dataRes);
			request.getRequestDispatcher("tree.jsp").forward(request, response);
    	}else{
        	attRes=result;
        	request.setAttribute("attRes",attRes);
        	request.getRequestDispatcher("tree.jsp").forward(request, response);	
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
