package uniform_number;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;

@WebServlet(urlPatterns = { "/login" })
public class LoginAction extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			//セッションの開始
			HttpSession session=request.getSession();

			String name = request.getParameter("user");
			String password = request.getParameter("password");
			UserDAO dao = new UserDAO();
			User user = dao.login(name, password);

			if(user != null) {
				session.setAttribute("login", name);
				session.setMaxInactiveInterval(60);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}

			List<String> LoginErrorList = new ArrayList<>();
			LoginErrorList.add("名前もしくはパスワードが違います");
			request.setAttribute("LoginError", LoginErrorList);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
