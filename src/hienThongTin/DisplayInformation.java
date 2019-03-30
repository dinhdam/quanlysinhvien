package hienThongTin;
import java.sql.* ;

import connect.ConnectDB;
public class DisplayInformation {
	Connection conn = null ;
	PreparedStatement ptmt = null;
	ConnectDB kn = new ConnectDB();
public void display() {
	conn = kn.openConnection();
	String sql = " select * from  C##DT.listStudent";
	try {
		ptmt = conn.prepareStatement(sql);
		// khoi tao cai resultSet
		ResultSet rs = ptmt.executeQuery(); // ko truyen tham so sql ;
		System.out.println( "idStudent||  full name    ||classStudent    ||email             ||phone           ||note   " );
		while(rs.next()) { //boolean co du lieu tra ve true ko co du lieu tra ve false;
			// khoi  tao bien voi cac thuoc tinh
			int idStudent = rs.getInt("idStudent"); //String collumn
			String fullname = rs.getString("fullname");
			String email = rs.getString("email");
			int phone = rs.getInt("phone");
			String note = rs.getString("note");
			String classStudent = rs.getString("classStudent");
			System.out.print(idStudent + " ");
			System.out.print("           " +fullname);
			System.out.print("            " +classStudent);
			System.out.print("       " +email);
			System.out.print("       " +phone);
			System.out.print("   " +note);
		}
		
	} catch (SQLException e) {
		System.out.println( " loi : " +e.getMessage());
	}
	
}
}
