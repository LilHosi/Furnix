package coding.mentor.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.dao.CategoryDAO;
import coding.mentor.dao.ProductDetailDAO;
import coding.mentor.dto.CartDTO;
import coding.mentor.entity.Category;
import coding.mentor.entity.ProductDetail;
import coding.mentor.util.DataUtil;



/**
 * Servlet implementation class ListProduct
 */
@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDetailDAO productDAO = new ProductDetailDAO();
	CategoryDAO categoryDAO = new CategoryDAO();
	DataUtil dataUtil = new DataUtil();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("cart") == null)
			{
				session.setAttribute("cart", new CartDTO(new HashMap<>()));
			}
//			GET ALL CATEGORY -> RETURN DATA TO PRODUCT PAGE
			List<Category> categories = categoryDAO.getAllCategory();
			request.setAttribute("categories", categories);	
			
			//GET NEW ARRIVAL PRODUCTS
			List<ProductDetail> newArrival = productDAO.getNewArrival();
			request.setAttribute("newA", newArrival);
			
			
			String productDetailId = request.getParameter("productDetailId");

			ArrayList<String> brand = new ArrayList<String>();
			List<ProductDetail> product = new ArrayList<ProductDetail>();
			
			String indexPageAll = request.getParameter("index");
			
			String selectCategory = request.getParameter("selectCategory");
			String selectBrand = request.getParameter("selectBrand");
			String selectPrice = request.getParameter("selectPrice");
			String selectSort = request.getParameter("selectSort");
			String selectView = request.getParameter("selectView");
			if (indexPageAll == null) {
				indexPageAll = "1";
			}
			if (selectView == null) {
				selectView = "6";
			}
			int index = Integer.parseInt(indexPageAll);
			
			if (selectCategory != null) {
				brand = productDAO.getBrandByCategory(Integer.parseInt(selectCategory));
				request.setAttribute("brand", brand);		
				product = productDAO.filterCategoryProduct(Integer.parseInt(selectCategory), selectBrand, selectPrice, selectSort, selectView, index);
				int countAll = productDAO.getFilterCategoryProduct(Integer.parseInt(selectCategory), selectBrand, selectPrice, selectSort);
				int endPageAll = dataUtil.getNumberOfPage(countAll, Integer.parseInt(selectView));
				request.setAttribute("endPA", endPageAll);
				request.setAttribute("tagA", indexPageAll);
				request.setAttribute("productC", product);
				request.setAttribute("selectBrand", selectBrand);
				request.setAttribute("selectPrice", selectPrice);
				request.setAttribute("selectSort", selectSort);
				request.setAttribute("selectView", selectView);
				request.setAttribute("selectCategory", selectCategory);
				String categoryName = null;
				if (selectCategory.equals("1")) {
					categoryName = "Kitchen";
				} else if (selectCategory.equals("2")) {
					categoryName = "Bedroom";
				} else if (selectCategory.equals("3")) {
					categoryName = "Office";
				} else {
					categoryName = "Outdoor";
				}
				request.setAttribute("categoryName", categoryName);
				String filterHeader = null;
				String filterMes = "You are viewing " + selectView + " products in one page.";
				if (countAll == 0 || product == null) {
					filterHeader = "Sorry, we cannot find your selection";					
				} else if ((selectBrand == null && selectPrice == null && selectSort == null) || (selectBrand.equals("default") && selectPrice.equals("default") && selectSort.equals("default"))){
					filterHeader = "There are " + countAll + " product(s) in " + categoryName;
				} else if (!selectBrand.equals("default") && selectPrice.equals("default") && selectSort.equals("default")){
					filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", by brand: " + selectBrand;
				} else if (selectBrand.equals("default") && !selectPrice.equals("default") && selectSort.equals("default")) {
					if (selectPrice.equals("0/50")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", less than $50.";
					} else if (selectPrice.equals("51/200")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", from $51 to $200.";
					} else if (selectPrice.equals("201/3000")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", over $200.";
					}
				} else if (selectBrand.equals("default") && selectPrice.equals("default") && !selectSort.equals("default")) {
					filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", sort by " + selectSort;
				} else if (!selectBrand.equals("default") && !selectPrice.equals("default") && selectSort.equals("default")) {
					if (selectPrice.equals("0/50")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", by brand: " + selectBrand + ", less than $50.";
					} else if (selectPrice.equals("51/200")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", by brand: " + selectBrand + ", from $51 to $200.";
					} else if (selectPrice.equals("201/3000")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", by brand: " + selectBrand + ", over $200.";
					}
				} else if (selectBrand.equals("default") && !selectPrice.equals("default") && !selectSort.equals("default")) {
					if (selectPrice.equals("0/50")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", less than $50, sort by " + selectSort;
					} else if (selectPrice.equals("51/200")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", from $51 to $200, sort by " + selectSort;
					} else if (selectPrice.equals("201/3000")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", over $200, sort by " + selectSort;
					}
				} else {
					if (selectPrice.equals("0/50")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", by brand: " + selectBrand + ", less than $50, sort by " + selectSort;
					} else if (selectPrice.equals("51/200")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", by brand: " + selectBrand + ", from $51 to $200, sort by " + selectSort;
					} else if (selectPrice.equals("201/3000")) {
						filterHeader = "There are " + countAll + " product(s) in: " + categoryName + ", by brand: " + selectBrand + ", over $200, sort by " + selectSort;
					}
				}
				request.setAttribute("filterHeader", filterHeader);
				request.setAttribute("filterMes", filterMes);								
				
			}
			
			if (productDetailId != null) {
				ProductDetail productDetail = productDAO.getProductDetailById(Long.parseLong(productDetailId));
				request.setAttribute("productDetail", productDetail);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("productDetail.jsp");
			rd.forward(request, response);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}