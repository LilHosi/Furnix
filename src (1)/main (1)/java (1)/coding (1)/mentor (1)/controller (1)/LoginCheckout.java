package coding.mentor.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.dao.AccountDAO;
import coding.mentor.dao.StudentDAO;
import coding.mentor.dto.CartDTO;
import coding.mentor.entity.Account;
import coding.mentor.entity.Student;

/**
 * Servlet implementation class LoginCheckout
 */
@WebServlet("/LoginCheckout")
public class LoginCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDAO accountDAO = new AccountDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//go to DB coding_mentor -> table student -> select Student by username=email and password=password
		// if data available -> return 1 record (id, first_name, last_name, email, password)
		// Dao -> collect record from DB -> wrap them into Entity
		// Response to Home.jsp if success (or re-login if fail)
		
		try {
			Account account = accountDAO.getAccountByUsernameAndPassword(username, password);
		
			if (account == null) {
				//login fail
				//System.out.println("cai nay null a nha");
				response.sendRedirect("LoginServlet");
			} else {
				//login success
				//System.out.println(student.toString());
				HttpSession session = request.getSession();
				session.setAttribute("me", account);
				
				if (session.getAttribute("cart") == null)
				{
					session.setAttribute("cart", new CartDTO(new HashMap<>()));
				}
				response.sendRedirect("CartServlet?command=SUBMIT_CART&status=CURRENT CUSTOMER");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
