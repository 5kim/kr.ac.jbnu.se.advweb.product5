package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 홈화면을 위한 서블릿
 * 
 * @author HongJG
 *
 */

@WebServlet(urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}
	/**
	 * 홈 화면에서 보여야하는 목록
	 * 1. 로그인, 로그아웃 		>> 홈화면
	 * 2. 카테고리  			>> 상품검색화면
	 * 3. 검색창    			>> 상품검색화면
	 * 4. 오늘의 추천			>> 상품상세정보화면
	 * 5. 홈 화면으로 가는 버튼? 	>> 홈화면
	 * 6.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Forward to /WEB-INF/views/homeView.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * 1. 로그인 할 때 아이디, 비밀번호를 받는다.
	 * 2. DB에 정보와 일치하는지 판단
	 * 	
	 * 	2.ㄱ.1 회원의 정보를 회원 객체에 넣고 세션에 저장함. <<  세션에 저장하면 유저 정보를 항상 불러올 필요가 없을 듯함.
	 * 	2.ㄱ.2 정보가 일치할 때 로그인부분 이었던 곳이 간략한 회원의 정보를 표시하게 바뀜
	 * 
	 * 	2.ㄴ.1 회원의 정보가 불일치시 다시금 입력하게 한다. << 아예 로그인 화면을 따로 두는 것도 나쁘지 않은 선택인듯함
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}