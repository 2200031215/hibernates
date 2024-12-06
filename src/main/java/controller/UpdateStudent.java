package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentManager;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sid = Integer.parseInt(request.getParameter("T1"));
		String sname = request.getParameter("T2");
		String sdept = request.getParameter("T3");
		response.setContentType("text/html");
		PrintWriter PW = response.getWriter();
		try
		{
			Student S = new Student();
			S.setSid(sid);
			S.setSname(sname);
			S.setSdept(sdept);
			
			StudentManager SM = new StudentManager();
			String ack = SM.updateStudent(S);
			PW.println(ack);
		}catch (Exception e) 
		{
			PW.println(e.getMessage());
		}
		RequestDispatcher RD = request.getRequestDispatcher("update.html");
		RD.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
