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

import kr.ac.jbnu.se.advweb.product.model.Coupon;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class CouponListServlet 쿠폰 목록을 위한 서블릿
 */
@WebServlet("/couponList")
public class CouponListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CouponListServlet() {
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
		// 1. DB에서 회원의 쿠폰에 대한 정보를 가지고 온다.
		Connection conn = MyUtils.getStoredConnection(request);
		// 세션에 저장된 아이디를 가지고와 넣어준다.

		String errorString = null;
		List<Coupon> list = null;
	

		try {
			list = DBUtils.queryCoupon(conn, MyUtils.getLoginedUser(request.getSession()).getId());
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Store info in request attribute, before forward to views
		// 2. DB에서 가지고온 정보를 request에 넣는다.
		request.setAttribute("errorString", errorString);
		request.setAttribute("couponList", list);

		// 3. 쿠폰 화면으로 넘겨준다.
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/couponListView.jsp");
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
