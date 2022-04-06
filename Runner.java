package databaseGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.*;

public class Runner {
	public static String currentTable;
	
	public static void main(String[] args) {
		
		
		//attempt to select all from a table and print it out on JFrame
	
		//creates main window for viewing
		JFrame mainWindow = new JFrame("DatabaseViewer");
		mainWindow.setPreferredSize(new Dimension(1000, 500));
		mainWindow.pack();
		//creates all buttons for main window
		JButton customer = new JButton("Customers");
		JButton plane = new JButton("Planes");
		JButton flight = new JButton("Flights");
		JButton route = new JButton("Routes");
		JButton airport = new JButton("Airports");
		JButton flightAtt = new JButton("Flight Attendants");
		JButton captain = new JButton("Captain");
		
		
		
		
		
		
		
		customer.setBounds(800, 0, 200, 50);
		mainWindow.add(customer);
		plane.setBounds(800,50,200,50);
		mainWindow.add(plane);
		flight.setBounds(800,100, 200, 50);
		mainWindow.add(flight);
		route.setBounds(800,150, 200, 50);
		mainWindow.add(route);
		airport.setBounds(800,200, 200, 50);
		mainWindow.add(airport);
		flightAtt.setBounds(800,250, 200, 50);
		mainWindow.add(flightAtt);
		captain.setBounds(800,300, 200, 50);
		mainWindow.add(captain);
		
		
		JTextField test = new JTextField();
		test.setBounds(5,15,150,20);
		JLabel emptyLabel = new JLabel();
		
		//defaults to closing program when window is closed
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//adding components to mainWindow
		mainWindow.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		mainWindow.getContentPane().add(test, BorderLayout.SOUTH);
		//mainWindow.add(a);
		//window size and design
		
		
		mainWindow.setVisible(true);
		
		
		
		
		
		//creates secondary window for specific table viewing
		JFrame secondWindow = new JFrame("TableViewer");
		secondWindow.setPreferredSize(new Dimension(1000, 500));
		secondWindow.pack();
		
		//attempt to add scrollpanel to text box for table output
		
		JPanel textPanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		textPanel.add(scrollPane);
		JTextArea textArea = new JTextArea(28,70);
		
		scrollPane.setViewportView(textArea);
		secondWindow.add(textPanel, BorderLayout.WEST);
		
		
		
		//creates buttons for secondary window
		JButton back = new JButton("Back");
		JButton add = new JButton("Insert Data");
		JButton select = new JButton ("Select Data");
		JButton update = new JButton ("Update Data");
		JButton remove = new JButton ("Remove Data");
		//add buttons to second window and sets their position and size
		
		secondWindow.add(back);
		back.setBounds(800,0,200,50);
		secondWindow.add(add);
		add.setBounds(800,50,200,50);
		secondWindow.add(select);
		select.setBounds(800,100, 200, 50);
		secondWindow.add(update);
		update.setBounds(800,150, 200, 50);
		secondWindow.add(remove);
		remove.setBounds(800,200, 200, 50);
		//adding components to secondWindow
		secondWindow.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		
		
		
		//Checks mainWindow button presses, assigns currentTable string to whatever table is currently open
		
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				secondWindow.setTitle("Customer Table");
				currentTable = "CUSTOMER";
				try (
				         // Step 1: Construct a database 'Connection' object called 'conn'
				         Connection conn = DriverManager.getConnection(
				               "jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
				               "root", "root");   // For MySQL only
				               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
				 
				         // Step 2: Construct a 'Statement' object called 'stmt' inside the Connection created
				         Statement stmt = conn.createStatement();
				      ) {
				         // Step 3: Write a SQL query string. Execute the SQL query via the 'Statement'.
				         //  The query result is returned in a 'ResultSet' object called 'rset'.
				         String strSelect = "select * from CUSTOMER";
				        // System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
				 
				         ResultSet rset = stmt.executeQuery(strSelect);
				 
				         // Step 4: Process the 'ResultSet' by scrolling the cursor forward via next().
				         //  For each row, retrieve the contents of the cells with getXxx(columnName).
				         //System.out.println("The records selected are:");
				        //int rowCount = 0;
				         // Row-cursor initially positioned before the first row of the 'ResultSet'.
				         // rset.next() inside the whole-loop repeatedly moves the cursor to the next row.
				         // It returns false if no more rows.
				         System.out.printf("%11s%2s%25s%2s%25s%2s%50s%2s%50s%2s%20s%2s%5s%2s%12s%2s%25s%2s%3s%2s%11s%n", "Customer ID", "|", 
				        		 "First Name", "|", "Last Name", "|", "Address", "|", "City", "|", "State", "|", "Zip", "|", "Phone Number", "|", "Seat Number", "|", "Age", "|", "Flight Num");
				         System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------"
				         		+ "-------------------------------------------------------------------------------------------------------------------");
				         //eventual sysout for solid dashed line
				         while(rset.next()) {   // Repeatedly process each row
				            int customerID = rset.getInt("CUST_ID");
				            String custFName = rset.getString("CUST_FNAME");
				            String custLName = rset.getString("CUST_LNAME");
				            String custAdd = rset.getString("CUST_ADDRESS");
				            String custCity = rset.getString("CUST_CITY");
				            String custState = rset.getString("CUST_STATE");
				            int custZip = rset.getInt("CUST_ZIP");
				            String custPhone = rset.getString("CUST_PHONENUM");
				            String custSeatNum = rset.getString("CUST_SEATNUM");
				            int custAge = rset.getInt("CUST_AGE");
				            int flightNum = rset.getInt("CUST_AGE");
				            
				            System.out.printf("%11s%2s%25s%2s%25s%2s%50s%2s%50s%2s%20s%2s%5s%2s%12s%2s%25s%2s%3s%2s%11s%n", String.valueOf(customerID), "|", custFName, "|",
				            		custLName, "|", custAdd, "|", custCity, "|", custState, "|", String.valueOf(custZip), "|", custPhone, "|", custSeatNum, "|", 
				            		String.valueOf(custAge), "|", String.valueOf(flightNum));
				            
				            // retrieve a 'String'-cell in the row
				            //double price = rset.getDouble("price");  // retrieve a 'double'-cell in the row
				           // int    qty   = rset.getInt("qty");       // retrieve a 'int'-cell in the row
				            //System.out.println(name);
				            //++rowCount;
				         }
				        // System.out.println("Total number of records = " + rowCount);
				 
				      } catch(SQLException ex) {
				         ex.printStackTrace();
				      }
				secondWindow.setVisible(true);
			}
		});
		
		plane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				currentTable = "Plane";
				secondWindow.setVisible(true);
			}
		});
		
		flight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				currentTable = "Flight";
				secondWindow.setVisible(true);
			}
		});
		
		route.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				currentTable = "Route";
				secondWindow.setVisible(true);
			}
		});
		
		airport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				currentTable = "Airport";
				secondWindow.setVisible(true);
			}
		});
		
		flightAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				currentTable = "FlightAtt";
				secondWindow.setVisible(true);
			}
		});
		
		captain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				currentTable = "Captain";
				secondWindow.setVisible(true);
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secondWindow.setVisible(false);
				//Debug sysout
				//System.out.println(currentTable);
				currentTable = "";
				mainWindow.setVisible(true);
			}
		});
		
		while(currentTable != null) {
			System.out.println("test");
			//connection to database established here
			
			
		}
		
		
	}
}



