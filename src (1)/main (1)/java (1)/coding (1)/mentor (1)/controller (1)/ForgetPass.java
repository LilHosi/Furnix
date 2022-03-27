package coding.mentor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.dao.AccountDAO;
import coding.mentor.entity.Account;
import coding.mentor.util.DataUtil;

/**
 * Servlet implementation class ForgetPass
 */
@WebServlet("/ForgetPass")
public class ForgetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDAO accountDAO = new AccountDAO();
    DataUtil dataUtil = new DataUtil();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPass() {
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
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        
        try {
        	Account account = accountDAO.getAccountByUsernameAndEmail(username, email);
        
            if (account == null) {
            	request.setAttribute("mes", "Wrong login detail");
            	RequestDispatcher rd = request.getRequestDispatcher("forgotpass.jsp");
    			rd.forward(request, response);
            } else {
                dataUtil.sendEmail(email, username, account.getPassword());
                out.println("<script>");
                out.println("alert('An email has already been sent. Please check');");
                out.println("location='login.jsp';");
                out.println("</script>");
//                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//    			rd.forward(request, response);
            }
        
        } catch (Exception e) {
            // TODO: handle exception
        }
	}

}