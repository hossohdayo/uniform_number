package uniform_number;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/logout" })
public class LogoutAction extends HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			HttpSession session = request.getSession();
			String LogoutMessage = "ログアウトしました。";

			//セッションが存在する場合
			if(session.getAttribute("login") != null) {
			}else {
				//セッションが存在しない場合
				LogoutMessage = "すでに" + LogoutMessage;
			}

			session.invalidate();
			request.setAttribute("LogoutMessage", LogoutMessage);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}

}
