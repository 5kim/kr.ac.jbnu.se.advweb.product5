package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderProductServlet 제품 구매(결제)를 위한 서블릿
 */
@WebServlet("/OrderProductServlet")
public class OrderProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderProductServlet() {
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

		// 1. 상품이 원하는 상품인지 재확인 시켜주기 위해서 상품 정보를 가지고 온다. - 이경우 또 DB에서 불러오는게 말이 되나? 일단은 DB로
		// ?? << 이건 고민을 해봐야겠음 아니면 포스트로 보내서 해도 될 듯 함
		// 2. 상품에 대한 정보를 담는다.
		// 3. 주문 화면으로 넘어간다.
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views//orderProductView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
