package xoaSV;
import java.sql.*;
import java.util.*;

import connect.ConnectDB;
public class DeleteStudent {
	
 public static void deleteStudents() {
	 
	 //ham static giup chung ta khong phai khoi tao lai ham
	 int idStudent;
	 Scanner sc = new Scanner(System.in);
	 Connection conn = ConnectDB. openConnection();
	 idStudent = sc.nextInt();
	 System.out.print(" nhap vao idStudent can xoa  :  ");
	
	 try {
		PreparedStatement ptmt = conn.prepareStatement("delete  from  C##DT.listStudent where idStudent = ?");
		
		ptmt.setInt(1, idStudent);
		int kt = ptmt.executeUpdate();
		if(kt != 0 ) {
			System.out.println("xoa thanh cong");
		} else {
			System.out.println(" xoa khong thanh cong");
		}
		ptmt.close();
		conn.close();
	} catch (SQLException e) {
		System.out.println(" loi : " + e.getMessage());
	}
 }
}
