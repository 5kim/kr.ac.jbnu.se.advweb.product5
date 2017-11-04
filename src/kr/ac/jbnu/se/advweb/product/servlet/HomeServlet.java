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

import kr.ac.jbnu.se.advweb.product.model.Cart;
import kr.ac.jbnu.se.advweb.product.model.Product;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

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
	 * 홈 화면에서 보여야하는 목록 1. 로그인, 로그아웃 >> 홈화면 2. 카테고리 >> 상품검색화면 3. 검색창 >> 상품검색화면 4. 오늘의
	 * 추천 >> 상품상세정보화면 5. 홈 화면으로 가는 버튼? >> 홈화면 6.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 오늘의 추천 상품을 가지고 온다. << 오늘의 추천 상품은 어떻게 선정하지?
		// 신상품, 조회수가 많은 상품?
		// 상품의 정보에 대한 테이블도 또 필요하지 안을까? 예를 들어서 그 상품의 조회 고객의 명단이 필요할 것 같다는 생각이 든다.
		// 그냥 이것도 관리자가 자신이 원하는 상품으로 하는게 맞다는 생각이 든다.
		// 따라서 관리자가 원하는 상품을 등록하는 페이지가 필요하며 오늘의 추천에 대한 테이블이 하나 필요 할 것 같다.
		// 1.1 오늘의 추천 테이블에서 모든 정보를 가지고 온다.
		Connection conn = MyUtils.getStoredConnection(request);
		 
        String errorString = null;
        List<Product> list = null;
        try {
            list = DBUtils.queryProduct(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/homeView.jsp");
        dispatcher.forward(request, response);

	}

	/**
	 * 1. 로그인 할 때 아이디, 비밀번호를 받는다. 2. DB에 정보와 일치하는지 판단
	 * 
	 * 2.ㄱ.1 회원의 정보를 회원 객체에 넣고 세션에 저장함. << 세션에 저장하면 유저 정보를 항상 불러올 필요가 없을 듯함. 2.ㄱ.2
	 * 정보가 일치할 때 로그인부분 이었던 곳이 간략한 회원의 정보를 표시하게 바뀜
	 * 
	 * 2.ㄴ.1 회원의 정보가 불일치시 다시금 입력하게 한다. << 아예 로그인 화면을 따로 두는 것도 나쁘지 않은 선택인듯함
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}