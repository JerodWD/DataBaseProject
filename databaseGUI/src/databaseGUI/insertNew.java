package databaseGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class insertNew {

	public static void insertNewData(){
		Runner objRunner = new Runner();
		String strInsert;
		try (
				//establish connection to database
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/flight manager?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
						"root", "root");   // For MySQL only
				//create statement object
				Statement stmt = conn.createStatement();
				){
			
			// set up the labels to prompt the user
			JFrame addData = new JFrame("Insert New " + objRunner.currentTable);
			addData.getContentPane().setLayout(null);
			addData.setSize(1400, 800);	// set size of frame
			addData.setLocation(100,200);
			addData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			if(objRunner.currentTable == "CUSTOMER") 
			{
				JLabel L_CUST_ID = new JLabel("ID: ");
				JLabel L_CUST_FNAME = new JLabel("First Name: ");
				JLabel L_CUST_LNAME = new JLabel("Last Name: ");
				JLabel L_CUST_ADDRESS = new JLabel("Address: ");
				JLabel L_CUST_CITY = new JLabel("City: ");
				JLabel L_CUST_STATE = new JLabel("State: ");
				JLabel L_CUST_ZIP = new JLabel("Zip Code: ");
				JLabel L_CUST_PHONENUM = new JLabel("Phone Number: ");
				JLabel L_CUST_SEATNUM = new JLabel("Seat Number: ");
				JLabel L_CUST_AGE = new JLabel("Age: ");
				JLabel L_FLIGHT_NUM = new JLabel("Flight Number: ");
				
				// setBounds(x, y, pixels, size)
				// set the bounds of the labels
				L_CUST_ID.setBounds(10, 0, 150, 50);
				L_CUST_FNAME.setBounds(10, 100, 150, 50);
				L_CUST_LNAME.setBounds(10, 200, 150, 50);
				L_CUST_ADDRESS.setBounds(10, 300, 150, 50);
				L_CUST_CITY.setBounds(10, 400, 150, 50);
				
				L_CUST_STATE.setBounds(500, 0, 150, 50);
				L_CUST_ZIP.setBounds(500, 100, 100, 50);
				L_CUST_PHONENUM.setBounds(500, 200, 150, 50);
				L_CUST_SEATNUM.setBounds(500, 300, 150, 50);
				L_CUST_AGE.setBounds(500, 400, 150, 50);
				L_FLIGHT_NUM.setBounds(500, 500, 150, 50);
				
				// create text boxes
				JTextField TXT_ID = new JTextField();
				JTextField TXT_FNAME = new JTextField();
				JTextField TXT_LNAME = new JTextField();
				JTextField TXT_ADDRESS = new JTextField();
				JTextField TXT_CITY = new JTextField();
				JTextField TXT_STATE = new JTextField();
				JTextField TXT_ZIP = new JTextField();
				JTextField TXT_PHONENUM = new JTextField();
				JTextField TXT_SEATNUM = new JTextField();
				JTextField TXT_AGE = new JTextField();
				JTextField TXT_FLIGHTNUM = new JTextField();
				
				// set the bounds of the text boxes (right under the label by +100 to y)
				TXT_ID.setBounds(10, 50, 150, 50);
				TXT_FNAME.setBounds(10, 150, 150, 50);
				TXT_LNAME.setBounds(10, 250, 150, 50);
				TXT_ADDRESS.setBounds(10, 350, 150, 50);
				TXT_CITY.setBounds(10, 450, 150, 50);
				
				TXT_STATE.setBounds(500, 50, 150, 50);
				TXT_ZIP.setBounds(500, 150, 150, 50);
				TXT_PHONENUM.setBounds(500, 250, 150, 50);
				TXT_SEATNUM.setBounds(500, 350, 150, 50);
				TXT_AGE.setBounds(500, 450, 150, 50);
				TXT_FLIGHTNUM.setBounds(500, 550, 150, 50);
				
				// add labels to the frame
				addData.add(L_CUST_ID);
				addData.add(L_CUST_FNAME);
				addData.add(L_CUST_LNAME);
				addData.add(L_CUST_ADDRESS);
				addData.add(L_CUST_CITY);
				addData.add(L_CUST_STATE);
				addData.add(L_CUST_ZIP);
				addData.add(L_CUST_PHONENUM);
				addData.add(L_CUST_SEATNUM);
				addData.add(L_CUST_AGE);
				addData.add(L_FLIGHT_NUM);
				
				// add text boxes to the frame
				addData.add(TXT_ID);
				addData.add(TXT_FNAME);
				addData.add(TXT_LNAME);
				addData.add(TXT_ADDRESS);
				addData.add(TXT_CITY);
				addData.add(TXT_STATE);
				addData.add(TXT_ZIP);
				addData.add(TXT_PHONENUM); 
				addData.add(TXT_SEATNUM);
				addData.add(TXT_AGE);
				addData.add(TXT_FLIGHTNUM);
				
				// button to submit the data 
				JButton submit = new JButton("Submit Data");
				submit.setBounds(1200,150, 100, 50);
				addData.add(submit);
				submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Runner wndObj = new Runner();
					//create statement object
					// assign values for inserting into the database
					String CUST_ID = TXT_ID.getText();
					String CUST_FNAME = TXT_FNAME.getText();
					String CUST_LNAME = TXT_LNAME.getText();
					String CUST_ADDRESS = TXT_ADDRESS.getText();
					String CUST_CITY = TXT_CITY.getText();
					String CUST_STATE = TXT_STATE.getText();
					String CUST_ZIP = TXT_ZIP.getText();
					String CUST_PHONENUM = TXT_PHONENUM.getText();
					String CUST_SEATNUM = TXT_SEATNUM.getText();
					String CUST_AGE = TXT_AGE.getText();
					String FLIGHT_NUM = TXT_FLIGHTNUM.getText();
					String strInsert = "INSERT INTO customer VALUES (" + CUST_ID + ", " + CUST_FNAME + ", " + CUST_LNAME + ", " + CUST_ADDRESS + ", " + CUST_CITY + ", " + CUST_STATE + ", " + CUST_ZIP + ", " + CUST_PHONENUM + ", " + CUST_SEATNUM + ", " + CUST_AGE + ", " + FLIGHT_NUM + ");";
					//execute query
					ResultSet rset = stmt.executeQuery(strInsert);
				

					}
				});
				
				// Display the screen
				addData.setVisible(true);
			}
			
			else if (objRunner.currentTable == "Plane")
			{
				JLabel L_PLANE_ID = new JLabel("Plane ID: ");
				JLabel L_CAP_ID = new JLabel("Captain ID: ");
				JLabel L_BUS_CLS_CAP = new JLabel("Business Cap: ");
				JLabel L_ECO_CLAS_CAP = new JLabel("Economy Cap: ");
				JLabel L_FIRST_CLASS_CAP = new JLabel("First Class Cap: ");
				JLabel L_PLANE_MODEL = new JLabel("Plane Model: ");
				JLabel L_FLIGHT_NUM = new JLabel("Flight Number: ");
				JLabel L_ATT_ID = new JLabel("Attendent ID: ");
				
				// setBounds(x, y, pixels, size)
				// set the bounds of the labels
				L_PLANE_ID.setBounds(10, 0, 150, 50);
				L_CAP_ID.setBounds(10, 100, 150, 50);
				L_BUS_CLS_CAP.setBounds(10, 200, 150, 50);
				L_ECO_CLAS_CAP.setBounds(10, 300, 150, 50);
				L_FIRST_CLASS_CAP.setBounds(10, 400, 150, 50);
				
				L_PLANE_MODEL.setBounds(500, 0, 150, 50);
				L_FLIGHT_NUM.setBounds(500, 100, 100, 50);
				L_ATT_ID.setBounds(500, 200, 150, 50);
				
				// create text boxes
				JTextField TXT_PLANE_ID = new JTextField();
				JTextField TXT_CAP_ID = new JTextField();
				JTextField TXT_BUS_CLS_CAP = new JTextField();
				JTextField TXT_ECO_CLAS_CAP = new JTextField();
				JTextField TXT_FIRST_CLASS_CAP = new JTextField();
				JTextField TXT_PLANE_MODEL = new JTextField();
				JTextField TXT_FLIGHT_NUM = new JTextField();
				JTextField TXT_ATT_ID = new JTextField();
				
				// set the bounds of the text boxes (right under the label by +100 to y)
				TXT_PLANE_ID.setBounds(10, 50, 150, 50);
				TXT_CAP_ID.setBounds(10, 150, 150, 50);
				TXT_BUS_CLS_CAP.setBounds(10, 250, 150, 50);
				TXT_ECO_CLAS_CAP.setBounds(10, 350, 150, 50);
				TXT_FIRST_CLASS_CAP.setBounds(10, 450, 150, 50);
				
				TXT_PLANE_MODEL.setBounds(500, 50, 150, 50);
				TXT_FLIGHT_NUM.setBounds(500, 150, 150, 50);
				TXT_ATT_ID.setBounds(500, 250, 150, 50);

				// add labels to the frame
				addData.add(L_PLANE_ID);
				addData.add(L_CAP_ID);
				addData.add(L_BUS_CLS_CAP);
				addData.add(L_ECO_CLAS_CAP);
				addData.add(L_FIRST_CLASS_CAP);
				addData.add(L_PLANE_MODEL);
				addData.add(L_FLIGHT_NUM);
				addData.add(L_ATT_ID);
				
				// add text boxes to the frame
				addData.add(TXT_PLANE_ID); 
				addData.add(TXT_CAP_ID);
				addData.add(TXT_BUS_CLS_CAP);
				addData.add(TXT_ECO_CLAS_CAP);
				addData.add(TXT_FIRST_CLASS_CAP);
				addData.add(TXT_PLANE_MODEL);
				addData.add(TXT_FLIGHT_NUM);
				addData.add(TXT_ATT_ID);

				// Display the screen
				addData.setVisible(true);

				// button to submit the data 
				JButton submit = new JButton("Submit Data");
				submit.setBounds(1200,150, 100, 50);
				addData.add(submit);
				submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//create statement object
					// assign values for inserting into the database
					String PLANE_ID = TXT_PLANE_ID.getText();
					String CAP_ID = TXT_CAP_ID.getText();
					String BUS_CLS_CAP = TXT_BUS_CLS_CAP.getText();
					String ECO_CLAS_CAP = TXT_ECO_CLAS_CAP.getText();
					String FIRST_CLASS_CAP = TXT_FIRST_CLASS_CAP.getText();
					String PLANE_MODEL = TXT_PLANE_MODEL.getText();
					String FLIGHT_NUM = TXT_FLIGHT_NUM.getText();
					String ATT_ID = TXT_ATT_ID.getText();
					String strInsert = "INSERT INTO plane VALUES (" + PLANE_ID + ", " + CAP_ID + ", " + BUS_CLS_CAP + ", " + ECO_CLAS_CAP + ", " + FIRST_CLASS_CAP + ", " + PLANE_MODEL + ", " + FLIGHT_NUM + ", " + ATT_ID + ");";
					//execute query
					ResultSet rset = stmt.executeQuery(strInsert);
					}
				});

			}
			
			else if(objRunner.currentTable == "Flight")
			{
				JLabel L_FLIGHT_NUM = new JLabel("Flight Number: ");
				JLabel L_FIGHT_DATE = new JLabel("Flight Date: ");
				JLabel L_ROUTE_ID = new JLabel("Route ID: ");
				
				// setBounds(x, y, pixels, size)
				// set the bounds of the labels
				L_FLIGHT_NUM.setBounds(10, 0, 150, 50);
				L_FIGHT_DATE.setBounds(10, 100, 150, 50);
				L_ROUTE_ID.setBounds(10, 200, 150, 50);
				
				// Create the text boxes
				JTextField TXT_FLIGHT_NUM = new JTextField();
				JTextField TXT_FIGHT_DATE = new JTextField();
				JTextField TXT_ROUTE_ID = new JTextField();
				
				// set the bounds of the text boxes (right under the label by +100 to y)
				TXT_FLIGHT_NUM.setBounds(10, 50, 150, 50);
				TXT_FIGHT_DATE.setBounds(10, 150, 150, 50);
				TXT_ROUTE_ID.setBounds(10, 250, 150, 50);
				
				// add labels to the frame
				addData.add(L_FLIGHT_NUM);
				addData.add(L_FIGHT_DATE);
				addData.add(L_ROUTE_ID);
				
				// add text boxes to the frame
				addData.add(TXT_FLIGHT_NUM);
				addData.add(TXT_FIGHT_DATE);
				addData.add(TXT_ROUTE_ID);
				
				// button to submit the data 
				JButton submit = new JButton("Submit Data");
				submit.setBounds(1200,150, 100, 50);
				addData.add(submit);
				submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//create statement object
					// assign values for inserting into the database
					String FLIGHT_NUM = TXT_FLIGHT_NUM.getText();
					String FLIGHT_DATE = TXT_FIGHT_DATE.getText();
					String ROUTE_ID = TXT_ROUTE_ID.getText();
					String strInsert = "INSERT INTO flight VALUES (" + FLIGHT_NUM + ", " + FLIGHT_DATE + ", " + ROUTE_ID + ");";
					//execute query
					ResultSet rset = stmt.executeQuery(strInsert);
					}
				});
				
				// Display the screen
				addData.setVisible(true);
				
			}
			
			else if(objRunner.currentTable == "Route")
			{
				JLabel L_ROUTE_ID = new JLabel("Route ID: ");
				JLabel L_DEP_LOC = new JLabel("Departure Time: ");
				JLabel L_ARR_LOC = new JLabel("Arrival Time: ");
				JLabel L_PORT_ID = new JLabel("Port ID: ");
				
				// setBounds(x, y, pixels, size)
				// set the bounds of the labels
				L_ROUTE_ID.setBounds(10, 0, 150, 50);
				L_DEP_LOC.setBounds(10, 100, 150, 50);
				L_ARR_LOC.setBounds(10, 200, 150, 50);
				L_PORT_ID.setBounds(10, 300, 150, 50);
				
				// Create the text boxes
				JTextField TXT_ROUTE_ID = new JTextField();
				JTextField TXT_DEP_LOC = new JTextField();
				JTextField TXT_ARR_LOC = new JTextField();
				JTextField TXT_PORT_ID = new JTextField();
				
				// set the bounds of the text boxes (right under the label by +100 to y)
				TXT_ROUTE_ID.setBounds(10, 50, 150, 50);
				TXT_DEP_LOC.setBounds(10, 150, 150, 50);
				TXT_ARR_LOC.setBounds(10, 250, 150, 50);
				TXT_PORT_ID.setBounds(10, 350, 150, 50);
				
				// add labels to the frame
				addData.add(L_ROUTE_ID);
				addData.add(L_DEP_LOC);
				addData.add(L_ARR_LOC);
				addData.add(L_PORT_ID);
				
				// add text boxes to the frame
				addData.add(TXT_ROUTE_ID);
				addData.add(TXT_DEP_LOC);
				addData.add(TXT_ARR_LOC);
				addData.add(TXT_PORT_ID);
				
				// button to submit the data 
				JButton submit = new JButton("Submit Data");
				submit.setBounds(1200,150, 100, 50);
				addData.add(submit);
				submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//create statement object
					// assign values for inserting into the database
					String ROUTE_ID = TXT_ROUTE_ID.getText();
					String DEP_LOC = TXT_DEP_LOC.getText();
					String ARR_LOC = TXT_ARR_LOC.getText();
					String PORT_ID = TXT_PORT_ID.getText();
					String strInsert = "INSERT INTO route VALUES (" + ROUTE_ID + ", " + DEP_LOC + ", " + ARR_LOC + ", " + PORT_ID + ");";
					//execute query
					ResultSet rset = stmt.executeQuery(strInsert);
					}
				});
				
				// Display the screen
				addData.setVisible(true);
			}
			
			else if(objRunner.currentTable == "Airport")
			{
				JLabel L_PORT_ID = new JLabel("Port ID: ");
				JLabel L_PORT_NAME = new JLabel("Port Name: ");
				JLabel L_PORT_CITY = new JLabel("Port City: ");
				JLabel L_PORT_COUNTRY = new JLabel("Port Country: ");
				JLabel L_PORT_LAT = new JLabel("Port Longitude: ");
				JLabel L_PORT_LONG = new JLabel("Port Latitude: ");
				JLabel L_PORT_TIMEZONE = new JLabel("Port Timezone: ");
				
				// setBounds(x, y, pixels, size)
				// set the bounds of the labels
				L_PORT_ID.setBounds(10, 0, 150, 50);
				L_PORT_NAME.setBounds(10, 100, 150, 50);
				L_PORT_CITY.setBounds(10, 200, 150, 50);
				L_PORT_COUNTRY.setBounds(10, 300, 150, 50);
				L_PORT_LAT.setBounds(10, 400, 150, 50);
				
				L_PORT_LONG.setBounds(500, 0, 150, 50);
				L_PORT_TIMEZONE.setBounds(500, 100, 100, 50);
				
				// create text boxes
				JTextField TXT_PORT_ID = new JTextField();
				JTextField TXT_PORT_NAME = new JTextField();
				JTextField TXT_PORT_CITY = new JTextField();
				JTextField TXT_PORT_COUNTRY = new JTextField();
				JTextField TXT_PORT_LAT = new JTextField();
				JTextField TXT_PORT_LONG = new JTextField();
				JTextField TXT_PORT_TIMEZONE = new JTextField();
				
				// set the bounds of the text boxes (right under the label by +100 to y)
				TXT_PORT_ID.setBounds(10, 50, 150, 50);
				TXT_PORT_NAME.setBounds(10, 150, 150, 50);
				TXT_PORT_CITY.setBounds(10, 250, 150, 50);
				TXT_PORT_COUNTRY.setBounds(10, 350, 150, 50);
				TXT_PORT_LAT.setBounds(10, 450, 150, 50);
				
				TXT_PORT_LONG.setBounds(500, 50, 150, 50);
				TXT_PORT_TIMEZONE.setBounds(500, 150, 150, 50);
				
				// add labels to the frame
				addData.add(L_PORT_ID);
				addData.add(L_PORT_NAME);
				addData.add(L_PORT_CITY);
				addData.add(L_PORT_COUNTRY);
				addData.add(L_PORT_LAT);
				addData.add(L_PORT_LONG);
				addData.add(L_PORT_TIMEZONE);
				
				// add text boxes to the frame
				addData.add(TXT_PORT_ID);
				addData.add(TXT_PORT_NAME);
				addData.add(TXT_PORT_CITY);
				addData.add(TXT_PORT_COUNTRY);
				addData.add(TXT_PORT_LAT);
				addData.add(TXT_PORT_LONG);
				addData.add(TXT_PORT_TIMEZONE);
				
				// button to submit the data 
				JButton submit = new JButton("Submit Data");
				submit.setBounds(1200,150, 100, 50);
				addData.add(submit);
				submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//create statement object
					// assign values for inserting into the database
					String PORT_ID = TXT_PORT_ID.getText();
					String PORT_NAME = TXT_PORT_NAME.getText();
					String PORT_CITY = TXT_PORT_CITY.getText();
					String PORT_COUNTRY = TXT_PORT_COUNTRY.getText();
					String PORT_LAT = TXT_PORT_LAT.getText();
					String PORT_LONG = TXT_PORT_LONG.getText();
					String PORT_TIMEZONE = TXT_PORT_TIMEZONE.getText();
					String strInsert = "INSERT INTO customer VALUES (" + PORT_ID + ", " + PORT_NAME + ", " + PORT_CITY + ", " + PORT_COUNTRY + ", " + PORT_LAT + ", " + PORT_LONG + ", " + PORT_TIMEZONE + ");";
					//execute query
					ResultSet rset = stmt.executeQuery(strInsert);
					}
				});
				
				// Display the screen
				addData.setVisible(true);
				
			}
			
			else if(objRunner.currentTable == "Flight_attendant")
			{
				JLabel L_ATT_ID = new JLabel("Attendant ID: ");
				JLabel L_ATT_FNAME = new JLabel("Attendant First Name: ");
				JLabel L_ATT_LNAME = new JLabel("Attendant Last Name: ");
				JLabel L_ATT_ADDRESS = new JLabel("Attendant Address: ");
				JLabel L_ATT_STATE = new JLabel("Attendant State: ");
				JLabel L_ATT_CITY = new JLabel("Attendant City: ");
				JLabel L_ATT_ZIP = new JLabel("Attendant Zip Code: ");
				JLabel L_ATT_PHPNENUM = new JLabel("Attendant Phone Number: ");
				JLabel L_ATT_AGE = new JLabel("Attendant Age: ");
				
				// setBounds(x, y, pixels, size)
				// set the bounds of the labels
				L_ATT_ID.setBounds(10, 0, 150, 50);
				L_ATT_FNAME.setBounds(10, 100, 150, 50);
				L_ATT_LNAME.setBounds(10, 200, 150, 50);
				L_ATT_ADDRESS.setBounds(10, 300, 150, 50);
				L_ATT_STATE.setBounds(10, 400, 150, 50);
				
				L_ATT_CITY.setBounds(500, 0, 150, 50);
				L_ATT_ZIP.setBounds(500, 100, 100, 50);
				L_ATT_PHPNENUM.setBounds(500, 200, 150, 50);
				L_ATT_AGE.setBounds(500, 300, 150, 50);
				
				// create text boxes
				JTextField TXT_ATT_ID = new JTextField();
				JTextField TXT_ATT_FNAME = new JTextField();
				JTextField TXT_ATT_LNAME = new JTextField();
				JTextField TXT_ATT_ADDRESS = new JTextField();
				JTextField TXT_ATT_STATE = new JTextField();
				JTextField TXT_ATT_CITY = new JTextField();
				JTextField TXT_ATT_ZIP = new JTextField();
				JTextField TXT_ATT_PHPNENUM = new JTextField();
				JTextField TXT_ATT_AGE = new JTextField();
				
				// set the bounds of the text boxes (right under the label by +100 to y)
				TXT_ATT_ID.setBounds(10, 50, 150, 50);
				TXT_ATT_FNAME.setBounds(10, 150, 150, 50);
				TXT_ATT_LNAME.setBounds(10, 250, 150, 50);
				TXT_ATT_ADDRESS.setBounds(10, 350, 150, 50);
				TXT_ATT_STATE.setBounds(10, 450, 150, 50);
				
				TXT_ATT_CITY.setBounds(500, 50, 150, 50);
				TXT_ATT_ZIP.setBounds(500, 150, 150, 50);
				TXT_ATT_PHPNENUM.setBounds(500, 250, 150, 50);
				TXT_ATT_AGE.setBounds(500, 350, 150, 50);
				
				// button to submit the data 
				JButton submit = new JButton("Submit Data");
				submit.setBounds(1200,150, 100, 50);
				addData.add(submit);
				submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//create statement object
					// assign values for inserting into the database
					String ATT_ID = TXT_ATT_ID.getText();
					String ATT_FNAME = TXT_ATT_FNAME.getText();
					String ATT_LNAME = TXT_ATT_LNAME.getText();
					String ATT_ADDRESS = TXT_ATT_ADDRESS.getText();
					String ATT_STATE = TXT_ATT_STATE.getText();
					String ATT_CITY = TXT_ATT_CITY.getText();
					String ATT_ZIP = TXT_ATT_ZIP.getText();
					String ATT_PHPNENUM = TXT_ATT_PHPNENUM.getText();
					String ATT_AGE = TXT_ATT_AGE.getText();
					String strInsert = "INSERT INTO flight_attendant VALUES (" + ATT_ID + ", " + ATT_FNAME + ", " + ATT_LNAME + ", " + ATT_ADDRESS + ", " + ATT_STATE + ", " + ATT_CITY + ", " + ATT_ZIP + ", " + ATT_PHPNENUM + ", " + ATT_AGE + ");";
					//execute query
					ResultSet rset = stmt.executeQuery(strInsert);
					}
				});
				
				// Display the screen
				addData.setVisible(true);
				
			}

			else if(objRunner.currentTable == "Captain")
			{
				JLabel L_CAP_ID = new JLabel("Captain ID: ");
				JLabel L_CAP_FNAME = new JLabel("Captain First Name: ");
				JLabel L_CAP_LNAME = new JLabel("Captain Last Name: ");
				JLabel L_CAP_ADDRESS = new JLabel("Captain Address: ");
				JLabel L_CAP_STATE = new JLabel("Captain State: ");
				JLabel L_CAP_CITY = new JLabel("Captain City: ");
				JLabel L_CAP_ZIP = new JLabel("Captain Zip Code: ");
				JLabel L_CAP_PHPNENUM = new JLabel("Captain Phone Number: ");
				JLabel L_CAP_AGE = new JLabel("Captain Age: ");
				
				// setBounds(x, y, pixels, size)
				// set the bounds of the labels
				L_CAP_ID.setBounds(10, 0, 150, 50);
				L_CAP_FNAME.setBounds(10, 100, 150, 50);
				L_CAP_LNAME.setBounds(10, 200, 150, 50);
				L_CAP_ADDRESS.setBounds(10, 300, 150, 50);
				L_CAP_STATE.setBounds(10, 400, 150, 50);
				
				L_CAP_CITY.setBounds(500, 0, 150, 50);
				L_CAP_ZIP.setBounds(500, 100, 100, 50);
				L_CAP_PHPNENUM.setBounds(500, 200, 150, 50);
				L_CAP_AGE.setBounds(500, 300, 150, 50);
				
				// create text boxes
				JTextField TXT_CAP_ID = new JTextField();
				JTextField TXT_CAP_FNAME = new JTextField();
				JTextField TXT_CAP_LNAME = new JTextField();
				JTextField TXT_CAP_ADDRESS = new JTextField();
				JTextField TXT_CAP_STATE = new JTextField();
				JTextField TXT_CAP_CITY = new JTextField();
				JTextField TXT_CAP_ZIP = new JTextField();
				JTextField TXT_CAP_PHPNENUM = new JTextField();
				JTextField TXT_CAP_AGE = new JTextField();
				
				// set the bounds of the text boxes (right under the label by +100 to y)
				TXT_CAP_ID.setBounds(10, 50, 150, 50);
				TXT_CAP_FNAME.setBounds(10, 150, 150, 50);
				TXT_CAP_LNAME.setBounds(10, 250, 150, 50);
				TXT_CAP_ADDRESS.setBounds(10, 350, 150, 50);
				TXT_CAP_STATE.setBounds(10, 450, 150, 50);
				
				TXT_CAP_CITY.setBounds(500, 50, 150, 50);
				TXT_CAP_ZIP.setBounds(500, 150, 150, 50);
				TXT_CAP_PHPNENUM.setBounds(500, 250, 150, 50);
				TXT_CAP_AGE.setBounds(500, 350, 150, 50);
				
				// button to submit the data 
				JButton submit = new JButton("Submit Data");
				submit.setBounds(1200,150, 100, 50);
				addData.add(submit);
				submit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//create statement object
					// assign values for inserting into the database
					String CAP_ID = TXT_CAP_ID.getText();
					String CAP_FNAME = TXT_CAP_FNAME.getText();
					String CAP_LNAME = TXT_CAP_LNAME.getText();
					String CAP_ADDRESS = TXT_CAP_ADDRESS.getText();
					String CAP_STATE = TXT_CAP_STATE.getText();
					String CAP_CITY = TXT_CAP_CITY.getText();
					String CAP_ZIP = TXT_CAP_ZIP.getText();
					String CAP_PHPNENUM = TXT_CAP_PHPNENUM.getText();
					String CAP_AGE = TXT_CAP_AGE.getText();
					String strInsert = "INSERT INTO flight_attendant VALUES (" + CAP_ID + ", " + CAP_FNAME + ", " + CAP_LNAME + ", " + CAP_ADDRESS + ", " + CAP_STATE + ", " + CAP_CITY + ", " + CAP_ZIP + ", " + CAP_PHPNENUM + ", " + CAP_AGE + ");";
					//execute query
					ResultSet rset = stmt.executeQuery(strInsert);
					}
				});
				
				//execute query
				//ResultSet rset = stmt.executeQuery(strInsert);
				
				// Display the screen
				addData.setVisible(true);
				
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			//if connection fails to establish, return null
			//bigger problems are at hand if connection cannot be established
			//return null;
		}
	}
	
}