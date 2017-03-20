package IndependentStudy;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.*;

public class ProfessorService {
	
	public static void main (String[] args){
		Professor pr = new Professor();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			pr.setDob(sdf.parse("05/17/1988"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pr.setExperience(4);
		pr.setFirstName("JENQ");
		pr.setLastName("JOHN");
    		pr.setStudyPlace("RIT");
		insertProfessor(pr);
	}
	
	public static boolean insertProfessor(Professor pr){
		Connection con = null;
		try{
			con = DBConection.getConnection();
			ProfessorDAO.setCon(con);
			boolean test = ProfessorDAO.insert(pr);
			con.commit();
			return test;
		}
		catch(SQLException ex){
			Logger.getLogger(ProfessorService.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(SQLException ex){
					Logger.getLogger(ProfessorService.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	} 
	
	public static Professor profSelection(String firstName, String lastName){
		Connection con = null;
		try{
			con = DBConection.getConnection();
			ProfessorDAO.setCon(con);
			return ProfessorDAO.profSelection(firstName, lastName);
		}
		catch(SQLException ex){
			Logger.getLogger(ProfessorService.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
        
        public static List<Professor> getAllProfessor() {
        Connection con = null;
        try {
        	con = DBConection.getConnection();
        	ProfessorDAO.setCon(con);
        	return ProfessorDAO.getAllProfessor();
        } catch (SQLException ex) {
        	Logger.getLogger(ProfessorService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        	if (con != null) {
        		try {
        			con.close();
        		} catch (SQLException ex) {
        			Logger.getLogger(ProfessorService.class.getName()).log(Level.SEVERE, null, ex);
        		}
        	}
        }
        return null;
	}
        
		
}
