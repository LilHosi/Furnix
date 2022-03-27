package coding.mentor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.DBUtil;
import coding.mentor.dto.OrderDetailDTO;
import coding.mentor.entity.Order;
import coding.mentor.entity.OrderDetails;
import coding.mentor.util.DataUtil;

public class OrderDAO {
	DataUtil dataUtil = new DataUtil();
	public int  addOrder(Order order) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBUtil.makeConnection();

			String sql = "INSERT INTO order_list (address, submit_time, user_email, price) VALUE (?, ?, ?, ?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			// set parameter
			ps.setString(1, order.getAddress());
			LocalDate submit_date = LocalDate.now();
			ps.setString(2, submit_date.toString());
			ps.setString(3, order.getUserEmail());
			ps.setFloat(4, order.getPrice());
			ps.execute();
			rs = ps.getGeneratedKeys();
//			System.out.println(rs.next());
			if (rs.next()) {
				int insertedId = rs.getInt(1);
				System.out.println(insertedId);
				return insertedId;
			}
			return 0;

		} finally {// after make connection, we have to close the connection using FINALLY (close
					// from bottom to top)
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

	}
	
	public List<Order> getOrder() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order order=null;
		List <Order> orders = new ArrayList<Order>();

		try {

			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM order_list";
			//ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			// set parameter
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, orderId);
			rs = ps.executeQuery();
