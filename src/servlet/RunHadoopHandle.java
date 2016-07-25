package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RunHadoopHandle
 */
@WebServlet("/RunHadoopHandle")
public class RunHadoopHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunHadoopHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String doWhat=request.getParameter("do");
		if(doWhat.equals("copy")){	//上传文件到hdfs
			Runtime.getRuntime().exec("/home/hadoop/ParallelDecisionSystem/bin/upload.sh");
			System.out.println("文件已经上传到HDFS！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{	//执行hadoop的MapReduce程序
			Cookie[] cookies = request.getCookies();
			String treeNumString=null;
			for(int i=0;i<cookies.length;i++){
		        if(cookies[i].getName().equals("myDecisionSystem"))
		        	treeNumString = cookies[i].getValue();
	    	}
			int treeNum = 0;
			if(treeNumString!=null)
				treeNum= Integer.parseInt(treeNumString);
			System.out.println("/home/hadoop/ParallelDecisionSystem/bin/training.sh "+treeNum+" hdfs://192.168.1.105:9000/user/hadoop /home/hadoop/ParallelDecisionSystem/rules/rule");
			Runtime.getRuntime().exec("/home/hadoop/ParallelDecisionSystem/bin/training.sh "+treeNum+" hdfs://192.168.1.105:9000/user/hadoop /home/hadoop/ParallelDecisionSystem/rules/rule");
			System.out.println("Map/Reduce任务已提交！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
