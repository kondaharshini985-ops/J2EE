package com.pac;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Trial {

public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/employee";
	String username ="root";
	String password ="root";
	Connection conn = null;
	Scanner sc = new Scanner(System.in);
	ResultSet rSet=null;
	while(true) {
	System.out.println("Enter the name: ");
	
	
	String name = sc.next();
  
	System.out.println("Enter the city : ");
	String city =sc.next();
	System.out.println("Enter the sal: ");
	long sal = sc.nextLong();	
	if(sal==0) {
		break;
	}
	String query ="insert into emp(empid,name,city,sal) values(0,?,?,?)";
	String query2 ="select * from emp";
	PreparedStatement ps =null;
	
	try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 conn=DriverManager.getConnection(url,username,password);
	 ps=conn.prepareStatement(query);
	 ps.setString(1, name);
	 ps.setString(2, city);
	 ps.setLong(3, sal);
	 
	 int res =ps.executeUpdate();
	 System.out.println(res);
	 rSet=ps.executeQuery(query2);
	 
	 while(rSet.next()) {
		 System.out.println(rSet.getString("name"));
		 System.out.println(rSet.getString("city"));
		 System.out.println(rSet.getLong("sal"));
	 }
	// System.out.println(ps.getStriing("name"));
	 //System.out.println(ps.getString("city"));
	 //System.out.println(ps.getLong("sal"));
	 
	 
			 
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	
}

}
