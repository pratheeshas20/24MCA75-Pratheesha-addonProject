package shapes;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		// JDBC Connection URLS :
		String url = "jdbc:mysql://localhost:3306/addon_jdbc?characterEncoding=utf8";
		String username = "root";
		String password = "prathee";
		
		int Shape_id;
		String Shape_type;
	    double length,breadth,height;
		
	    
		String qry = "";

		try {

			int option = 1;

			while (option != 9) {
				
				Connection connection = DriverManager.getConnection(url,username,password);
				
				Statement statement = connection.createStatement();
				ResultSet resultSet;
				
				PreparedStatement preparedStatement;
				
				System.out.println("\nMySQL Database Connectivity....");
				System.out.println("\t1. Insert data,");
				System.out.println("\t2. Update data,");
				System.out.println("\t3. View data,");
				System.out.println("\t4. Delete data,");
				System.out.println("\t9. Quit");
				System.out.println("\nEnter Your Choice : ");
				option = scanner.nextInt();

				switch (option) {
				case 1:
					System.out.printf("\nInsert data,");
					scanner.nextLine();
					System.out.printf("\nEnter your Shape id : ");
					Shape_id = scanner.nextInt();
					scanner.nextLine();
					System.out.printf("\nEnter your Shape_type : ");
					Shape_type = scanner.nextLine();
					System.out.printf("Enter Your length  : ");
					length = scanner.nextDouble();
					scanner.nextLine();
					System.out.printf("Enter Your breadth : ");
					breadth = scanner.nextDouble();
					System.out.printf("Enter Your height : ");
					height = scanner.nextDouble();
					
					// qry = "INSERT INTO `users`.`employee` (`emp_name`, `emp_age`, `emp_city`, `emp_mno`) VALUES ('abc', '12', 'abc', '7894561230')";
					qry = "INSERT INTO addon_jdbc.shapes (Shape_id, Shape_type, length, breadth,height) VALUES (?, ?, ?, ?,?)";
					preparedStatement = connection.prepareStatement(qry); 
					
					preparedStatement.setInt(1, Shape_id);
					preparedStatement.setString(2, Shape_type);
					preparedStatement.setDouble(3, length);
					preparedStatement.setDouble(4, breadth);
					preparedStatement.setDouble(5, height);
					preparedStatement.executeUpdate();
					
					System.out.println("\nYour Data Save DONE....");
					
					break;
				case 2:
					System.out.println("\nUpdate data,");
					scanner.nextLine();
					System.out.printf("\nEnter the Shape_id : ");
					Shape_id = scanner.nextInt();
					//scanner.nextLine();
					System.out.printf("Enter your Shape_type : ");
					Shape_type = scanner.nextLine();
					System.out.printf("Enter Your length  : ");
					length = scanner.nextDouble();
					//scanner.nextLine();
					System.out.printf("Enter Your breadth : ");
					breadth = scanner.nextDouble();
					System.out.printf("Enter Your height : ");
					height = scanner.nextDouble();
					
					qry = "UPDATE addon_jdbc.shapes SET Shape_type = ?, length = ?, breadth = ?,height = ? WHERE (Shape_id = ?)";
					
					preparedStatement = connection.prepareStatement(qry);
					
					preparedStatement.setString(1, Shape_type);
					preparedStatement.setDouble(2, length);
					preparedStatement.setDouble(3, breadth);
					preparedStatement.setDouble(4, height);
					preparedStatement.setInt(5, Shape_id);
					preparedStatement.executeUpdate();
					
					System.out.println("\nYour Data Update DONE....");
					break;
					
				case 3:
					System.out.println("\nView data,");
					
					qry = "SELECT * FROM addon_jdbc.shapes";
					resultSet = statement.executeQuery(qry);
					
					while (resultSet.next()) {
						Shape_id = resultSet.getInt("Shape_id");
						Shape_type = resultSet.getString("Shape_type");
						length = resultSet.getDouble("length");
						breadth = resultSet.getDouble("breadth");
						height = resultSet.getDouble("height");
						
						System.out.println(Shape_id + ", " + Shape_type + ", " + length + ", " + breadth + ", " + height);
					}
					break;
				case 4:
					System.out.println("\nDelete data,");
					
					System.out.printf("\nEnter Deleting Id : ");
					Shape_id = scanner.nextInt();
					
					qry = "DELETE FROM addon_jdbc.shapes WHERE (emp_id = ?)";
					
					preparedStatement = connection.prepareStatement(qry);
					preparedStatement.setInt(1, Shape_id);
					preparedStatement.executeUpdate();
					
					System.out.println("Data Delete Success...");
					break;
				case 9:
					System.out.println("\n\nProgram ends now....");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option try again...");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("\n\nError :- " + e.getMessage());
		}

	}

}

