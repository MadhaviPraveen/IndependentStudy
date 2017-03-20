package IndependentStudy;

import java.sql.*;
import java.util.logging.*;
import java.util.List;
import java.util.ArrayList;

public class ProfessorDAO {

	private static Connection con = null;

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		ProfessorDAO.con = con;
	}
	
	public static boolean insert(Professor pr){
		if(pr == null){
			return  false;
		}
		try{
			PreparedStatement ps  = con.prepareStatement("insert into professor (f_name, l_name, dob, experience, studyPlace)" + "values (?,?,?,?,?)" );
			ps.setString(1, pr.getFirstName());
			ps.setString(2, pr.getLastNname());
			ps.setDate(3, pr.getDob()== null ? null : new java.sql.Date(pr.getDob().getTime()));
			ps.setInt(4, pr.getExperience());
			ps.setString(5, pr.getStudyPlace());
			int count = ps.executeUpdate();
			con.commit();
			if(count > 0){
				return true;
			}
		}catch(SQLException ex){
			Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	public static Professor profSelection(String firstName, String lastName){
		if(firstName == null || lastName == null){
			return null;
		}
		try{
			String queryString = "SELECT * FROM professor WHERE f_name = ? and l_name = ? ;";
			//Create a statement
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ResultSet rset = ps.executeQuery();
			if(rset.next()){
				Professor pr = new Professor();
				pr.setFirstName(rset.getString(1));
				pr.setLastName(rset.getString(2));
				pr.setDob(rset.getDate(3));
				pr.setExperience(rset.getInt(4));
				pr.setStudyPlace(rset.getString(5));
				return pr;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
    public static List<Professor> getAllProfessor() {
        List<Professor> data = new ArrayList<Professor>();
	try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select * from Professor");
            
            while (rs.next()) {
        	Professor pr = new Professor();
        	pr.setP_id(rs.getInt("p_id"));
        	pr.setFirstName(rs.getString("f_name"));
        	pr.setLastName(rs.getString("l_name"));
        	pr.setExperience(rs.getInt("experience"));
        	pr.setDob(rs.getDate("dob"));
        	pr.setStudyPlace(rs.getString("studyplace"));
        	data.add(pr);
            }
       
        } catch (SQLException ex) {
        Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    public static boolean delete(int p_id) {
    	if (p_id <= 0) {
            return false;
        }
    	try {
        	PreparedStatement ps = con.prepareStatement("delete from Professor where p_id = ? " );
            ps.setInt(1, p_id);
            int count = ps.executeUpdate();
            con.commit();
            if (count > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }

	public static boolean update(Professor pr){
		if(pr == null){
			return false;
		}
		try{
			PreparedStatement ps = con.prepareStatement("UPDATE Professor SET f_name=?, l_name=?, dob=?, experience=?, studyPlace=? WHERE id=?");
			ps.setString(1, pr.getFirstName());
			ps.setString(2, pr.getLastNname());
			ps.setDate(3, pr.getDob()== null ? null : new java.sql.Date(pr.getDob().getTime()));
			ps.setInt(4, pr.getExperience());
			ps.setString(5, pr.getStudyPlace());
			int count = ps.executeUpdate();
			con.commit();
			if(count > 0){
				return true;
			}
		}	
		catch(SQLException ex){
			Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	
}
