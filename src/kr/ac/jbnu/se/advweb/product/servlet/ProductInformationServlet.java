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

import kr.ac.jbnu.se.advweb.product.model.Product;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class ProductInformationServlet
 * 제품의 상세 정보를 보여주기 위한 서블릿
 */
@WebServlet(urlPatterns = { "/productinfo" })
public class ProductInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = MyUtils.getStoredConnection(request);
		 
        String productNumber = (String) request.getParameter("productNumber");
        System.out.println(productNumber);
 
        Product product = null;
        String errorString = null;
 
        try {
            product = DBUtils.findProduct(conn, productNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
		
        request.setAttribute("productNumber", product);
        
		RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productInfomationView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
