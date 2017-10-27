package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditUserInfoServlet
 * 회원정보 수정을 위한 서블릿
 */
@WebServlet("/EditUserInfoServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 현재 회원의 정보를 가지고 온다.
		// 2. 회원 객체에 넣는다.
		// 3. 화면에 보여준다.
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ㄱ 정상적이게 작성했을 경우
		//ㄱ.1 회원의 수정한 정보를 받아 기존의 회원 객체를 업데이트 한다.
		//ㄱ.2 DB에 수정된 회원의 정보를 업데이트 한다.
		//ㄱ.3 회원정보 화면으로 넘어간다.
		
		//ㄴ 비정상적이게 작성 했을 경우 << 이것의 경우는 자바스크립트로 자체적으로 해결이 가능할 듯 함.
		//ㄴ.1 잘못된 정보 입력이라는 메시지를 띄운다.
		//ㄴ.2 어디가 잘못 되었는지 표시를 해주며, 다시 작성하게끔 포커싱을 해준다.
		
		doGet(request, response);
	}

}
