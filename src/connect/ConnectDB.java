package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDB {

 public static Connection openConnection() {
	   String URL="jdbc:oracle:thin:@localhost:1521:dinhdam" ;
	   String USER="C##DT";
	   String PASS="123456";
	 Connection conn = null;
	 try {
		 System.out.println("connection...");
		 conn = DriverManager.getConnection(URL,USER,PASS);
		 if(conn != null) {
			 System.out.println("successfull connected");
		 }
		 
		
	} catch (Exception e) {
		e.printStackTrace();
		
	   System.out.println("connected fail");
	}
	 return conn;
 }
 public static void closeConnection(Connection conn , PreparedStatement sts) {
	 if(conn != null) {
		 try {
			 conn.close();
			 if(conn == null ) {
				 System.out.println(" stop connected");
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 if(sts != null) {
		 try {
			sts.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
 }
 
 
 }
