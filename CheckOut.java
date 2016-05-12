package xyz;
import java.io.IOException;
import java.io.PrintWriter;
 import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.LoginBean;
/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getSession().setAttribute("qty",request.getParameter("qty"));
		String forcheck = request.getParameter("cty");
		System.out.println("this ilkjgfdss buy.jsp"+forcheck);
		forcheck = forcheck.substring(1,forcheck.length());
		if(forcheck.matches("^[0-9]*$"))
		{
			System.out.println("matched");
			response.getWriter().println("1");
			}else{
				response.getWriter().println("invalid quantity");
			return;
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
