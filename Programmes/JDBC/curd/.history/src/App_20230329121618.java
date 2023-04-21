package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcURL = "jdbc:mysql://localhost:3306/sample_db";
		String dbUsername = "root";
		String dbPassword = "1234";

		Scanner myObj = new Scanner(System.in);
		Scanner myObjs = new Scanner(System.in);

		System.out.println("1:Add Data" );
		System.out.println("2:Update Data" );
		System.out.println("3:Delete Data" );
		System.out.println("4:View Data" );
		
		int CURD = myObjs.nextInt();

		if (CURD == 1) {
			// Create a Scanner object
			System.out.print("Enter username:");
			String username = myObj.nextLine(); // Read user input
		
			System.out.print("Enter Email:");
			String email = myObj.nextLine(); // Read user input
			
			System.out.print("Enter FullName:");
			String fullname = myObj.nextLine(); // Read user input
		
			System.out.print("Enter Password:");
			String password = myObj.nextLine(); // Read user input
	
			myObj.close();

			try {
				Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);

				String sql = "INSERT INTO user (username, email, fullname, password)" + " VALUES (?,?,?,?)";

				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				statement.setString(2, email);
				statement.setString(3, fullname);
				statement.setString(4, password);

				int rows = statement.executeUpdate();
				if (rows > 0) {
					System.out.println("new user has been inserted successfully.");
				}
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		if (CURD == 2) {
			System.out.print("Enter Existing UserName:");
			String username = myObj.nextLine(); // Read user input

			System.out.print("Update Email:");
			String email = myObj.nextLine(); // Read user input
		
			System.out.print("Update FullName:");
			String fullname = myObj.nextLine(); // Read user input
		
			System.out.print("Update Password:");
			String password = myObj.nextLine(); // Read user input
		
			myObj.close();
			try {
				Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);

				String sql = "UPDATE user SET password=?, fullname=?, email=? WHERE username=?";
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.setString(1, password);
						statement.setString(2, email);
						statement.setString(3, fullname);
						statement.setString(4, username );
						

						int rows = statement.executeUpdate();
						if (rows > 0) {
							System.out.println("Info Updated successfully.");
						}
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (CURD == 3) {
			System.out.print("Enter Existing UserName:");
			String username = myObj.nextLine(); // Read user input // Read user input
		
			myObj.close();
			try {
				Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);

				String sql = "DELET FROM user WHERE username=?";
				PreparedStatement statement = connection.prepareStatement(sql);
			
						statement.setString(1, username );
						

						int rows = statement.executeUpdate();
						if (rows > 0) {
							System.out.println("Info Updated successfully.");
						}
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		if (CURD == 4) {
			try {
				Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);

				String sql ="SELECT * FROM user";
						Statement statement = connection. createStatement();
						ResultSet result = statement. executeQuery(sql);
						while (result. next()) {
						int userld = result.getInt("user_id");
						String username= result.getString("username");
						String fullname = result.getString("fullname");
						String email= result.getString("email");
						String password = result.getString("password");
						
						System.out.println(userld + ":"+ username +":"+fullname+":"+email+":"+ password);
						}
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}

}