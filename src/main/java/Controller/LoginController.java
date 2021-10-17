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

import Dao.UserDao;
import Dao.UserDaoImpl;
import Model.User;
import Service.UserService;
import Service.UserServiceImpl;

@WebServlet(urlPatterns = {"/user/login"})
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.println("<form action = '/Section04/user/login' method = 'post'>");
		printWriter.println("<b>Username</b> <input type = 'text' placeholder = 'Enter Username' name ='username' required> <br>");
		printWriter.println("<b>Password</b> <input type = 'password' placeholder = 'Enter Your Password' name ='password' required> <br>");
		printWriter.println("<input type = 'submit' value = 'Login'> <br>");
		printWriter.println("<p>You don't have a Account <a href = '/Section04/user/register'>Register now</a></p>");
		printWriter.println("</form>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserService userService = new UserServiceImpl();
		
		User user = userService.search(username);
	
		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			
			HttpSession httSession = req.getSession();
			
			httSession.setAttribute("user", user);
		
			
			resp.sendRedirect("/Section04/user/welcome");
		} else {
			
			resp.sendRedirect("/Section04/user/login");
		}
	}
	
}
