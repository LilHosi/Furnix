package coding.mentor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.ProductDetailDAO;
import coding.mentor.dto.ProductDTO;
import coding.mentor.entity.ProductDetail;

/**
 * Servlet implementation class ProductBOServlet
 */
@WebServlet("/ProductBOServlet")
public class ProductBOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDetailDAO productDAO = new ProductDetailDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductBOServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}
			
			switch (command) {
			case "LIST":
				listProduct(request, response);
				break;
			case "ADD":
				addProduct(request, response);
				break;
			case "LOAD_DETAIL":
				loadProductDetail(request, response);
				break;
			case "LOAD":
				loadProduct(request, response);
				break;
			case "UPDATE":
				updateProduct(request, response);
				break;
			case "DELETE":
				deleteProduct(request, response);
				break;
			default:
				listProduct(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listProduct (HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ProductDetail> products = productDAO.getAllProduct();
		request.setAttribute("PRODUCT_LIST", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addProduct (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		String production_country = request.getParameter("production_country");
		String materials = request.getParameter("materials");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String category_id = request.getParameter("category_id");
		String brand = request.getParameter("brand");
		productDAO.insertProduct(name, size, color, production_country, materials, description, price, category_id, brand);
		listProduct(request, response);
	}
	
	private void loadProduct (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		ProductDetail product = productDAO.getProductDetailById(Long.parseLong(id));
		request.setAttribute("LOAD_PRODUCT", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-update-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void loadProductDetail (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		ProductDTO product = productDAO.getProducDTOtById(id);
		System.out.println(product.getImage());
		request.setAttribute("LOAD_PRODUCT", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateProduct (HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String size = request.getParameter("size");
		String color = request.getParameter("color");
		String production_country = request.getParameter("production_country");
		String materials = request.getParameter("materials");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		System.out.println(price);
		String category_id = request.getParameter("category_id");
		String brand = request.getParameter("brand");
		ProductDetail product = new ProductDetail(id, name, size, color, production_country, materials, description, price, Long.parseLong(category_id), brand);
		productDAO.updateProduct(product);
		listProduct(request, response);
	}
	
	private void deleteProduct (HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		productDAO.deleteProduct(id);
		listProduct(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}