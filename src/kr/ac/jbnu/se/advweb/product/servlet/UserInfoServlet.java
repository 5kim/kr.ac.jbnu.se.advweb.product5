package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jbnu.se.advweb.product.model.UserAccount;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * 회원정보를 위한 서블릿
 * @author HongJG
 *
 */
@WebServlet(urlPatterns = { "/userInfo" })
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String moreInfo = request.getParameter("more");

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

		if( moreInfo == null)
		{
			// If the user has logged in, then forward to the page
			// /WEB-INF/views/userInfoView.jsp
			RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/additionalUserInfoView.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 받은 유저 정보를 DB에 저장한다.
		//2. 유저 객체를 수정한 정보로 업데이트한다.
		//3. 세션의 회원 정보 또한 업데이트 해준다.
		//4. 수정된 회원 정보를 보여준다.
		
		doGet(request, response);
	}

}