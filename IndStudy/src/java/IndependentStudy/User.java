package IndependentStudy;

import java.util.Date;

public class User {

    private int u_id;
    private int cwid;
    private String f_name;
    private String l_name;
    private String user_name;
    private String pass_word;
    private String street_name;
    private int house_num;
    private String city;
    private int zip_code;
    private String sex;
    private Date dob;
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
	public User(int cwid, String f_name, String l_name, String user_name, String pass_word,
			String street_name, int house_num, String city, int zip_code, String sex, Date dob) {
		this.cwid = cwid;
		this.f_name = f_name;
		this.l_name = l_name;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.street_name = street_name;
		this.house_num = house_num;
		this.city = city;
		this.zip_code = zip_code;
		this.sex = sex;
		this.dob = dob;
	}
	
	public User(int u_id, String f_name, String l_name, String user_name, String pass_word, String street_name,
			String city, String sex) {
		this.u_id = u_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.street_name = street_name;
		this.city = city;
		this.sex = sex;
	}

	public User(String user_name, String pass_word) {
		this.user_name = user_name;
		this.pass_word = pass_word;
	}
        
        public User(int u_id, int cwid, int house_num, int zip_code, Date dob) {
		this.u_id = u_id;
		this.cwid = cwid;
		this.house_num = house_num;
		this.zip_code = zip_code;
		this.dob = dob;
	}
	
	public User() {
	}

	public String toString() {
		return "User [u_id=" + u_id + ", cwid=" + cwid + ", f_name=" + f_name + ", l_name=" + l_name + ", user_name="
				+ user_name + ", pass_word=" + pass_word + ", street_name=" + street_name + ", house_num=" + house_num
				+ ", city=" + city + ", zip_code=" + zip_code + ", sex=" + sex + ", dob=" + dob + "]";
	}
	public int getu_id() {
		return u_id;
	}

	public void setu_id(int u_id) {
		this.u_id = u_id;
	}

	public int getCwid() {
		return cwid;
	}

	public void setCwid(int cwid) {
		this.cwid = cwid;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public int getHouse_num() {
		return house_num;
	}

	public void setHouse_num(int house_num) {
		this.house_num = house_num;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
    
}

