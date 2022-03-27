package coding.mentor.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.CategoryDAO;
import coding.mentor.dao.ProductDetailDAO;
import coding.mentor.entity.Category;
import coding.mentor.entity.ProductDetail;
import coding.mentor.util.DataUtil;



/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDetailDAO productDAO = new ProductDetailDAO();
	DataUtil dataUtil = new DataUtil();
	CategoryDAO categoryDAO = new CategoryDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Category> categories = categoryDAO.getAllCategory();
			request.setAttribute("categories", categories);	
			
			List<ProductDetail> newArrival = productDAO.getNewArrival();
			request.setAttribute("newA", newArrival);
			
			String textSearch = request.getParameter("search");
			String indexPageSearch = request.getParameter("index");
			if (indexPageSearch == null) {
				indexPageSearch = "1";
			}
			
			if (textSearch != null) {
				List<ProductDetail> product = productDAO.pagingProductBySearch(Integer.parseInt(indexPageSearch), textSearch);
				
				request.setAttribute("productS",product);
				
				int countSearch = productDAO.getTotalProductBySearchName(textSearch);
				int endPageSearch = dataUtil.getNumberOfPage(countSearch,6);
				request.setAttribute("endPS", endPageSearch);
				request.setAttribute("textSearch", textSearch);
				int index = Integer.parseInt(indexPageSearch);
				request.setAttribute("tagS", index);
				String filterHeader = null;
				if (countSearch == 0 || product == null) {
					filterHeader = "Sorry, we cannot find your selection";					
				} else {
					filterHeader = "There are " + countSearch + " product(s) based on your search keyword: " + textSearch;
				}
				request.setAttribute("filterHeader", filterHeader);
				request.setAttribute("countSearch", countSearch);
				RequestDispatcher rd = request.getRequestDispatcher("productDetail.jsp");
				rd.forward(request, response);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
