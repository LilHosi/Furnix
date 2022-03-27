package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Subcategory;

public class SubcategoryDAO {
	public List<Subcategory> getSubcategoryById (long categoryId) throws SQLException {
		// access to Database to get all category with show = 1 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Subcategory subcategory = null;
		
		
		List<Subcategory> subcategories = new ArrayList<Subcategory>();
		//use List because we take more than 1 record
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			//System.out.println("conn"  + conn);
			String sql = "SELECT * FROM subcategory WHERE category_id=?";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, categoryId);
			
			//System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			//System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			while(rs.next()) {  // if (rs.next() == true
				// to check if there is a data in here or not (return boolean value)
				
				//wrap data from database into a Entity (ex: student)
				subcategory = new Subcategory();
				subcategory.setId(rs.getLong("id"));
				subcategory.setName(rs.getString("name"));
				subcategory.setCategoryId(rs.getLong("category_Id"));
				subcategory.setDescription(rs.getString("description"));
				System.out.println("this is: " + subcategory.toString() +" \n");
				//put records into a List
				subcategories.add(subcategory);
			} 
			return subcategories;
			
			
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
}
