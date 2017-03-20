package IndependentStudy;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
	public static void main(String args[]) {
		User user = new User();
		user.setF_name("test");
		user.setL_name("test");
		user.setUser_name("test");
		user.setPass_word("test");
		user.setSex("M");
		insertUser(user);
		System.out.println(user);
	}

	public static boolean insertUser(User usr) {
		Connection con = null;
		try {
			con = DBConection.getConnection();
			UserDAO.setCon(con);
			boolean test = UserDAO.insert(usr);
			con.commit();
			return test;
		} catch (SQLException ex) {
			Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}

		return false;
	}

	public static User loginCredentials(String userName, String password) {
		Connection con = null;

		try {
			con = DBConection.getConnection();
			UserDAO.setCon(con);
			return UserDAO.loginCredentials(userName, password);
		} catch (SQLException ex) {
			Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (con != null) {				
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}

		return null;
	}

	public static void createData() {
		Connection con = null;
		try {
			con = DBConection.getConnection();
			UserDAO.setCon(con);
		} catch (SQLException ex) {
			Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}

	}
	
	public static List<User> getAllUser() {
        Connection con = null;
        try {
        	con = DBConection.getConnection();
        	UserDAO.setCon(con);
        	return UserDAO.getAllUser();
        } catch (SQLException ex) {
        	Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	if (con != null) {
        		try {
        			con.close();
        		} catch (SQLException ex) {
        			Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        		}
        	}
        }
        return null;
	}
	
}
