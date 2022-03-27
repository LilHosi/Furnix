package coding.mentor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import coding.mentor.db.DBUtil;
import coding.mentor.entity.Account;


public class AccountDAO {
	public Account getAccountByUsernameAndPassword(String username, String password) throws SQLException {
		// access to database to get Student Record by Email and Password.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM account WHERE username = ? AND password = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				int id = rs.getInt("id");
				String pronounce = rs.getString("pronounce");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String preferredName = rs.getString("preferred_name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				account = new Account(id, pronounce, firstName, lastName, preferredName, username, email, password, phone);
			} else {
				return null;
			}
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}
		return null;
	}
	
	public Account checkAccountExist(String username) throws SQLException {
		// access to database to get Student Record by Email and Password.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();
			String sql = "SELECT * FROM account WHERE username = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
	
			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				int id = rs.getInt("id");
				String pronounce = rs.getString("pronounce");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String preferredName = rs.getString("preferred_name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String password = rs.getString("password");
				account = new Account(id, pronounce, firstName, lastName, preferredName, username, email, password, phone);
			} else {
				return null;
			}
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}
		return null;
	}
	
	public Account getAccountByUsernameAndEmail(String username, String email) throws SQLException {
		// access to database to get Student Record by Email and Password.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM account WHERE username = ? AND email = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);

			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				int id = rs.getInt("id");
				String pronounce = rs.getString("pronounce");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String preferredName = rs.getString("preferred_name");
				String phone = rs.getString("phone");
				String password = rs.getString("password");
				account = new Account(id, pronounce, firstName, lastName, preferredName, username, email, password, phone);
			} else {
				return null;
			}
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}
		return null;
	}
	
	
	public void registerAccount(String pronounce, String firstName, String lastName, String preferredName, String username, String email, String password, String phone) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();
			String sql = "insert into account (pronounce, first_name, last_name, preferred_name, username, email, password, phone)\r\n"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, pronounce);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, preferredName);
			ps.setString(5, username);
			ps.setString(6, email);
			ps.setString(7, password);
			ps.setString(8, phone);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRegister(conn, ps);
		}
	}
	
	public int getTotalAccount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "select count(*) from account";
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
	
	public List<Account> getAllAccount() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		List<Account> accounts = new ArrayList<Account>();
		
		try {
			conn = DBUtil.makeConnection();
			String sql = "SELECT * FROM account";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String pronounce = rs.getString("pronounce");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String preferredName = rs.getString("preferred_name");
				String phone = rs.getString("phone");
				String password = rs.getString("password");
				String username = rs.getString("username");
				String email = rs.getString("email");
				account = new Account(id, pronounce, firstName, lastName, preferredName, username, email, password, phone);	
				accounts.add(account);
			} 
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}		
		return null;
	}
	
	public Account getAccountById(String id) throws Exception {
		// access to database to get Student Record by Email and Password.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM account WHERE id = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));

			rs = ps.executeQuery();

			// rs -> 1/0 record
			if (rs.next()) {
				String pronounce = rs.getString("pronounce");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String preferredName = rs.getString("preferred_name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String username = rs.getString("username");
				String password = rs.getString("password");
				account = new Account(Integer.parseInt(id), pronounce, firstName, lastName, preferredName, username, email, password, phone);
			} else {
				throw new Exception("Cannot find account with value id: " + id);
			}
			return account;
		}  finally {
			DBUtil.close(conn, ps, rs);
		}
	}
	
	public void updateAccount(Account account) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// make connection to Mysql
			conn = DBUtil.makeConnection();
			String sql = "update account set pronounce =?, first_name =?, last_name =?, preferred_name =?, username =?, email =?, password =?, phone =? where id = ?";

			// ps -> contain SQL + parameter values
			ps = conn.prepareStatement(sql);
			ps.setString(1, account.getPronounce());
			ps.setString(2, account.getFirstName());
			ps.setString(3, account.getLastName());
			ps.setString(4, account.getPreferredName());
			ps.setString(5, account.getUsername());
			ps.setString(6, account.getEmail());
			ps.setString(7, account.getPassword());
			ps.setString(8, account.getPhone());
			ps.setInt(9, account.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRegister(conn, ps);
		}
	}
	
	public void deleteAccount (int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.makeConnection();
			String sql = "delete from account where id = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
		} finally {
			DBUtil.closeRegister(conn, ps);
		}
	}
		
}