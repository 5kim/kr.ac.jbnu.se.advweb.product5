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
 * 
 * @author HongJG
 *제품의 정보를 수정하기 위한 서블릿
 */
@WebServlet(urlPatterns = { "/editProduct" })
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditProductServlet() {
        super();
    }
 
    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String productNumber = (String) request.getParameter("productNumber");
 
        Product product = null;
 
        String errorString = null;
 
        try {
            product = DBUtils.findProduct(conn, productNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && product == null) {
            response.sendRedirect(request.getServletPath() + "/productList");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    
    /**
     * 1. 수정한 제품을 제품번호를 통해 선택한다.
     * 2. 제품 번호를 통해 DB에서 정보를 가지고 온다.<<<<< 매번 가지고 와야하는지 ?? 어딘가에 저장해놓고 쓸 수는 없는지? 이전 페이지에서 분명히 한번 접근을 했을 텐데 말이야
     * ======get=======
     * 3. 폼을 이용하여 데이터를 입력받고 DB를 업데이트 한다.
     * 4. 재고관리 화면으로 돌아간다.(수정된 내용이 적용되어 있다.)
     * ======post======
     */
    
    //일단 오류가 인뜨게 해놓은 상태이고 부분 수정할 수 있도록 내부를 수정하는 작업을 진행해야함.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String productNumber = (String) request.getParameter("productNumber");
        String name = (String) request.getParameter("name");
        String priceStr = (String) request.getParameter("price");
		String seller = (String) request.getParameter("seller");
		String description = (String) request.getParameter("description");
		String inventoryStr = (String) request.getParameter("inventory");		
		
		float price = 0;
		int inventory = 0;
		try {
			price = Float.parseFloat(priceStr);
			inventory = Integer.parseInt(inventoryStr);
        } catch (Exception e) {
        }
        Product product = new Product(productNumber, name, price, seller, description, inventory);
 
        String errorString = null;
 
        try {
            DBUtils.updateProduct(conn, product);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }
 
}
