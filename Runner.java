package databaseGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import java.sql.*;

public class Runner {
	public static String currentTable;

	public static void main(String[] args) {




		//creates main window for viewing
		JFrame mainWindow = new JFrame("DatabaseViewer");
		mainWindow.setPreferredSize(new Dimension(1200, 600));
		mainWindow.pack();
		//creates all buttons for main window
		JButton customer = new JButton("Customers");
		JButton plane = new JButton("Planes");
		JButton flight = new JButton("Flights");
		JButton route = new JButton("Routes");
		JButton airport = new JButton("Airports");
		JButton flightAtt = new JButton("Flight Attendants");
		JButton captain = new JButton("Captain");







		customer.setBounds(1000, 0, 200, 50);
		mainWindow.add(customer);
		plane.setBounds(1000,50,200,50);
		mainWindow.add(plane);
		flight.setBounds(1000,100, 200, 50);
		mainWindow.add(flight);
		route.setBounds(1000,150, 200, 50);
		mainWindow.add(route);
		airport.setBounds(1000,200, 200, 50);
		mainWindow.add(airport);
		flightAtt.setBounds(1000,250, 200, 50);
		mainWindow.add(flightAtt);
		captain.setBounds(1000,300, 200, 50);
		mainWindow.add(captain);


		JTextField test = new JTextField();
		test.setBounds(5,15,150,20);
		JLabel emptyLabel = new JLabel();

		//defaults to closing program when window is closed
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//adding components to mainWindow
		mainWindow.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		mainWindow.getContentPane().add(test, BorderLayout.SOUTH);
		
		//window size and design
		mainWindow.setVisible(true);


		//creates secondary window for specific table viewing
		JFrame secondWindow = new JFrame("TableViewer");
		secondWindow.setPreferredSize(new Dimension(1200, 600));
		secondWindow.pack();

		//attempt to add scroll panel to text box for table output

		JPanel textPanel = new JPanel();

		//creates buttons for secondary window
		JButton back = new JButton("Back");
		JButton add = new JButton("Insert Data");
		JButton select = new JButton ("Select Data");
		JButton update = new JButton ("Update Data");
		JButton remove = new JButton ("Remove Data");
		//add buttons to second window and sets their position and size

		secondWindow.add(back);
		back.setBounds(1000,0,200,50);
		secondWindow.add(add);
		add.setBounds(1000,50,200,50);
		secondWindow.add(select);
		select.setBounds(1000,100, 200, 50);
		secondWindow.add(update);
		update.setBounds(1000,150, 200, 50);
		secondWindow.add(remove);
		remove.setBounds(1000,200, 200, 50);
		//adding components to secondWindow
		secondWindow.getContentPane().add(emptyLabel, BorderLayout.CENTER);



		//Checks mainWindow button presses, assigns currentTable string to whatever table is currently open

		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//removes the main window from the screen
				mainWindow.setVisible(false);

				//names the new window that pops up with customer table data
				secondWindow.setTitle("Customer Table");

				//a public value that is set depending on what table is being accesses
				currentTable = "CUSTOMER";

				//calls the getColumns method which uses JDBC to return a tables number of columns
				int columns = getColumns();

				//calls the getRows method which uses JDBC to return a tables number of rows
				int rows = getRows();

				//hard coded array for creation of the JTable.  Eventually make into a method that pulls out the name of every column name so I can put data grabbing from database
				//into a method of its own
				String columnNames[] = {"CUST_ID", "CUST_FNAME", "CUST_LNAME", "CUST_ADDRESS", "CUST_CITY", "CUST_STATE", "CUST_ZIP", "CUST_PHONENUM", "CUST_SEATNUM", "CUST_AGE", "FLIGHT_NUM"};

				//creation of 2d array that takes in the values from the Customer Table from the database
				Object data[][] = new String[rows][columns];

				//try catch that uses the JDBC
				try (
						Connection conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
								"root", "root");   // For MySQL only
						Statement stmt = conn.createStatement();
						) {
					//creates a query in the database to grab all values from the Customer Table
					String strSelect = "select * from " + currentTable;
					ResultSet rset = stmt.executeQuery(strSelect);
					
					//variables used to add data to the 2D array
					int column = 0;
					int row = 0;

					//data is printed out row by row, loops through the data grabbed from database and adds it to the 2D array
					//this loop skips to the next row each time it iterates
					while(rset.next()) { 
						//loop for adding the data to each column, loops 11 times for each row
						while(column != columns) {
							data[row][column] = rset.getString(column+1);
							column++;
						}
						//resets column data for the next row, increase row with the while loop
						column = 0;
						row++;
					} 

				} catch(SQLException ex) {
					ex.printStackTrace();
				}

				//creates the JTable the data in inputed to
				JTable dataTable = new JTable(data, columnNames);
				
				//adds a header to remain visible wherever the user is scrolled to in the table
				JTableHeader header = dataTable.getTableHeader();
				
				//sets the header background to green
				header.setBackground(Color.green);
				
				//creates a scroll bar to be added to the table
				JScrollPane scrollPane = new JScrollPane(dataTable);
				
				//sets the table dimensions in the window, resizing is off so buttons aren't covered
				dataTable.setPreferredScrollableViewportSize(new Dimension(825,520));
				dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
				//adds scroll bar to table so user can see all data
				textPanel.add(scrollPane);
				
				//sets how many rows and columns are visible, along with coordinates of the table (top left for our case)
				dataTable.setBounds(0,0,10,20);
				scrollPane.setViewportView(dataTable);
				
				//adds the table to the window
				secondWindow.add(textPanel, BorderLayout.WEST);
				//opens the new window with the table
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
				//closes table window
				secondWindow.setVisible(false);
				
				//removes table from textPanel
				textPanel.removeAll();
				
				//updates the window
				secondWindow.revalidate();
				secondWindow.repaint();
				
				//sets current table to nothing
				currentTable = "";
				
				//opens the mainwindow once again
				mainWindow.setVisible(true);
			}
		});

	}

	public static int getRows() {
		int rows = 0;
		try (
				// Step 1: Construct a database 'Connection' object called 'conn'
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
						"root", "root");   // For MySQL only



				Statement stmt = conn.createStatement();
				) {

			String strSelect = "select count(*) from " + currentTable;

			ResultSet rset = stmt.executeQuery(strSelect);

			while(rset.next()) { 
				rows = rset.getInt(1);

			} 
			return rows;

		} catch(SQLException ex) {
			ex.printStackTrace();
			return 0;
		}

	}

	public static int getColumns() {
		int columns = 0;
		try (

				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
						"root", "root");   // For MySQL only

				Statement stmt = conn.createStatement();
				) {


			String strSelect = "select * from " + currentTable;

			ResultSet rset2 = stmt.executeQuery(strSelect);
			ResultSetMetaData rsmd = rset2.getMetaData();
			columns = rsmd.getColumnCount();
			return columns;

		} catch(SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

}




