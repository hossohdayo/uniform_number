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

import bean.Player;
import dao.PlayerDAO;

@WebServlet(urlPatterns = { "/conf" })
public class TradeConfAction extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//セッションを開始
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		try {
			String team1 = request.getParameter("team1");
			String number1 = request.getParameter("number1");
			String team2 = request.getParameter("team2");
			String number2 = request.getParameter("number2");
			//バリデーションをリストに格納する
			List<String> error_list = new ArrayList<>();

			if(isNum(number1) && isNum(number2)) {
				//文字列のバリデーション
			}else {
				//マスコット対応、ポンタとスターマンが表示されない
				if(number1.equalsIgnoreCase("∞") || number1.equals("!") || number1.contentEquals("☆")) {
				}else {
					error_list.add("半角数字を入力してください。");
				}
			}

			if(team1 == "" || team2 == "") {
				error_list.add("チーム名を選択してください。");
			}

			PlayerDAO dao = new PlayerDAO();
			List<Player> TradeList = dao.conf(team1, number1, team2, number2);

			if(TradeList.size() < 2) {
				error_list.add("対象選手が存在しません。");
			}

			if(error_list.size() > 0){
				request.setAttribute("error", error_list);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
				return ;
			}

			session.setAttribute("TradeList", TradeList);
			request.getRequestDispatcher("menu.jsp").forward(request, response);

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
