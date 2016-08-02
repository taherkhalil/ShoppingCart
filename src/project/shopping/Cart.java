package project.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class Cart
 */
// @WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Integer, String> map = new HashMap<Integer, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if (request.getParameter("add") != null) {
			System.out.println("add got");
			String[] shopingItems = request.getParameterValues("items");
			for (int i = 0; i < shopingItems.length; i++) {
				map.put(new Integer(i + 1), shopingItems[i]);
			}

			request.setAttribute("map", map);
			request.getRequestDispatcher("Display.jsp").include(request, response);
			

		} else if (request.getParameter("del") != null) {
			
			int key = Integer.parseInt(request.getParameter("key"));
		
			map.remove(key);
			request.setAttribute("map", map);
//			out.println("Item deleted successfully\n\n");
			
			request.getRequestDispatcher("Display.jsp").include(request, response);
			//request.getRequestDispatcher("logout.jsp").include(request, response);
		}

	}

}
