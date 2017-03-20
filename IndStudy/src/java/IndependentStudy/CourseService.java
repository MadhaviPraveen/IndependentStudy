package IndependentStudy;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.*;

	public class CourseService {
		
		public static void main (String[] args){
			Course cr = new Course();	
			cr.setCredits(4);
			cr.setSemester("FAll2016");
			cr.setCourseName("Web Development");
			insertCourse(cr);
		}
		
		public static boolean insertCourse(Course cr){
			Connection con = null;
			try{
				con = DBConection.getConnection();
				CourseDAO.setCon(con);
                                System.out.println("in service " + cr);
				boolean test = CourseDAO.insert(cr);
				con.commit();
				return test;
			}
			catch(SQLException ex){
				Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
			}finally{
				if(con != null){
					try{
						con.close();
					}catch(SQLException ex){
						Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
			return false;
		} 
		
		public static Course crseSelection(int credits){
			Connection con = null;
			try{
				con = DBConection.getConnection();
				CourseDAO.setCon(con);
				return CourseDAO.crseSelection(credits);
			}
			catch(SQLException ex){
				Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
			}
			return null;
		}
		
		public static void insertProfCourse(int courseId, int profId){
			Connection con = null;
			try{
				con = DBConection.getConnection();
				CourseDAO.setCon(con);
				CourseDAO.insertProfCourse(courseId, profId);
			}
			catch(SQLException ex){
				Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
                
                public static void insertUserCourse(int courseId, int userId){
			Connection con = null;
			try{
				con = DBConection.getConnection();
				CourseDAO.setCon(con);
				CourseDAO.insertUserCourse(courseId, userId);
			}
			catch(SQLException ex){
				Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
                public static List<Course> getAllCourse() {
                    Connection con = null;
                    try {
                        con = DBConection.getConnection();
                        CourseDAO.setCon(con);
                        return CourseDAO.getAllCourse();
                    } catch (SQLException ex) {
                    Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if (con != null) {
                            try {
        			con.close();
                            } catch (SQLException ex) {
                                Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    return null;
                }
                
	}
