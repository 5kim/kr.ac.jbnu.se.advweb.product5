package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jbnu.se.advweb.product.utils.DBUtils;

/**
 * Servlet implementation class SearchProductServlet
 * 검색을 하면 제품의 목록을 보여주는 서블릿
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//ㄱ 검색한 단어를 이용한 방법
		
		//ㄱ.1 검색한 단어를 받아온다.
		//ㄱ.2 검색한 단어를 이용하여 DB에서 제품에 대한 정보를 불러온다.
		//ㄱ.3 DB에서 받아온 정보를 배열 넣는다.
		//ㄱ.4 받아온 정보를 화면에 보여준다.
		
		//ㄴ 카테고리를 이용한 방법
		//ㄴ.1 선택한 카테고리 정보를 가지고 온다.
		//ㄴ.2 카테고리 정보를 이용하여 DB에서 제품에 대한 정보를 불러온다.
		//ㄴ.3 DB에서 받아온 정보를 배열에 넣는다.
		//ㄴ.4 받아온 정보를 화면에 보여준다.
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//======단어 검색을 이용 할 경우======
		//1. 검색한 단어를 이용해 DB에서 상품을 검색해온다.
		//2. 검색한 상품 모두를 화면에 보여주어야 하므로 모든 정보를 request에 저장한다.
		//3. 검색화면으로 forward한다.
		
		
		
		doGet(request, response);
	}

}
