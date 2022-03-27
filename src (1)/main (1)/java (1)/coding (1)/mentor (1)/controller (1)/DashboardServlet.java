package coding.mentor.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.AccountDAO;
import coding.mentor.dao.CategoryDAO;
import coding.mentor.dao.DiscountCodeDAO;
import coding.mentor.dao.OrderDAO;
import coding.mentor.dao.ProductDetailDAO;
import coding.mentor.dto.OrderDetailDTO;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryDAO categoryDAO = new CategoryDAO();
	ProductDetailDAO productDAO = new ProductDetailDAO();
	AccountDAO accountDAO = new AccountDAO();
	OrderDAO orderDAO = new OrderDAO();
	DiscountCodeDAO discountCodeDAO = new DiscountCodeDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            int countCategory = categoryDAO.getTotalCategory();
            int countProduct = productDAO.getTotalProduct();
            int countAccount = accountDAO.getTotalAccount();
            int countOrder = orderDAO.getTotalOrder();
            int countDiscountCode = discountCodeDAO.getTotalDiscountCode();
            String thisMonth = String.format("%02d", LocalDate.now().getMonthValue());
            List<OrderDetailDTO> bestSeller = orderDAO.getBestSellerProduct(thisMonth);
            float income = orderDAO.incomePerMonth(thisMonth);
            request.setAttribute("countCategory", countCategory);
            request.setAttribute("countProduct", countProduct);
            request.setAttribute("countAccount", countAccount);
            request.setAttribute("countOrder", countOrder);
            request.setAttribute("countDiscountCode", countDiscountCode);
            request.setAttribute("bestSeller", bestSeller);
            request.setAttribute("income", income);
            RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
