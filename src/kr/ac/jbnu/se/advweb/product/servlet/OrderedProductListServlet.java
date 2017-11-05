package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jbnu.se.advweb.product.model.Order;
import kr.ac.jbnu.se.advweb.product.model.UserAccount;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class OrderedProductListServlet 구매한 목록 확인을 위한 서블릿
 */
@WebServlet(urlPatterns = { "/orderedlist" })
public class OrderedProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderedProductListServlet() {
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
		Connection conn = MyUtils.getStoredConnection(request);
		List<Order> orderList = null;
		HttpSession session = request.getSession();
		UserAccount userAccount = MyUtils.getLoginedUser(session);
		try {
			orderList = DBUtils.queryUserOrder(conn, userAccount.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("orderList", orderList);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views//orderedProductListView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
