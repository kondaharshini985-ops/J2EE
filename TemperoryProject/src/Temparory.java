import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

public class Temparory {

		public static void main(String [] args) {
			String url="jdbc:mysql://localhost:3306/student";
			String user="root";
			String password="root";
			Connection con= null;
			Statement stmt=null;
			//String query="INSERT INTO STUDENT VALUES(198,8397905190,'Harsha','haha@gmail.com','karimnar','karimnagar',1534,'2025-11-12')";
			String query1="select * from student";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the query");
			String query2 = sc.nextLine();
			
			
		
			try {
				System.out.println("load and register the driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection(url,user,password);
				System.out.println("connection established");
				stmt = con.createStatement();
				System.out.println("Platform created");
				boolean res =stmt.execute(query1);
				//int  result =stmt.executeUpdate(query);
				
				//System.out.println(result);
				System.out.println(res);
				boolean b =stmt.execute(query2);
				System.out.print(b);
			}
			catch(Exception e) {
				
			e.printStackTrace();
		}
	

}
} 