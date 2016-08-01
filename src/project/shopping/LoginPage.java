package project.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 @WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap database = new HashMap();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Login Page Called");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession se= request.getSession(true);
		// se.setMaxInactiveInterval(1);
		System.out.println("inside login page");
		System.out.println(request.getParameter("username"));
		String username = request.getParameter("username");
		
		System.out.println(request.getSession(false).getId());

		this.getServletContext().setAttribute("username", username);
	
		response.sendRedirect("Choose.jsp");
	}

}
