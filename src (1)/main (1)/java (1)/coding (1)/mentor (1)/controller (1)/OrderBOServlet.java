package coding.mentor.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coding.mentor.dao.OrderDAO;
import coding.mentor.dto.OrderDetailDTO;
import coding.mentor.entity.Order;



/**
 * Servlet implementation class OrderBOServlet
 */
@WebServlet("/OrderBOServlet")
public class OrderBOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orderDAO = new OrderDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderBOServlet() {
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
				listOrder(request, response);
				break;			
			case "LOAD_DETAIL":
				loadOrderDetail(request, response);
				break;
			case "LOAD":
				loadOrder(request, response);
			case "UPDATE_SHIPDATE":
				updateShipDate(request, response);
			default:
				listOrder(request, response);
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	private void listOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Order> orders = orderDAO.getOrder();
		request.setAttribute("ORDER_LIST", orders);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void loadOrderDetail (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		List<OrderDetailDTO> orderDetailDTO = orderDAO.getOrderDetailDTOById(id);
		request.setAttribute("LOAD_ORDER", orderDetailDTO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void loadOrder (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Order order = orderDAO.getOrderById(id);
		request.setAttribute("LOAD_ORDER", order);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order-update-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateShipDate (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String selectTime = request.getParameter("selectTime");
		String submitTime = request.getParameter("submitTime");
		String timeQuantity = request.getParameter("timeQuantity");
		LocalDate expectedShip = LocalDate.parse(submitTime);
		if (selectTime.equals("day")) {
			expectedShip = expectedShip.plus(Integer.parseInt(timeQuantity), ChronoUnit.DAYS);
		} else if (selectTime.equals("week")) {
			expectedShip = expectedShip.plus(Integer.parseInt(timeQuantity), ChronoUnit.WEEKS);
		} else if (selectTime.equals("month")) {
			expectedShip = expectedShip.plus(Integer.parseInt(timeQuantity), ChronoUnit.MONTHS);
		}
		String status = "PENDING";
		orderDAO.updateShipDate(expectedShip.toString(), status, Integer.parseInt(id));
		listOrder(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}