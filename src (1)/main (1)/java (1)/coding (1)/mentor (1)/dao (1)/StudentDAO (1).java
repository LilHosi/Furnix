package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import coding.mentor.db.DBUtil;
import coding.mentor.entity.Student;

public class StudentDAO {

	public Student getStudentByEmailAndPassword (String email, String password) throws SQLException {
		// access to Database to get Student Record using Email and Password
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		
		try {
			
			//make connection to MySQL
			conn = DBUtil.makeConnection();
			System.out.println("conn"  + conn);
			String sql = "SELECT * FROM student WHERE email = ? AND password = ?;";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			System.out.println("ps"  + ps);

			rs = ps.executeQuery(); //sau khi lay data xong thi phai co 1 noi de chua no
			
			System.out.println("rs"  + rs);
			//System.out.println("rs.next: "  + rs.next());

			
			//rs -> 1 record or many records
			if  (rs.next()) {  // if (rs.next() == true
				// to check if there is a data in here or not (return boolean value)
				
				//wrap data from database into a Entity (ex: student)
				long id = rs.getLong("id");				
				String firstName =rs.getString("first_name");				
				String lastName =rs.getString("last_name");
				
				student = new Student(id, firstName, lastName, email, password);
				
				return student;
				
			}  
			
			
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
