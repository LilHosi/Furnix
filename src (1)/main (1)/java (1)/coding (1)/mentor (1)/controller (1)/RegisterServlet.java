package coding.mentor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.AccountDAO;
import coding.mentor.entity.Account;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDAO accountDAO = new AccountDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		PrintWriter out = response.getWriter();
		String pronounce = request.getParameter("pronounce");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String preferredName = request.getParameter("preferredName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("password_confirmation");
		String email = request.getParameter("email");
		String phone = request.getParameter("number");
		if (!passwordConfirm.equals(password)) {
			request.setAttribute("mes", "Password not the same. Enter again");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		} else {
			try {
				Account account = accountDAO.checkAccountExist(username);
				if (account == null) {
					accountDAO.registerAccount(pronounce, firstName, lastName, preferredName, username, email, password, phone);
					out.println("<script>");
	                out.println("alert('Account created.');");
	                out.println("location='HomeServlet';");
	                out.println("</script>");
//					response.sendRedirect("HomeServlet");
				} else {
					out.println("<script>");
	                out.println("alert('Account existed. Please login');");
	                out.println("location='login.jsp';");
	                out.println("</script>");
//					response.sendRedirect("login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}