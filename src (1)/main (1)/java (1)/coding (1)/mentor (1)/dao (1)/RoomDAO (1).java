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
import coding.mentor.entity.Room;

public class RoomDAO {
	public List<Room> getAllRoom () throws SQLException {
		// access to Database to get all category with show = 1 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		
		
		List<Room> rooms = new ArrayList<Room>();
		//use List because we take more than 1 record
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			//System.out.println("conn"  + conn);
			String sql = "SELECT * FROM room";
			
			ps = conn.prepareStatement(sql);
		
			
			//System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			//System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			while(rs.next()) {  // if (rs.next() == true
				// to check if there is a data in here or not (return boolean value)
				
				//wrap data from database into a Entity (ex: student)
				room = new Room();
				room.setId(rs.getLong("id"));
				room.setName(rs.getString("name"));
				//room.setDescription(rs.getString("description"));
//				byte[] content = rs.getBytes("image");
//				if (content != null) {
//				String base64Encoded = new String(Base64.encodeBase64(content), "UTF-8");
//				room.setImageCode(base64Encoded);
//				}
				String temp = Long.toString(rs.getLong("id"));
				room.setImageCode(temp);
				//System.out.println("this is: " + category.toString() +" \n");
				//put records into a List
				rooms.add(room);
			} 
			return rooms;
			
			
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
	
	public Room getRoomById (int categoryId) throws SQLException {
		// access to Database to get all category with show = 1 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;
		
		
	
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			//System.out.println("conn"  + conn);
			String sql = "SELECT * FROM room where id=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			
			//System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			//System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			while(rs.next()) {  // if (rs.next() == true
				// to check if there is a data in here or not (return boolean value)
				
				//wrap data from database into a Entity (ex: student)
				room = new Room();
				room.setId(rs.getLong("id"));
				room.setName(rs.getString("name"));
				//room.setDescription(rs.getString("description"));
//				byte[] content = rs.getBytes("image");
//				if (content != null) {
//				String base64Encoded = new String(Base64.encodeBase64(content), "UTF-8");
//				room.setImageCode(base64Encoded);
//				}
				//System.out.println("this is: " + category.toString() +" \n");
				//put records into a List
				
			} 
			return room;
			
			
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
