package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Category;


public class CategoryDAO {

	public List<Category> getAllCategory () throws SQLException {
		// access to Database to get all category with show = 1 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category category = null;
		
		
		List<Category> categories = new ArrayList<Category>();
		//use List because we take more than 1 record
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			//System.out.println("conn"  + conn);
			String sql = "SELECT * FROM category";
			
			ps = conn.prepareStatement(sql);
		
			
			//System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			//System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			while(rs.next()) {  // if (rs.next() == true
				// to check if there is a data in here or not (return boolean value)
				
				//wrap data from database into a Entity (ex: student)
				category = new Category();
				category.setId(rs.getLong("id"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
//				byte[] content = rs.getBytes("image");
//				if (content != null) {
//				String base64Encoded = new String(Base64.encodeBase64(content), "UTF-8");
//				category.setImageCode(base64Encoded);}
				
				//category.setImage(rs.getBytes("image"));
				//System.out.println("this is: " + category.toString() +" \n");
				//put records into a List
				categories.add(category);
			} 
			return categories;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		finally {//after make connection, we have to close the connection using FINALLY (close from bottom to top)
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

	public int getTotalCategory() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "select count(*) from category";
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
	
	public void insertCategory(String name, String description) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();
			String sql = "insert into category (name, description) values (?, ?)";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRegister(conn, ps);
		}
	}
	
	public Category getCategoryById (String id) throws Exception {
		Category category = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.makeConnection();
			String sql = "select * from category where id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				category = new Category(Integer.parseInt(id), name, description);
			} else {
				throw new Exception("Cannot find category with value id: " + id);
			}
			return category;
		} finally {  
			DBUtil.close(conn, ps, rs);
		}
	}
	
	public void updateCategory (Category category) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "update category set name = ?, description = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getDescription());
			ps.setLong(3, category.getId());
			ps.executeUpdate();
		} finally {
			DBUtil.closeRegister(conn, ps);
		}
	}
	
	public void deleteCategory (int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "delete from category where id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
		} finally {
			DBUtil.closeRegister(conn, ps);
		}
	}
}
