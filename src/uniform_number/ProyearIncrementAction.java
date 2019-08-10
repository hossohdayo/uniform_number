package uniform_number;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PlayerDAO;

@WebServlet(urlPatterns= {"/increment"})
public class ProyearIncrementAction extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			HttpSession session=request.getSession();

			String chksession = (String) session.getAttribute("login");
			if(chksession == null) {
				String message = "セッションが切れました";
				request.setAttribute("LogoutMessage", message);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}

			PlayerDAO dao = new PlayerDAO();
			boolean result = dao.pro_year_increment();

			if(result != true){
				String message = "プロ年数の変更に失敗しました";
				request.setAttribute("message", message);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}else{
				String message = "プロ年数を＋1しました";
				request.setAttribute("message", message);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
