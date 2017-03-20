package IndependentStudy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserDAO {
    private static Connection con = null;
    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        UserDAO.con = con;
    }
    public static boolean insert(User usr) {
        if (usr == null) {
            return false;
        }
        try {
        	PreparedStatement ps = 
                    con.prepareStatement("insert into User(cwid, f_name, l_name, user_name, pass_word, street_name, house_num, city, zip_code, sex, dob) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        	
            ps.setInt(1, usr.getCwid());
            ps.setString(2, usr.getF_name());
            ps.setString(3, usr.getL_name());
            ps.setString(4, usr.getUser_name());
            ps.setString(5, usr.getPass_word());
            ps.setString(6, usr.getStreet_name());
            ps.setInt(7, usr.getHouse_num());
            ps.setString(8, usr.getCity());
            ps.setInt(9, usr.getZip_code());
            ps.setString(10, usr.getSex() + "");
            ps.setDate(11, usr.getDob() == null ? null : new java.sql.Date(usr.getDob().getTime()));
            //ps.setString(12, usr.getUserType() + "");
           // ps.setString(12, "NA");
            
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;         
        
    }
    
    public static User loginCredentials(String userName, String password){
    	if(userName == null || password == null){
    		return null;
    	}
    	try {
    		Statement stat = con.createStatement();
    		String queryString = "select * from User where User_name =? and pass_word = ?";
    		//Create a statement
    		PreparedStatement preparedStatement = con.prepareStatement(queryString);
    		preparedStatement.setString(1, userName);
    		preparedStatement.setString(2, password);
    		ResultSet rset = preparedStatement.executeQuery();
    		if(rset.next()){
    			User user = new User();
                        
                        user.setu_id(rset.getInt(1));
    			user.setCwid(rset.getInt(2));
    			user.setF_name(rset.getString(3));
    			user.setL_name(rset.getString(4));
    			user.setUser_name(rset.getString(5));
    			user.setPass_word(rset.getString(6));
    			user.setStreet_name(rset.getString(7));
    			user.setHouse_num(rset.getInt(8));
                        user.setCity(rset.getString(9));
                        user.setZip_code(rset.getInt(10));
    			user.setSex(rset.getString(11));
    			user.setDob(rset.getDate(12));
                        user.setUserType(rset.getString(13));
    			return user;
    		}
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
		return null;
    }
    public static List<User> getAllUser() {
    	try {
    		Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select * from User");
            ArrayList<User> data = new ArrayList<User>();
            while (rs.next()) {
            	User userDTO = new User();
            	//userDTO.setId(rs.getInt("id"));
            	userDTO.setCwid(rs.getInt("cwid"));
            	userDTO.setF_name(rs.getString("f_name"));
            	userDTO.setL_name(rs.getString("l_name"));
            	userDTO.setUser_name(rs.getString("user_name"));
            	userDTO.setPass_word(rs.getString("pass_word"));
            	userDTO.setStreet_name(rs.getString("street_name"));
            	userDTO.setHouse_num(rs.getInt("house_num"));
            	userDTO.setSex(rs.getString("sex"));
            	userDTO.setDob(rs.getDate("dob"));
            	userDTO.setUserType(rs.getString("userType"));
            	
            	data.add(userDTO);
            	//data.add(new User(rs.getInt("id"), rs.getInt("cwid"), rs.getString("f_name"), rs.getString("l_name"), rs.getString("user_name"), rs.getString("pass_word"), rs.getString("street_name"), rs.getInt("house_num"), rs.getString("city"), rs.getInt("zip_code"),c,rs.getInt("dob")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
    
    public static boolean delete(int u_id) {
    	if (u_id <= 0) {
            return false;
        }
    	try {
        	PreparedStatement stat = con.prepareStatement("delete from User where u_id = ? " );
            stat.setInt(1, u_id);
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static boolean update(User usr) {
       if (usr == null) {
            return false;
        }
       	try {
            PreparedStatement stat = con.prepareStatement("update User set cwid=?, f_name=?, l_name=?, user_name=?, pass_word=?, street_name=?, house_num=?, city=?, zip_code=?, sex=?, dob=? where id = ? " );
            stat.setInt(1, usr.getCwid());
            stat.setString(2, usr.getF_name());
            stat.setString(3, usr.getL_name());
            stat.setString(4, usr.getUser_name());
            stat.setString(5, usr.getPass_word());
            stat.setString(6, usr.getStreet_name());
            stat.setInt(7, usr.getHouse_num());
            stat.setString(8, usr.getCity());
            stat.setInt(9, usr.getZip_code());
            stat.setString(10, usr.getSex() + "");
            stat.setDate(11, usr.getDob() == null ? null : new java.sql.Date(usr.getDob().getTime()));
            stat.setString(12, usr.getUserType() + "");
            int result = stat.executeUpdate();
            con.commit();
            if (result > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
}
    
