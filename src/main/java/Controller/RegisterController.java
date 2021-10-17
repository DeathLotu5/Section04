package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Model.User;

@WebServlet(urlPatterns = {"/user/register"})
public class RegisterController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.println("<form action = '/Section04/user/register' method = 'post'>");
		printWriter.println("<b>Name</b> <input type ='text' name = 'name' value = 'Enter Your Name' required> <br>");
		printWriter.println("<b>Username</b> <input type ='text' name = 'username' value = 'Enter Your Username' required> <br>");
		printWriter.println("<b>Password</b> <input type ='password' name = 'password' value = 'Enter Your Password' required> <br>");
		printWriter.println("<b>Role</b> <input type ='text' name = 'role' value = 'Enter Your Role' required>");
		printWriter.println("<b>Age</b> <input type ='text' name = 'age' value = 'Enter Your Age' required> <br>");
		printWriter.println("<button type = 'submit'>Conplete</button>");
		printWriter.println("</form>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		
		user.setName(req.getParameter("name"));
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setRole(req.getParameter("role"));
		user.setAge(Integer.parseInt(req.getParameter("age")));
		
		UserDao userDao = new UserDaoImpl();
		
		userDao.CreateUser(user);
		
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.println("<h1>Create Acount Successfully!</h1> <br>");
		
		printWriter.println("<a href = '/Section04/user/login'>Click here to Login now</a>");
		
	}
	
}
