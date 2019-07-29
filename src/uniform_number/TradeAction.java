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

@WebServlet(urlPatterns = { "/trade" })
public class TradeAction extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		try {
			List<Player> TradeList = (List<Player>) session.getAttribute("TradeList");
			String team1 = TradeList.get(0).getTeam_id();
			String number1 = TradeList.get(0).getNumber();
			String team2 = TradeList.get(1).getTeam_id();
			String number2 = TradeList.get(1).getNumber();
			String NewCareer1 = TradeList.get(0).getCareer();
			String NewCareer2 = TradeList.get(1).getCareer();
			int EndCareer1_num = NewCareer1.lastIndexOf("－");
			int EndCareer2_num = NewCareer2.lastIndexOf("－");
			String EndCareer1 = NewCareer1.substring(EndCareer1_num);
			String EndCareer2 = NewCareer2.substring(EndCareer2_num);
			String message;
			//バリデーションをリストに格納する
			List<String> error_list = new ArrayList<>();

			//以下のバリデーションチェックいらない？
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

			if(error_list.size() > 0){
				request.setAttribute("error", error_list);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
				return ;
			}

			PlayerDAO dao = new PlayerDAO();
			boolean flg = dao.trade(team1, number1, team2, number2, EndCareer1, EndCareer2);

			if(flg != true) {
				message = "失敗しました";
				request.setAttribute("message", message);
				session.removeAttribute("TradeList");
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}else {
				message = "完了しました";
				session.removeAttribute("TradeList");
				request.setAttribute("message", message);
				request.getRequestDispatcher("menu.jsp").forward(request, response);
			}

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
