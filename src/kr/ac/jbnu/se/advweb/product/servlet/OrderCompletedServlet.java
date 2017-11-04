package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jbnu.se.advweb.product.model.Order;
import kr.ac.jbnu.se.advweb.product.model.Product;
import kr.ac.jbnu.se.advweb.product.model.UserAccount;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MailUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class OrderCompletedServlet
 * 주문 완료가 표시되는 화면을 위한 서블릿
 */
@WebServlet(urlPatterns = { "/ordercomplete" })
public class OrderCompletedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCompletedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 결제가 완료된 정보를 DB에 저장한다.
		//2. 결제가 완료되었다고 email을 이용하여 보낸다.
		//3. 결제가 완료된 화면을 표현하기 위한 정보를 담는다.
		//4. 결제 완료 창을 띄워준다.
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views//orderCompletedView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object error = null;
		// 받은 정보들이 유효한지 판단 - 이 같은 경우 제대로된 정보를 입력 안한건 자바스크립트로 처리하고 그 이외에 부분으로 쿠폰의 적용 부분을
		// 여기서 확인한다.
		// 0. 에러가 있다면 다시 돌아가게 한다. 그런데 무슨 에러가 있을까?
		if(error != null) {
			response.sendRedirect(request.getContextPath() + "/OrderProductServlet");
			return;
		}
		// 1. 쿠폰을 적용했다면 쿠폰을 가지고 있는 사용자 인지를 확인한다. - 전에 자신이 가지고 있는 쿠폰을 확인 할 수 있는 기능이 필요 주문
		// 할 때 확인 할 수 있게
		// 1.1 카드 번호, 카드 비밀번호, 금액, 쿠폰 활용 여부를 넘겨준다.  form의 형태를 어떻게 할 것인지 정해야함
		
		String productName = request.getParameter("productName");
		String productNumber = request.getParameter("productNumber");
		Product product = new Product();
		//수량에 대한 정보, 가격에 대한 정보를 받아와야함
//		int count = Integer.parseInt(request.getParameter("count"));
//		int price = Integer.parseInt(request.getParameter("price"));
		
		product.setName(productName);
//		product.setPrice(price);
		product.setProductNumber(productNumber);
		String customerName = request.getParameter("name");
		String phoneNum = request.getParameter("contact");
			
		String address = request.getParameter("addr");
		String cardNum = request.getParameter("cardcode");
		String cardPW = request.getParameter("cardpassword");
		String coupon = request.getParameter("coupon"); // 쿠폰의 번호를 가지고 온다.
		
		Connection conn = MyUtils.getStoredConnection(request);
		
		HttpSession session = request.getSession();
		UserAccount userAccount = MyUtils.getLoginedUser(session);
		
		Order order = new Order();
//		order.setCount(count);
		order.setCustromerId(userAccount.getId());
		Calendar oCalendar = Calendar.getInstance( ); 
		Date date = new Date(oCalendar.getTime().getYear(),oCalendar.getTime().getMonth(),oCalendar.getTime().getDay());
		order.setDate(date);
		order.setProductNumber(productNumber);
		//쿠폰이 존재한다면 DB에서 삭제한다.
		// 1.3 사용된 쿠폰이 있을 시 데이터베이스를 업데이트 한다.
		
			try {//쿠폰이 존재하는지 판단해보고 쿠폰을 적용해주어야함
				DBUtils.deleteCoupon(conn, coupon);
				DBUtils.insertOrder(conn, order);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//결제가 완료되었다고 메일을 보내준다.
		
		
		// 금액 적인 부분도 자바스크립트에서 하면됨
		// 이 정보 들을 엔티티에 담는다.
		request.setAttribute("cardNum", cardNum);
		request.setAttribute("cardPW", cardPW);
//		request.setAttribute("price", price);
		request.setAttribute("coupon", coupon);
		
		// 3. 결제 완료 화면으로 넘어간다.
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views//orderCompletedView.jsp");
		dispatcher.forward(request, response);
	}
	
	public Date transformDate(String year, String month, String day) {
		String date = year + "-" + month + "-" + day;
		Date d = Date.valueOf(date);

		return d;
	}

}
