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

import bean.Player;
import dao.PlayerDAO;


@WebServlet(urlPatterns= {"/search"})
public class SearchAction extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			String team = request.getParameter("team");
			String number = request.getParameter("number");
			Integer number_int = null;

			//バリデーションをリストに格納する
			List<String> error_list = new ArrayList<>();

			if(isNum(number)) {
				//searchメソッドのnumber引数はintなのでキャスト
				number_int = Integer.parseInt(number);
			}else {
				error_list.add("半角数字を入力してください。");
			}

			if(team == null) {
				error_list.add("チーム名を選択してください。");
			}

			if(error_list.size() > 0){
				request.setAttribute("error", error_list);
				request.getRequestDispatcher("search.jsp").forward(request, response);
			}

			PlayerDAO dao = new PlayerDAO();
			List<Player> list = dao.search(team, number);

//			if(list.size() == 0) {
//				error_list.add("対象の選手はいませんでした。");
//			}
//			if(error_list.size() > 0){
//				request.setAttribute("error", error_list);
//				request.getRequestDispatcher("search.jsp").forward(request, response);
//			}

			request.setAttribute("player_list", list);

			request.getRequestDispatcher("player.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

	public boolean isNum(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
}
