package coding.mentor.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coding.mentor.dao.DiscountCodeDAO;
import coding.mentor.dao.OrderDAO;
import coding.mentor.dao.OrderDetailsDAO;
import coding.mentor.dao.ProductDetailDAO;
import coding.mentor.dao.RoomDAO;
import coding.mentor.dto.CartDTO;
import coding.mentor.entity.Account;
import coding.mentor.entity.Cart;
import coding.mentor.entity.DiscountCode;
import coding.mentor.entity.Order;
import coding.mentor.entity.OrderDetails;
import coding.mentor.entity.ProductDetail;
import coding.mentor.entity.Room;
import coding.mentor.entity.Student;
import coding.mentor.util.DataUtil;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDetailDAO productDetailDAO = new ProductDetailDAO();
	OrderDAO orderDAO = new OrderDAO();
	OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
	DiscountCodeDAO discountCodeDAO = new DiscountCodeDAO();
	 RoomDAO roomDAO = new RoomDAO();
	float subtotal = 0;
	float total = 0;
	String confirmation = null;
	DataUtil dataUtil = new DataUtil();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Room> rooms = roomDAO.getAllRoom();
			request.setAttribute("rooms", rooms);
			String command = request.getParameter("command");
//			System.out.println(command + productId);
			String productId = request.getParameter("productId");
			String quantity = request.getParameter("quantity");
			String toward = request.getParameter("location");
			System.out.println(command);
			System.out.println(command + "-" + toward+ "-" + productId  + "-" + quantity);

			// add items to cart (can add 1 item many times)
			if (command != null && command.equals("ADD_TO_CART")) {
//				String productId = request.getParameter("productId");
//				String productId = request.getParameter("productId");
//				String quantity = request.getParameter("quantity");
				ProductDetail product = productDetailDAO.getProductDetailById(Long.parseLong(productId));
				
				CartDTO cart = (CartDTO) request.getSession().getAttribute("cart");
				//System.out.println(productId + "-" + quantity);
				System.out.println(toward);
				Iterator<Entry<ProductDetail, Integer>> it = cart.getProducts().entrySet().iterator();
				boolean isExist = false;
				while (it.hasNext()) {
					Map.Entry pairs = (Entry) it.next();
					ProductDetail checkProduct = (ProductDetail) pairs.getKey();
					if (productId.equals(checkProduct.getId() + "")) {
						subtotal = subtotal + Float.parseFloat(product.getPrice()) * Integer.parseInt(quantity);
						int temp = (int) pairs.getValue(); 
						temp += Integer.parseInt(quantity);
						cart.getProducts().replace(checkProduct, temp);
						isExist = true;
					}
				}
				
				if (!isExist) {
					cart.getProducts().put(product, Integer.parseInt(quantity));
					subtotal = subtotal + Float.parseFloat(product.getPrice()) * Integer.parseInt(quantity);
				}
				System.out.println("hia");
				System.out.println(toward);
				request.getSession().setAttribute("cart", cart);
				String categoryId = request.getParameter("categoryId");
				request.getSession().setAttribute("subtotal", subtotal);
				request.getSession().setAttribute("total", subtotal);
				if (toward.equals("CONTINUE SHOPPING")) {
//				response.sendRedirect("ListProduct?productDetailId=" + productId + "&categoryId=" + categoryId);
					response.sendRedirect("ListProduct?selectCategory=" + categoryId);
				} else if (toward.equals("GO TO CART")) {
					response.sendRedirect("cart.jsp");	
				}
				
				//response.sendRedirect("ListProduct?productDetailId=" + productId + "&categoryId=" + categoryId);
				// view cart
			} else if (command != null && command.equals("VIEW_CART")) {
				request.getSession().setAttribute("subtotal", subtotal);
				request.getSession().setAttribute("total", subtotal);
				response.sendRedirect("cart.jsp");
				
			} else if (command != null && command.equals("REMOVE")) {
				productId = request.getParameter("productId");
				CartDTO cart = (CartDTO) request.getSession().getAttribute("cart");
				//ProductDetail product = productDetailDAO.getProductDetailById(Long.parseLong(productId));
				Iterator<Entry<ProductDetail, Integer>> it = cart.getProducts().entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pairs = (Entry) it.next();
					
					ProductDetail checkProduct = (ProductDetail) pairs.getKey();
					System.out.println(checkProduct.getId() + "\n");
					if (productId.equals(checkProduct.getId() + "")) {
						cart.getProducts().remove(checkProduct);
						subtotal -= Float.parseFloat(checkProduct.getPrice()) * (int)pairs.getValue();
						//System.out.println(subtotal + "-");
					}
				}
				while (it.hasNext()) {
					Map.Entry pairs = (Entry) it.next();
					
					ProductDetail checkProduct = (ProductDetail) pairs.getKey();
					System.out.println(checkProduct.getId() + "\n");
				}
				System.out.println(subtotal + "-");
				request.getSession().setAttribute("cart", cart);
				request.getSession().setAttribute("subtotal", subtotal);
				request.getSession().setAttribute("total", subtotal);
				RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);
				//response.sendRedirect("cart.jsp");
			}

			else if (command != null && (command.equals("DECREASE")) || command.equals("INCREASE")) {
				productId = request.getParameter("productId");
				ProductDetail product = productDetailDAO.getProductDetailById(Long.parseLong(productId));
				CartDTO cart = (CartDTO) request.getSession().getAttribute("cart");
				Iterator<Entry<ProductDetail, Integer>> it = cart.getProducts().entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pairs = (Entry) it.next();
					ProductDetail checkProduct = (ProductDetail) pairs.getKey();
					if (productId.equals(checkProduct.getId() + "")) {
						int temp = (int) pairs.getValue();
						if (command.equals("INCREASE")) {
							temp++;
							subtotal = subtotal + Float.parseFloat(product.getPrice());
						} else {
							if (temp - 1 < 0) {
								temp = 0;
							}
							else {
								temp --;
								subtotal = subtotal - Float.parseFloat(product.getPrice());
							}
						}
						cart.getProducts().replace(checkProduct, temp);
					}
				}
				System.out.println(subtotal + "-");
				request.getSession().setAttribute("cart", cart);
				request.getSession().setAttribute("subtotal", subtotal);
				request.getSession().setAttribute("total", subtotal);
				RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);
				//response.sendRedirect("cart.jsp");
			} 
			
			else if (command != null && command.equals("SUBMIT_CART")) {
//insert order to database
				System.out.println(command + "\n");
				Order od = new Order();
				Account account = (Account) request.getSession().getAttribute("me");
				String status = request.getParameter("status");
				String address =request.getParameter("address");
				System.out.println(status);
				od.setAddress(address);
				
				if (status.equals("GUEST")) {
					od.setUserEmail(request.getParameter("guestEmail"));
					//dataUtil.sendInvoice(request.getParameter("guestEmail"));
				} else if (status.equals("CURRENT CUSTOMER")) {
					od.setUserEmail(account.getEmail());
					
				}
				if (total != 0) {
					od.setPrice(total);
				} else {
					od.setPrice(subtotal);
				}
				dataUtil.sendInvoice(account, od);
//				od.setStudentId((int) student.getId());
				
				//get orderid from inserted order
				int orderId = orderDAO.addOrder(od);
				//get product from session cart
				CartDTO cart = (CartDTO) request.getSession().getAttribute("cart");
				//HashMap <ProductDetail, Integer> product = cart.getProducts();
				
				List <OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
				for (ProductDetail key : cart.getProducts().keySet()) {
					int temp = (int) key.getId();
//					orderDetailsList.add(new OrderDetails (orderId, temp));
					OrderDetails orderDetails = new OrderDetails (orderId, temp, cart.getProducts().get(key));
					orderDetailsDAO.addOrderDetails(orderDetails);
				}
				//orderDetailsDAO.insert(orderDetailsList);
				cart.getProducts().clear();
				subtotal = 0;
				total=0;
				request.getSession().setAttribute("subtotal", subtotal);
				request.getSession().setAttribute("total", total);
				request.getSession().setAttribute("cart", cart);
				request.getSession().setAttribute("confirmation", "yes");
				System.out.println("chearrr");
				response.sendRedirect("cart.jsp");
				
//				//create order - return orderId
//				Order order = new Order((int)student.getId(), false);
//				System.out.println("here 1 + " +order.getStudentId());
//				int orderId = orderDAO.addOrder(order);
//				System.out.println("/n --- " + orderId);
//				//create order - return orderId
//				//create orderDetails
//				
//				System.out.println("here 2 ");
//				request.getSession().removeAttribute("cart");
//				System.out.println("is it removed?");
//				response.sendRedirect("cart.jsp");
			} else if (command != null && command.equals("DISCOUNT")) {
				String discountCodeName = request.getParameter("discountCode");
				System.out.println(discountCodeName);
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
							total = (subtotal / 100)*(100-amount);
							
						}
					}
					request.getSession().setAttribute("total", total);
					request.getSession().setAttribute("subtotal", subtotal);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			//response.sendRedirect("cart.jsp");
			// get current cart
//		System.out.println(productId);

//			boolean isExist = false;
//			for (ProductDetail productInCart: cart.getProducts()) {
//				if (productId.equals(productInCart.getId()+"")) {
//					isExist = true;
//				}
//			}
//			if (!isExist) {
//				cart.getProducts().add(product);
//			}
			//System.out.println("-------" + subtotal);
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

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
