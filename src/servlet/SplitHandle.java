package servlet;

import program.FileSpliter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SplitHandle
 */
@WebServlet("/SplitHandle")
public class SplitHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SplitHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String numOfAtt=request.getParameter("AttNum");
		String numOfData=request.getParameter("DataNum");
		String numOfTree=request.getParameter("TreeNum");
		/*System.out.println(Double.parseDouble(numOfAtt));
		System.out.println(Double.parseDouble(numOfData));
		System.out.println(Integer.parseInt(numOfTree));*/
		
		//设置cookie管理
		boolean findCookie = false;
		Cookie cook = new Cookie("myDecisionSystem",numOfTree);
		cook.setMaxAge(60*60*24*365);
		response.addCookie(cook);
		
		//通过构造方法，输入属性和数量比例，数棵树
		FileSpliter fileSpliter = 
				new FileSpliter(Integer.parseInt(numOfTree),Double.parseDouble(numOfData),Double.parseDouble(numOfAtt));
		String args[] = new String[3];
		args[0] = "/home/hadoop/ParallelDecisionSystem/upload/data.txt";
		args[1] = "/home/hadoop/ParallelDecisionSystem/splits";
		args[2] = "/home/hadoop/ParallelDecisionSystem/upload/att.txt";
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "数据集合分割过程";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "+"transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n<body>\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
		
		out.println("<h3><a href='index.jsp?tree="+Integer.parseInt(numOfTree)+"'>继续</a></h3>");
		
		//调用分割类的方法，开始分割数据集文件
		fileSpliter.splitMain(args, out);
		//javascript弹窗提示处理完毕
		out.println("<script type='text/javascript'/>");
		out.println("alert('处理完成');</script>");
		
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}