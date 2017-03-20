package IndependentStudy;

import java.sql.*;
import java.util.logging.*;
import java.util.List;
import java.util.ArrayList;

public class CourseDAO {

	private static Connection con = null;
	
	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		CourseDAO.con = con;
	}

	public static boolean insert(Course cr){
		if(cr == null){
				return  false;
			}
			try{
				PreparedStatement ps  = con.prepareStatement("insert into Course (semester, coursename, credits)" + "values (?,?,?)" );
				ps.setString(1, cr.getSemester());
				ps.setString(2, cr.getCourseName());
				ps.setInt(3, cr.getCredits());
				int count = ps.executeUpdate();
				con.commit();
                                
                                System.out.println("in dao: " + cr);
                                
				if(count > 0){
					return true;
				}
			}catch(SQLException ex){
				Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
		}
        public static void insertProfCourse(int courseId, int profId){
            try{
                PreparedStatement ps  = con.prepareStatement("insert into prof_course (c_id, p_id)" + "values (?,?)" );
		ps.setInt(1, courseId);
		ps.setInt(2, profId);
		int count = ps.executeUpdate();
		con.commit();
                System.out.println("inserted profcourse details in dao: ");
            }catch(SQLException ex){
		Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public static void insertUserCourse(int courseId, int userId){
            try{
                PreparedStatement ps  = con.prepareStatement("insert into user_course (c_id, u_id)" + "values (?,?)");
		ps.setInt(1, courseId);
		ps.setInt(2, userId);
		int count = ps.executeUpdate();
		con.commit();
                System.out.println("inserted usercourse details in dao: ");
            }catch(SQLException ex){
		Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public static Course crseSelection(int credits){
		if(credits == 0){
			return null;
		}
		try{
			String queryString = "SELECT * FROM Course WHERE credits = ? ;";
			//Create a statement
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setInt(1, credits);
			ResultSet rset = ps.executeQuery();
			if(rset.next()){
				Course cr = new Course();
				cr.setSemester(rset.getString(1));
				cr.setCourseName(rset.getString(2));
				cr.setCredits(rset.getInt(3));
				return cr;
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
              
                
                
	public static List<Course> getAllCourse() {
		try {
			Statement stat = con.createStatement();
	        ResultSet rs = stat.executeQuery("select * from Course");
	        ArrayList<Course> data = new ArrayList<Course>();
	        while (rs.next()) {
	        	Course cr = new Course();
	        	cr.setc_id(rs.getInt("c_id"));
	        	cr.setSemester(rs.getString("semester"));
	        	cr.setCourseName(rs.getString("CourseName"));
	        	cr.setCredits(rs.getInt("Credits"));
	        	data.add(cr);
	        }
	        return data;
	    } catch (SQLException ex) {
	        Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }return null;
	}
	
	
	
	
}
