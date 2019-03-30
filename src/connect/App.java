package connect;

import java.sql.Connection;

import create.CreateStudent;

import hienThongTin.DisplayInformation;
import xoaSV.DeleteStudent;

public class App {
	public static void main (String[]args) {
//		CreateStudent st = new CreateStudent();
//		st.InsertStudent();
		DisplayInformation di = new DisplayInformation();
		di.display();
		DeleteStudent.deleteStudents();
	}

}
