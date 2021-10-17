package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;


@WebServlet(urlPatterns = {"/user/welcome"})
public class WelcomeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		String name = "";
		
		HttpSession htSession = req.getSession();
		
		Object obj = req.getAttribute("username");
		
		
		if(obj != null && ((User) obj).getRole().equals("Admin")) {
			
			name = ((User) obj).getName();
			printWriter.println("<h1>Welcome "+ name +"</h1> <br>");
			printWriter.println("<a href = '/Section04/user/logout'> Logout Account </a>");
			
		} else {
			resp.sendRedirect("/Section04/user/login");
		}
		
	}
	
	
}
