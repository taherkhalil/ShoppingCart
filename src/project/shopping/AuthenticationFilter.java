package project.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import project.shopping.*;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
// @WebFilter(dispatcherTypes = {
// DispatcherType.REQUEST,
// DispatcherType.FORWARD,
// DispatcherType.ERROR
// }
// , urlPatterns = { "/AuthenticationFilter" }, servletNames = { "profile" })
public class AuthenticationFilter implements Filter {

	/**
	 * Default constructor.
	 * 
	 */

	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		DataBase db=new DataBase();
		db.setMap();
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			HttpServletRequest request2 = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			System.out.println("filter called");
			if (password.equals(db.database.get(username))) {
		
			System.out.println("logged in");
//			HttpSession session = request2.getSession(true);
//		
//			session.setMaxInactiveInterval(100);
//			session.setAttribute("session", session.getId());
			Cookie cookie= new Cookie("username",username);
			httpResponse.addCookie(cookie);
			cookie.setMaxAge(1*60);
			chain.doFilter(request, response);

		} else {
			
			out.print("Invalid Username or Password");
			System.out.println("Filter redirect to login.jsp");
			request2.getRequestDispatcher("login.jsp").include(request2, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
