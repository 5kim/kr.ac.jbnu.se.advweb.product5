package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jbnu.se.advweb.product.model.UserAccount;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class EditUserInfoServlet 회원정보 수정을 위한 서블릿
 */
@WebServlet(urlPatterns = { "/edituser" })
public class EditUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserInfoServlet() {
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
		// 1. 현재 회원의 정보를 가지고 온다.
		// 2. 회원 객체에 넣는다.
		// 3. 화면에 보여준다.

		HttpSession session = request.getSession();

		// Check User has logged on
		UserAccount loginedUser = MyUtils.getLoginedUser(session);

		// Not logged in
		if (loginedUser == null) {
			// Redirect to login page.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		// Store info to the request attribute before forwarding.
		request.setAttribute("user", loginedUser);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editUserInfoView.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ㄱ 정상적이게 작성했을 경우
		// ㄱ.1 회원의 수정한 정보를 받아 기존의 회원 객체를 업데이트 한다.
		// ㄱ.2 DB에 수정된 회원의 정보를 업데이트 한다.
		// ㄱ.3 회원정보 화면으로 넘어간다.

		// ㄴ 비정상적이게 작성 했을 경우 << 이것의 경우는 자바스크립트로 자체적으로 해결이 가능할 듯 함.
		// ㄴ.1 잘못된 정보 입력이라는 메시지를 띄운다.
		// ㄴ.2 어디가 잘못 되었는지 표시를 해주며, 다시 작성하게끔 포커싱을 해준다.

		Connection conn = MyUtils.getStoredConnection(request);

		String id = (String) request.getParameter("id");
		String password = (String) request.getParameter("password");
		String name = (String) request.getParameter("name");
		String birthStr = (String) request.getParameter("birth");
		String gender = (String) request.getParameter("gender");
		String contactStr = (String) request.getParameter("contact");		
		String email = (String) request.getParameter("email");
		String address = (String) request.getParameter("address");
		
		int birth = 0;
		int contact = 0;
		try {
			birth = Integer.parseInt(birthStr);
			contact = Integer.parseInt(contactStr);
		} catch (Exception e) {
		}
		UserAccount user = new UserAccount(id, password, name, birth, gender, contact, email, address);

		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character
		String regex = "\\w+";

		if (id == null || !id.matches(regex)) {
			errorString = "id invalid!";
		}

		if (errorString == null) {
			try {
				DBUtils.insertUser(conn, user);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("product", user);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editUserInfo.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/home");
		}
	}

}
