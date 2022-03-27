package coding.mentor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.CategoryDAO;
import coding.mentor.entity.Category;

/**
 * Servlet implementation class CategoryBOServlet
 */
@WebServlet("/CategoryBOServlet")
public class CategoryBOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryDAO categoryDAO = new CategoryDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryBOServlet() {
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
			System.out.println(command);
			if (command == null) {
				command = "LIST";
			}
			
			switch (command) {
			case "LIST":
				listCategory(request, response);
				break;
			case "ADD":
				addCategory(request, response);
				break;
			case "LOAD":
				loadCategory(request, response);
				break;
			case "UPDATE":
				updateCategory(request, response);
				break;
			case "DELETE":
				deleteCategory(request, response);
				break;
			default:
				listCategory(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listCategory (HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Category> categories = categoryDAO.getAllCategory();
		request.setAttribute("CATEGORY_LIST", categories);
		for (Category c:categories) {
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("category-list.jsp");
		dispatcher.forward(request, response);
	}

	private void addCategory (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		categoryDAO.insertCategory(name, description);
		listCategory(request, response);
	}
	
	private void loadCategory (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Category category = categoryDAO.getCategoryById(id);
		request.setAttribute("LOAD_CATEGORY", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("category-update-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateCategory (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int id = Integer.parseInt(request.getParameter("id"));		
		Category category = new Category(id, name, description);
		categoryDAO.updateCategory(category);
		listCategory(request, response);
	}
	
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		categoryDAO.deleteCategory(id);
		listCategory(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
