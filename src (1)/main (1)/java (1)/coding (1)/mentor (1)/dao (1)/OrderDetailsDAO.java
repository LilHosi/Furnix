package coding.mentor.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Order;
import coding.mentor.entity.OrderDetails;

public class OrderDetailsDAO {
	public void addOrderDetails(OrderDetails orderDetails) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = DBUtil.makeConnection();

			String sql = "INSERT INTO order_details (order_id, product_id, quantity) VALUE (?, ?, ?)";
			ps = conn.prepareStatement(sql);

			// set parameter
			
			ps.setInt(1, orderDetails.getOrderId());
			ps.setInt(2, orderDetails.getProductId());
			ps.setInt(3, orderDetails.getQuantity());
			ps.execute();

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
	public void insert(List<OrderDetails> orderDetailsList) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();

			String sql = "INSERT INTO order_details (order_id, product_id) VALUE (?, ?)";
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < orderDetailsList.size(); i++) {
				ps.setInt(1, orderDetailsList.get(i).getOrderId());
				ps.setInt(2, orderDetailsList.get(i).getProductId());
				ps.setInt(2, orderDetailsList.get(i).getQuantity());
				ps.addBatch();
			}
			
			ps.executeBatch();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {// after make connection, we have to close the connection using FINALLY (close
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
	public List<Order> getOrderById(int orderId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order order=null;
		List <Order> orders = new ArrayList<Order>();

		try {

			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM order_details where order_id =?";
			//ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			//ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			// set parameter
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
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
				System.out.println(order.getSubmitDate()+ "/n");
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
}
