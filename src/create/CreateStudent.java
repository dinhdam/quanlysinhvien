package create;
import java.sql.*;
import java.util.*;

import connect.ConnectDB;
// them sua xoa su dung executeUpdate , ham nay tra ve kieu int
// select(hien thi du lieu ) su dung executeQuery
// b1 import thu vien
// b2 khoi tao doi tuong connection ,PreparedStatement,: gan ket noi cho doi tuong connection vua tao
//b3a: vao oracle tao mot cai bang la listStudent chua cac thuoc tinh cua bang 
// b3b them  du lieu : khoi tao chuoi them du lieu
//b3c : khai bao bien id_name ,.....
//b4 : truyen sql vao trong doi tuong PreparedStatement
//b5 : thuc thi sql 
//b6 : dong du lieu lai PreparedStatement
public class CreateStudent {
	Scanner scanner = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement ptmt = null;
	ConnectDB kn = new ConnectDB();
	public void InsertStudent() {
		conn = kn.openConnection();
		// khai bao bien 
		int idStudent;
		String fullname;
		String email ;
		int phone;
		String classStudent;
		String note;
		System.out.print("nhap id : ");
		idStudent = Integer.parseInt(scanner.nextLine());
		System.out.print("nhap ho ten  sinh vien : ");
	    fullname = scanner.nextLine();
		System.out.print(" nhap vao ten lop :");
		classStudent = scanner.nextLine();
		System.out.print("nhap vao email : ");
		email = scanner.nextLine();
		System.out.println(" nhap vao  ghi chu : ");
		note = scanner.nextLine();
		System.out.print("nhap vao so dien thoai : ");
		phone = scanner.nextInt();
		String sql = "insert  into C##DT.listStudent (idStudent, fullname,classStudent,email,note,phone) values (?,?,?,?,?,?)";
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1,idStudent);
			ptmt.setString(2, fullname);//vitri ,ten bien
			ptmt.setString(3,classStudent);
			ptmt.setString(4,email);
			ptmt.setString(5,note);
		    ptmt.setInt(6,phone);
			 int kt = ptmt.executeUpdate();
			 if(kt != 0 ) {
				 System.out.println(" them thanh cong");
			 }else {
				 System.out.println("them ko thanh cong");
			 }
			 ptmt.close();
			 
		} catch (SQLException e) {
			
			System.out.println(" loi "+ e.getMessage());
		}
	}

}
