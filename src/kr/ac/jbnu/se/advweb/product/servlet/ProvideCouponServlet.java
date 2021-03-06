package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jbnu.se.advweb.product.model.Coupon;
import kr.ac.jbnu.se.advweb.product.model.Product;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class ProvideCouponServlet 관리자가 회원에게 쿠폰을 지급하기 위한 서블릿
 */
@WebServlet(urlPatterns = { "/providecoupon" })
public class ProvideCouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProvideCouponServlet() {
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/provideCouponView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 1. 입력 받은 쿠폰의 객체를 생성한다.
		Coupon coupon = new Coupon();
		
		String userId = request.getParameter("userId");
		coupon.setUserId(userId);
		
		String couponName = request.getParameter("userId");
		coupon.setCouponName(couponName);
		
		String discountRateStr = request.getParameter("discountRate");
		int discountRate = Integer.parseInt(discountRateStr);
		coupon.setDiscountRate(discountRate);

		String year = request.getParameter("year");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		Date period = transformDate(year, month, day);
		coupon.setPeriod(period);

//		String serialNumberStr = request.getParameter("serialNumber");
//		int serialNumber = Integer.parseInt(serialNumberStr);
//		coupon.setSerialNumber(serialNumber);


		// 2. 생성한 객체를 Coupon table에 넣는다.
		Connection conn = MyUtils.getStoredConnection(request);

		String errorString = null;

		try {
			DBUtils.insertCoupon(conn, coupon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/provideCouponView.jsp");
		dispatcher.forward(request, response);
		// 3. 쿠폰 발급 화면으로 다시 넘어간다.
	}

	public Date transformDate(String year, String month, String day) {
		String date = year + "-" + month + "-" + day;
		Date d = Date.valueOf(date);

		return d;
	}

}
