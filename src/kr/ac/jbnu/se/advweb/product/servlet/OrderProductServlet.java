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
		// 받은 정보들이 유효한지 판단 - 이 같은 경우 제대로된 정보를 입력 안한건 자바스크립트로 처리하고 그 이외에 부분으로 쿠폰의 적용 부분을
		// 여기서 확인한다.
		// 0. 에러가 있다면 다시 돌아가게 한다. 그런데 무슨 에러가 있을까?
		// 1. 쿠폰을 적용했다면 쿠폰을 가지고 있는 사용자 인지를 확인한다. - 전에 자신이 가지고 있는 쿠폰을 확인 할 수 있는 기능이 필요 주문
		// 할 때 확인 할 수 있게
		// 1.1 카드 번호, 카드 비밀번호, 금액, 쿠폰 활용 여부를 넘겨준다.  form의 형태를 어떻게 할 것인지 정해야함
		String cardNum = request.getParameter("cardNum");
		String cardPW = request.getParameter("cardPW");
		
		// 1.2 이 정보 들을 엔티티에 담는다.
		// 1.3 사용된 쿠폰이 있을 시 데이터베이스를 업데이트 한다.
		// 2. 여기서는 우리가 할 수 있는게 많지 않으므로 패스
		// 금액 적인 부분도 자바스크립트에서 하면됨
		// 3. 결제 완료 화면으로 넘어간다.
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views//orderCompletedView.jsp");
		doGet(request, response);
	}

}
