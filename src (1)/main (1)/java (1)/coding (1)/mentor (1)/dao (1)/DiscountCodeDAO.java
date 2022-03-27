package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Category;
import coding.mentor.entity.DiscountCode;

public class DiscountCodeDAO {
	
	public List<DiscountCode> getAllDiscountCode() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DiscountCode discountCode = null;
		List<DiscountCode> discountCodes = new ArrayList<DiscountCode>();
		
		try {
			conn = DBUtil.makeConnection();
			String sql = "SELECT * FROM discount";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				discountCode = new DiscountCode();
				discountCode.setId(rs.getInt("id"));
				discountCode.setName(rs.getString("name"));
				discountCode.setAmount(rs.getInt("amount"));
				discountCode.setExpiredDate(rs.getString("expired_date"));
				discountCodes.add(discountCode);
			} 
			return discountCodes;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}		
		return null;
	}
	
	public int getTotalDiscountCode() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "select count(*) from discount";
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
	
	public DiscountCode getDiscountCode(String discountCodeName) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DiscountCode discountCode = null;
		
		try {
			conn = DBUtil.makeConnection();
			String sql = "select * from discount where name = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, discountCodeName);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				discountCode = new DiscountCode();
				discountCode.setId(rs.getInt("id"));
				discountCode.setName(discountCodeName);		
				discountCode.setAmount(rs.getInt("amount"));
				discountCode.setExpiredDate(rs.getString("expired_date"));
			} else {
				throw new Exception("Cannot find discount code: " + discountCodeName);
			}
			return discountCode;
		} finally {  
			DBUtil.close(conn, ps, rs);
		}
	}
}
