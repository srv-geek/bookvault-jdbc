package com.jbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Book {

	public static void main(String[] args) throws Exception {
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    String url = "jdbc:mysql://localhost:3306/batch1200";
	    String username = "root";
	    String password = "55035";

	    Connection c = DriverManager.getConnection(url, username, password);
	    Scanner sc = new Scanner(System.in);

	    while (true) {
	        System.out.println("\nChoose an operation:");
	        System.out.println("1. Add book");
	        System.out.println("2. Remove book");
	        System.out.println("3. Update book name");
	        System.out.println("4. Update book author");
	        System.out.println("5. Update book price");
	        System.out.println("6. Search book by name");
	        System.out.println("7. Exit");

	        int choice = sc.nextInt();
	        sc.nextLine(); 

	        switch (choice) {
	            case 1:
	            	PreparedStatement Stmt = c.prepareStatement("create table book(id int AUTO_INCREMENT PRIMARY KEY, name text,price int, author text);");
	                Stmt.executeUpdate();
	                System.out.println("Book added!");
	               
	                PreparedStatement insertStmt = c.prepareStatement("INSERT INTO book VALUES(?, ?, ?, ?);");
	              
	                for(int i = 1; i <= 5; i++) {
	                System.out.println("Enter id of the book: ");
	                int id = sc.nextInt();
	                
	                System.out.println("Enter name of the book: ");
	                String name = sc.next();
	                
	                System.out.println("Enter price of the book: ");
	                int price = sc.nextInt();

	                System.out.println("Enter author of the book: ");
	                String author = sc.next();
	                
	                insertStmt.setLong(1, id);
	                insertStmt.setString(2, name);
	                insertStmt.setInt(3, price);
	                insertStmt.setString(4, author);
	                insertStmt.executeUpdate();
	                System.out.println("added");
	                }
	                break;

	            case 2:
	            	System.out.println("Enter name of the book to delete: ");
	                String bookNameToDelete = sc.nextLine();
	    	    
	    	        PreparedStatement deleteStmt = c.prepareStatement("DELETE FROM book WHERE name = ?;");
	                deleteStmt.setString(1, bookNameToDelete);
	                deleteStmt.executeUpdate();
	                System.out.println("book deleted successfully!");
	                break;

	            case 3:
	            	System.out.println("Enter name of the book to update: ");
	                String bookName = sc.nextLine();

	                System.out.println("Enter new name: ");
	                String newname = sc.nextLine();

	                PreparedStatement updatename = c.prepareStatement("UPDATE book SET name = ? WHERE name = ?;");
	                updatename.setString(1, newname);
	                updatename.setString(2, bookName);
	                updatename.executeUpdate();
	                System.out.println("book name updated successfully!");
	                break;
	                  
	            case 4:
	            	System.out.println("Enter author of the book to update: ");
	                String author = sc.nextLine();

	                System.out.println("Enter new author: ");
	                String newauthor = sc.nextLine();

	                PreparedStatement updateauthor = c.prepareStatement("UPDATE book SET author = ? WHERE author = ?;");
	                updateauthor.setString(1, newauthor);
	                updateauthor.setString(2, author);
	                updateauthor.executeUpdate();
	                System.out.println("book author updated successfully!");
	                break;
	            case 5:
	            	System.out.println("Enter price of the book to update: ");
	            	int price = sc.nextInt();

	            	System.out.println("Enter new price: ");
	            	int newprice = sc.nextInt();

	            	PreparedStatement updateStmt = c.prepareStatement("UPDATE book SET price = ? WHERE price = ?;");
	            	updateStmt.setInt(1, newprice);
	            	updateStmt.setInt(2, price);
	            	updateStmt.executeUpdate();
	            	System.out.println("book price updated successfully!");
	            	break;	
	            case 6:
	            	PreparedStatement selectStmt = c.prepareStatement("SELECT * FROM book;");
		            ResultSet rs = selectStmt.executeQuery();
		            System.out.println("book Details:");
		            while (rs.next()) {
		            	System.out.println("Name: " + rs.getString("name"));
		            }
		            break;

	            case 7:
	                System.out.println("Exiting...");
	                c.close();
	                sc.close();
	                return;

	            default:
	                System.out.println("Invalid choice. Try again.");
	        }
	    }
	}
	
}
	    
