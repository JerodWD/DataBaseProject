package databaseGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import java.sql.*;

public class Runner {
	public static String currentTable;
	public static JFrame secondWindow;
	public static JFrame thirdWindow;
	public static JPanel textPanel;

	public static void main(String[] args) {

		//creates main window for viewing
		JFrame mainWindow = new JFrame("DatabaseViewer");
		mainWindow.setPreferredSize(new Dimension(1200, 600));	// window size
		mainWindow.pack();
		
		//creates all buttons for main window
		JButton customer = new JButton("Customers");
		JButton plane = new JButton("Planes");
		JButton flight = new JButton("Flights");
		JButton route = new JButton("Routes");
		JButton airport = new JButton("Airports");
		JButton flightAtt = new JButton("Flight Attendants");
		JButton captain = new JButton("Captain");

		// Sets locations (bound) for all buttons 
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
		secondWindow = new JFrame("TableViewer");
		secondWindow.setPreferredSize(new Dimension(1200, 600));
		secondWindow.pack();

		//attempt to add scroll panel to text box for table output

		textPanel = new JPanel();

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

		
		

		//Checks mainWindow button presses, assigns currentTable string to 
		//whatever table is currently open

		// event on buttom press for CUSTOMER
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//removes the main window from the screen
				mainWindow.setVisible(false);

				//names the new window that pops up with customer table data
				secondWindow.setTitle("Customer Table");

				//a public value that is set depending on what table is being accesses
				currentTable = "CUSTOMER";

				//a method that prints out the current table data based on the value 'currentTable'
				printData();

				//opens the new window with the table
				secondWindow.setVisible(true);

			}
		});

		// event on buttom press for PLANE
		plane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//remove the main window from screen
				mainWindow.setVisible(false);

				//names the new window Plane Table
				secondWindow.setTitle("Plane Table");

				//sets the public table value to plane
				currentTable = "Plane";

				//a method that prints out the current table data based on the value 'currentTable'
				printData();

				//sets the second window to true
				secondWindow.setVisible(true);
			}
		});

		// event on buttom press for FLIGHT
		flight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mainWindow.setVisible(false);

				currentTable = "Flight";

				printData();

				secondWindow.setVisible(true);
			}
		});

		// event on buttom press for ROUTE
		route.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mainWindow.setVisible(false);

				currentTable = "Route";

				printData();

				secondWindow.setVisible(true);
			}
		});

		// event on buttom press for AIRPORT
		airport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mainWindow.setVisible(false);

				currentTable = "Airport";

				printData();

				secondWindow.setVisible(true);
			}
		});

		// event on buttom press for FLIGHT ATTENDANT
		flightAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mainWindow.setVisible(false);

				currentTable = "Flight_attendant";

				printData();

				secondWindow.setVisible(true);
			}
		});

		// event on buttom press for CAPTAIN
		captain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mainWindow.setVisible(false);

				currentTable = "Captain";

				printData();

				secondWindow.setVisible(true);
			}
		});
		
		// event on button press for INSERT
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				insertNew newObj = new insertNew();
				secondWindow.setVisible(false);
				//insertData();
				newObj.insertNewData();
				//mainWindow.setVisible(true);
			}
		});
		
		// event on button press for 

		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("test");

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

				//opens the main window once again
				mainWindow.setVisible(true);
			}
		});
		
	
	}

	//gets all rows of 'currentTable'
	public static int getRows() {
		int rows = 0;
		try (
				// Step 1: Construct a database 'Connection' object called 'conn'
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
						"root", "rr185257");   // For MySQL only



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

	//gets all columns of 'currentTable'
	public static int getColumns() {
		int columns = 0;
		try (

				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
						"root", "rr185257");   // For MySQL only

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

	//method returns an array of all column names based on 'currentTable'
	public static String[] getColumnNames(int numberOfColumns) {
		//create array to add column names to
		//size is determined by getColumns method
		String[] columnNames = new String[numberOfColumns];
		try (
				//establish connection to database
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
						"root", "rr185257");   // For MySQL only
				//create statement object
				Statement stmt = conn.createStatement();
				) {
			//create the query that will be run to database
			String strSelect = "select * from " + currentTable;
			//execute query
			ResultSet rset = stmt.executeQuery(strSelect);
			//grab the metadata from the resultSet
			ResultSetMetaData metaData = rset.getMetaData();

			//loop through the empty array of Names to add a column name based off of metaData
			//number of loops is determined by number of columns
			for(int i = 0; i < numberOfColumns; i++) {
				//must use i+1 as database uses indexes starting at 1 not 0
				columnNames[i] = metaData.getColumnName(i+1);
			}
			//return array of names
			return columnNames;

		} catch(SQLException ex) {
			ex.printStackTrace();
			//if connection fails to establish, return null
			//bigger problems are at hand if connection cannot be established
			return null;
		}

	}

	
	//method prints out all data of a table based on the value 'currentTable'
	public static void printData() {

		//calls the getColumns method which uses JDBC to return a tables number of columns
		int columns = getColumns();

		//calls the getRows method which uses JDBC to return a tables number of rows
		int rows = getRows();

		//hard coded array for creation of the JTable.  Eventually make into a method that pulls out the name of every column name so I can put data grabbing from database
		//into a method of its own
		String columnNames[] = getColumnNames(columns);

		//creation of 2d array that takes in the values from the Customer Table from the database
		Object data[][] = new String[rows][columns];

		//try catch that uses the JDBC
		try (
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
						"root", "rr185257");   // For MySQL only
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
		JTable dataTable = new JTable(data, columnNames) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		dataTable.setFocusable(false);
		dataTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 2) {     // to detect double click events
					JTable target = (JTable)me.getSource();
					int row = target.getSelectedRow(); // select a row
					int column = target.getSelectedColumn(); // select a column

					//add a way to pop up a text box that asks user for new data to input into box
					//run a try catch to try to add data to database, return an "ERROR:  INCORRECT FORMAT" if it doesn't work
					
					String primaryColumn = columnNames[0];
					String currentColumn = columnNames[column];
					String currentPrimary = (String) dataTable.getValueAt(row, 0);
					String currentData = (String) dataTable.getValueAt(row, column);
					
					String updatedData = (String)JOptionPane.showInputDialog("Enter data to update to:  "); // get the value of a row and column.
					
					
					System.out.println(currentColumn);
					System.out.println(currentData);
					System.out.println(primaryColumn);
					
					
					if(currentData != null)
					try (
							Connection conn = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
									"root", "rr185257");   // For MySQL only
							Statement stmt = conn.createStatement();
							) {
						
						//String strSelect = "update customer set name = 'Test' where cust_id = 1001";
						String strSelect = "update " + currentTable + " set " + currentColumn + " = '" + updatedData + "' where " + primaryColumn + " = " + currentPrimary;
						stmt.executeUpdate(strSelect);

					
					} catch(SQLException ex) {
						ex.printStackTrace();
					}

				}
			}
		});
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


	}

}




