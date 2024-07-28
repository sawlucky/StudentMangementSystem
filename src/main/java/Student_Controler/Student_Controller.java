package Student_Controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Student_model.Student_model;

public class Student_Controller {

	public void saveStudent(Student_model s) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentMnagementSystem",
					"postgres", "root");
			PreparedStatement psmt = con.prepareStatement("insert into sms values(?,?,?,?,?)");

			psmt.setInt(1, s.getId());
			psmt.setString(2, s.getName());
			psmt.setString(3, s.getAddress());
			psmt.setString(4, s.getEmail());
			psmt.setString(5, s.getGender());
			System.out.println(psmt);
			int n = psmt.executeUpdate();
			System.out.println(n);

			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void fetchStudentDatas() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentMnagementSystem",
					"postgres", "root");
			PreparedStatement psmt = con.prepareStatement("select * from sms");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt(1) + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.print(rs.getString(3) + " ");
				System.out.print(rs.getString(4) + " ");
				System.out.print(rs.getString(5) + " ");

			}
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	static ArrayList<Student_model> arr = new ArrayList<Student_model>();

	public void saveData(Student_model s) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getId() == s.getId()) {
				arr.set(i, s);
				return;
			}
		}
		arr.add(s);
	}

	public void DeleteStudentData(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentMnagementSystem",
					"postgres", "root");
			PreparedStatement psmt = con.prepareStatement("delete from sms where id=?");
			psmt.setInt(1, id);
			int n = psmt.executeUpdate();
			System.out.println(n);

			if(n!=0)
			{
				System.out.println("record deleted"+" "+n);
			}
			else
				System.out.println("record not found");
			
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void updateStudentdata(int id, String name) {
		try {

			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentMnagementSystem",
					"postgres", "root");
			PreparedStatement psmt = con.prepareStatement("update sms set name= ? where id =?");
			psmt.setString(1, name);
			psmt.setInt(2, id);

			int n = psmt.executeUpdate();
			System.out.println(n);
			System.out.println("data has been succefully updated");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean fetchStudentDataInd(int id) {
		for (Student_model data : arr) {
			if (data.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Student_model getStudentById(int id) {
		for (Student_model data : arr) {
			if (data.getId() == id) {
				return data;
			}
		}
		return null;
	}

	public void fetchStudentBYEmail(String email) {

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentMnagementSystem",
					"postgres", "root");
			PreparedStatement psmt = con.prepareStatement("select * from sms where email=?");
			psmt.setString(1, email);

			

			ResultSet rs = psmt.executeQuery();
			
				while (rs.next()) {
					System.out.print(rs.getInt(1) + " ");
					System.out.print(rs.getString(2) + " ");
					System.out.print(rs.getString(3) + " ");
					System.out.print(rs.getString(4) + " ");
					System.out.print(rs.getString(5) + " ");

				}
			System.out.println();
			con.close();

		} catch (Exception e) {

		}
	}

}