//			System.out.println(rs.next());
			while (rs.next()) {
				order = new Order();
				order.setId(rs.getInt("id"));
				order.setAddress(rs.getString("address"));
				order.setSubmitDate(rs.getString("submit_time"));
				order.setStatus(rs.getString("status"));
				order.setShipDate(rs.getString("ship_date"));
				order.setUserEmail(rs.getString("user_email"));
				order.setPrice(rs.getFloat("price"));
				orders.add(order);
			//	System.out.println(order.getSubmitDate()+ "/n");
			}
			return orders;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {// after make connection, we have to close the connection using FINALLY (close
					// from bottom to top)
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return null;

	}
	
	
	public List<OrderDetails> getOrderDetailById(int orderId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderDetails orderDetail = null;
		List <OrderDetails> orderDetails = new ArrayList<OrderDetails>();

		try {

			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM order_details WHERE order_id = ? ";
			//ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			// set parameter
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
//			System.out.println(rs.next());
			while (rs.next()) {
				orderDetail = new OrderDetails();
				orderDetail.setId(rs.getInt("id"));
				orderDetail.setProductId(rs.getInt("product_id"));
				orderDetail.setOrderId(rs.getInt("order_id"));
				orderDetail.setQuantity(rs.getInt("quantity"));
				orderDetails.add(orderDetail);
			//	System.out.println(order.getSubmitDate()+ "/n");
			}
			return orderDetails;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {// after make connection, we have to close the connection using FINALLY (close
					// from bottom to top)
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return null;

	}
	
	public List<OrderDetailDTO> getOrderDetailDTOById (String id) throws Exception {
		OrderDetailDTO orderDetailDTO = null;
		
		List<OrderDetailDTO> orderDetailDTOs = new ArrayList<OrderDetailDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.makeConnection();
			String sql = "select order_details.*, product.name as product_name, product.price as product_price, product.image as product_image from order_details join product on product.id = order_details.product_id where order_details.order_id = ?;";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int orderId = rs.getInt("order_id");
				int productId = rs.getInt("product_id");
				int quantity = rs.getInt("quantity");
				String productName = rs.getString("product_name");
				float productPrice = rs.getFloat("product_price");
				String productImage = rs.getString("product_image");
				productImage = dataUtil.convertImage(productImage);
				orderDetailDTO = new OrderDetailDTO(Integer.parseInt(id), orderId, productId, quantity, productName, productPrice, productImage);
				orderDetailDTOs.add(orderDetailDTO);
			}
			return orderDetailDTOs;
		} finally {  
			DBUtil.close(conn, ps, rs);
		}
	}
	
	 public int generateOrderId(Order order) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {

	            conn = DBUtil.makeConnection();
	            String sql = "INSERT INTO order_list (address, submit_date, user_email) VALUE (?, ?, ?) ";
	            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            // set parameter
	            ps.setString(1, order.getAddress());
	            LocalDate submit_date = LocalDate.now();
	            ps.setString(2, submit_date.toString());
	            ps.setString(3, order.getUserEmail());
	            ps.execute();
	            rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                int insertedId = rs.getInt(1);
	                return insertedId;
	            }
	            return 0;

	        } finally {
	          DBUtil.close(conn, ps, rs);
	        }
	 }
	 
	 public int getTotalOrder() {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conn = DBUtil.makeConnection();
				String sql = "select count(*) from order_list";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					return rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(conn, ps, rs);
			}
			return 0;
		}
	 
	 public Order getOrderById (String id) throws Exception {
			Order order = null;
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = DBUtil.makeConnection();
				String sql = "select * from order_list where id = ?";
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(id));
				rs = ps.executeQuery();
				
				if (rs.next()) {
					String address = rs.getString("address");
					String submitTime = rs.getString("submit_time");
					String status = rs.getString("status");
					String shipDate = rs.getString("ship_date");
					String userEmail = rs.getString("user_email");
					float price = rs.getFloat("price");
					order = new Order(Integer.parseInt(id), address, submitTime, status, shipDate, userEmail, price);
				} else {
					throw new Exception("Cannot find order with value id: " + id);
				}
				return order;
			} finally {  
				DBUtil.close(conn, ps, rs);
			}
		}
	 
		public void updateShipDate (String shipDate, String status, int id) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = DBUtil.makeConnection();
				String sql = "update order_list set ship_date = ?, status = ? where id = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, shipDate);
				ps.setString(2, status);
				ps.setInt(3, id);
				ps.executeUpdate();
			} finally {
				DBUtil.closeRegister(conn, ps);
			}
		}
		
		public List<OrderDetailDTO> getBestSellerProduct (String thisMonth) throws Exception { // get 3 best seller in february first, fix later 
            OrderDetailDTO orderDetailDTO = null;
            List<OrderDetailDTO> orderDetailDTOs = new ArrayList<OrderDetailDTO>();
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            try {
                conn = DBUtil.makeConnection();
                String sql = "SELECT order_details.id, order_id, order_details.product_id, sum(quantity) as sum_quantity, product.name as product_name, product.price as product_price, product.image as product_image FROM final_project.order_details JOIN order_list on order_list.id = order_details.order_id JOIN product on order_details.product_id = product.id where order_list.submit_time like ? group by product_id order by sum_quantity desc limit 3;";
                
                ps = conn.prepareStatement(sql);
                ps.setString(1, dataUtil.convertMonthString(thisMonth).toString());
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int orderId = rs.getInt("order_id");
                    int productId = rs.getInt("product_id");
                    int quantity = rs.getInt("sum_quantity");
                    String productName = rs.getString("product_name");
                    float productPrice = rs.getFloat("product_price");
                    String productImage = rs.getString("product_image");
                    productImage = dataUtil.convertImage(productImage);
                    orderDetailDTO = new OrderDetailDTO(id, orderId, productId, quantity, productName, productPrice, productImage);
                    orderDetailDTOs.add(orderDetailDTO);
                }
                return orderDetailDTOs;
            } finally {  
                DBUtil.close(conn, ps, rs);
            }
        }
		public float incomePerMonth(String thisMonth) { // in february 
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                conn = DBUtil.makeConnection();
                String sql = "SELECT sum(price) as price FROM final_project.order_list where submit_time like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, dataUtil.convertMonthString(thisMonth).toString());
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getFloat("price");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(conn, ps, rs);
            }
            return 0;
        }

}
	

