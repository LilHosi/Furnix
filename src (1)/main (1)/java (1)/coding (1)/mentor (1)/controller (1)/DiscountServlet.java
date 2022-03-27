package coding.mentor.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.DiscountCodeDAO;
import coding.mentor.entity.DiscountCode;

/**
 * Servlet implementation class DiscountServlet
 */
@WebServlet("/DiscountServlet")
public class DiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DiscountCodeDAO discountCodeDAO = new DiscountCodeDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String discountCodeName = request.getParameter("discountCode");
		Float subtotal = (Float) request.getSession().getAttribute("subtotal");
		try {
			DiscountCode discountCode = discountCodeDAO.getDiscountCode(discountCodeName);
			if (discountCode == null) {
				request.setAttribute("WrongMes", "The code does not Exist");
			} else {
				LocalDate today = LocalDate.now();
				LocalDate discountCodeExpiredDate = LocalDate.parse(discountCode.getExpiredDate());
				if (today.isAfter(discountCodeExpiredDate) == true) {
					request.setAttribute("WrongMes", "Code Expired");
				} else {
					int amount = discountCode.getAmount();
					subtotal = subtotal * 100 / (100-amount);
				}
			}
			request.getSession().setAttribute("subtotal", subtotal);
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
