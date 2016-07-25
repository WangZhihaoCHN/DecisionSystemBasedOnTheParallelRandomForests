package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadHandle
 */
@WebServlet("/DownloadHandle")
public class DownloadHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		String num = request.getParameter("count");
		String fileName = null;
		File file = null;
		if(type.equals("data")||type.equals("att")){
			System.out.println("下载分隔片文件");
			fileName = type+"_"+num+".txt";
			file = new File("/home/hadoop/ParallelDecisionSystem/splits/"+type+"/"+fileName);
		}else if(type.equals("rule")){
			System.out.println("下载规则文件");
			fileName = type+num+".txt";
			file = new File("/home/hadoop/ParallelDecisionSystem/rules/"+fileName);
		}else if(type.equals("upload")){
			System.out.println("下载训练集文件");
			fileName = num+".txt";
			file = new File("/home/hadoop/ParallelDecisionSystem/upload/"+fileName);
		}else if(type.equals("test")){
			System.out.println("下载测试集文件");
			fileName = "test.txt";
			file = new File("/home/hadoop/ParallelDecisionSystem/upload/"+fileName);
		}else if(type.equals("picture")){
			System.out.println("下载决策树图片");
			fileName = "tree.gif";
			file = new File("/home/hadoop/Peanut Software/apache-tomcat-7.0.68/wtpwebapps/ParallelDecisionSystem/images/"+fileName);
		}else if(type.equals("result")){
			System.out.println("下载预测结果表格");
			fileName = "ForestOutput.xls";
			file = new File("/home/hadoop/ParallelDecisionSystem/output/"+fileName);
		}
		
		
		if (file.exists()) {	//如果文件存在
			//设置响应类型及响应头
			response.setContentType("application/x-download;charset=UTF-8");
			
			response.addHeader("Content-Disposition", "attachment; filename=\""
					+ fileName + "\"");
			//读取文件
			InputStream inputStream = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			byte[] bytes = new byte[1024];
			ServletOutputStream outStream = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(outStream);
			int readLength = 0;
			while ((readLength = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, readLength);
			}
			//释放资源
			inputStream.close();
			bis.close();
			bos.flush();
			outStream.close();
			bos.close();
		}else{
			System.out.println("所下载的文件:"+file+"不存在");
		}
		//request.getRequestDispatcher("split_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}