package Student_view;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Student_Controler.Student_Controller;
import Student_model.Student_model;

public class Student_view {
	static Scanner sc = new Scanner(System.in);
	static Student_Controller c = new Student_Controller();

	private static Student_model getStudentData() {
		Student_model s = new Student_model();

		System.out.println("Enter id");
		int id = sc.nextInt();

		sc.nextLine();

		System.out.println("Enter Name");
		String name = sc.nextLine();

		System.out.println("Enter Address");
		String address = sc.nextLine();

		System.out.println("Enter email");
		String email = sc.nextLine();

		System.out.println("Enter gender");
		String gender = sc.nextLine();

		s.setId(id);
		s.setAddress(address);
		s.setGender(gender);
		s.setMob(gender);
		s.setName(name);
		s.setEmail(email);

		return s;

	}


	public static void main(String[] args) {

		System.out.println("Welcome \n\n");

		System.out.println("1. Add/Save Student Data");
		System.out.println("2. Fetch  Student Data");
		System.out.println("3. Delete Student Data");
		System.out.println("4. Update Student Data");
		System.out.println("5. Student Data by email");
		System.out.println("6. Exit");

		while (true) {
			System.out.println("Enter your choice");
			int choice = sc.nextInt();

//			 sc.nextLine();

			switch (choice) {
			case 1:
				Student_model s = getStudentData();
				c.saveStudent(s);
				break;
			case 2:
				c.fetchStudentDatas();
//				System.out.println(2);
				break;
			case 3:
				System.out.println("Enter user id");
				int id = sc.nextInt();
				c.DeleteStudentData(id);

				break;
			case 4:
				System.out.println("enter id:");
				int iid = sc.nextInt();
				sc.nextLine();
				System.out.println("enter name");
				String name= sc.nextLine();
				c.updateStudentdata(iid,name);

				break;
			case 5:
				System.out.println("enter your email");
				sc.nextLine();
				String email= sc.nextLine();
				c.fetchStudentBYEmail(email);
						
				break;
			case 6:
				System.out.println("Thank You");
				return;
			default:
				System.out.println("invalid choice ");
				break;
			}

		}

	}

}
