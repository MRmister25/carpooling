package com.carpooling.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String sql="select * from registration where EMAIL=? and PASS=?";
	String url="JDBC:mysql://localhost:3306/carpooling";
	String uname="root";
	String pass="admin";
	public boolean check(String e,String p) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uname, pass);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, e);
			st.setString(2, p);
			ResultSet rs=st.executeQuery();
			if(rs.next())
				return true;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		return false;
	}
}
