package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jbnu.se.advweb.product.model.Product;
import kr.ac.jbnu.se.advweb.product.model.UserAccount;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class SearchProductServlet 검색을 하면 제품의 목록을 보여주는 서블릿
 */
@WebServlet(urlPatterns = { "/searchproduct" })
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// ㄱ 검색한 단어를 이용한 방법
		// ㄱ.1 검색한 단어를 받아온다.
		String searchWord = request.getParameter("searchWord");
		String category = request.getParameter("category");

		// ㄱ.2 검색한 단어를 이용하여 DB에서 제품에 대한 정보를 불러온다.
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();

		// Check User has logged on
		UserAccount loginedUser = MyUtils.getLoginedUser(session);

		// Not logged in
		if (loginedUser == null) {
			// Redirect to login page.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		// ㄱ.3 DB에서 받아온 정보를 배열 넣는다.

		List<Product> searchList = null;
		// 검색어와 카테고리의 파라미터가 모두 없는 경우 에러를 표현한다.
		if (searchWord == null && category == null) {
			String error = "잘못된 검색 방법입니다.";
			request.setAttribute("error", error);
			// 검색어 만을 이용한 상품 검색
		} else if (searchWord != null && category == null) {
			try {
				searchList = DBUtils.querySearchWord(conn, searchWord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 카테고리만을 이용한 상품 검색
		} else if (searchWord == null && category != null) {
			try {
				searchList = DBUtils.queryCategory(conn, category);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 카테고리와 검색어를 이용한 상품 검색 - 카테고리를 누르고 검색을 하면 이 곳으로 온다.
		} else if (searchWord != null && category != null) {
			try {
				searchList = DBUtils.queryCategoryAndSearchWord(conn, category, searchWord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("searchList", searchList);
		request.setAttribute("itemCount", String.valueOf(searchList.size()) + "개의 상품이 검색되었습니다.");
		// ㄱ.4 받아온 정보를 화면에 보여준다.

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/searchProductView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ======단어 검색을 이용 할 경우======
		// 1. 검색한 단어를 이용해 DB에서 상품을 검색해온다.
		// 2. 검색한 상품 모두를 화면에 보여주어야 하므로 모든 정보를 request에 저장한다.
		// 3. 검색화면으로 forward한다.

		doGet(request, response);
	}

}
