/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndependentStudy;

/**
 *
 * @author ivatu
 */
public class ProfCourse {
    private String c_id;
    private String p_id;
  
    public ProfCourse(String c_id, String p_id) {
        super();
        this.c_id = c_id;
	this.p_id = p_id;
    }
    public ProfCourse() {
	super();
    }
	
	@Override
	public String toString() {
		return "ProfCourse [c_id=" + c_id + ", p_id=" + p_id + "]";
	}
	
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
}
