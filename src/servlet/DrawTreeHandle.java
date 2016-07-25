package servlet;

import program.Input;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DrawTreeHandle
 */
@WebServlet("/DrawTreeHandle")
public class DrawTreeHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrawTreeHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//训练集文件路径
		String dataPath = 
				"/home/hadoop/ParallelDecisionSystem/DecisionTree/data.txt";
		String attPath = 
				"/home/hadoop/ParallelDecisionSystem/DecisionTree/att.txt";
		String args[] = new String[4];
		args[0] = "/home/hadoop/ParallelDecisionSystem/DecisionTree/data.txt";
		args[1] = "/home/hadoop/ParallelDecisionSystem/DecisionTree/att.txt";
		args[2] = "/home/hadoop/ParallelDecisionSystem/DecisionTree/";
		//用于在网页中显示，存放在tomcat文件夹下
		args[3] = "/home/hadoop/apache-tomcat-7.0.68/wtpwebapps/ParallelDecisionSystem/images/";
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "C4.5决策树算法执行过程";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "+"transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n<body>\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
		
		out.println("<h3><a href='tree.jsp?picture=yes'>返回</a></h3>");
		
		//调用分割类的方法，开始分割数据集文件
		Input.main(args, out);
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
