import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StaffApplication {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		// Check Staff ID and Password
		String UserID = "";
		String Password = "";
		int MenuSelect = 0;
		String EditSelect = "o";
		Boolean LoginSuccess = false;
		
		XMLReader getFile = new XMLReader();
		XMLWrite writeFile = new XMLWrite();
		
		Scanner readInput =  new Scanner(System.in);
		while (LoginSuccess != true) {
			System.out.println("Hi Welcome to Only Staff access Database!\nPlease Enter Your Staff UserID: ");
			UserID = readInput.nextLine();
			System.out.println("Please Enter Your Staff Password: ");
			Password = readInput.nextLine();
			System.out.println("Loading Accessing Status....... ");
			LoginSuccess = getFile.GetLoginData(UserID, Password);
			if (LoginSuccess == false ){
				System.out.println("Sorry your User ID or Password is invaild, Please ask the administrator for futher helps.");
			}
			else {
				System.out.println("Welcome Back, "+ getFile.UserName);
			}
		}
		
		
		while (LoginSuccess == true && MenuSelect != 5) {
			System.out.println("Key 1 \t Configure System Setting\nKey 2 \t Enter New/Update/Remove Movie \nKey 3 \t Update Movie Showtime and Status\nKey 4 \t List Top 5 \nKey 5 \t Log out ");
			MenuSelect = readInput.nextInt();
			EditSelect = " ";
			// 1. Configure Setting
			if (MenuSelect == 1) {
				// Display Setting
				writeFile.printSetting();
				// Ask Reply
				while ((!EditSelect.equals("No")) && (!EditSelect.equals("Yes"))) {
					System.out.println("Do you want to edit the setting (Yes/No)?");
					EditSelect = (String)readInput.next();
				}
				if (EditSelect.equals("Yes")) {
					String Day = "";
					String Type = "";
					String Time = "";
					String Ticket = "";
					Double Price = 0.0;
					
					System.out.println("Which Day do you want to edit? (Weekday/Weekend/Holiday)");
					Day = (String)readInput.next();
					System.out.println("Which Type do you want to edit? (2D/3D/iMax/D-Box)");
					Type = (String)readInput.next();
					System.out.println("Which Time do you want to edit? (Day Time/MidNight)");
					Time = (String)readInput.next();
					System.out.println("Which ticket price do you want to edit? (Child/Student/Adult/SeniorCitizen)");
					Ticket = (String)readInput.next();
					System.out.println("Change the price to? " );
					Price = (double)readInput.nextDouble();
					
					writeFile.EditSystem(Day, Type, Time, Ticket, Price);
				}
			}
			// 2. Enter New Movie
			else if (MenuSelect == 2) {
				// Display Movie List
				writeFile.printMovie();
				// Ask Reply
				while ((!EditSelect.equals("No")) && (!EditSelect.equals("Yes"))) {
					System.out.println("You wish to (Add/Update/Remove) any Movie?");
					EditSelect = (String)readInput.next();
					if (EditSelect.equals("Add")) {
						System.out.println("You wish to Add a Movie, please follow the given steps");
						writeFile.AddMovie();
						EditSelect = "Yes";
					}
					else if (EditSelect.equals("Update")) {
						System.out.println("You wish to Update a Movie, please follow the given steps");
						System.out.println("Which Movie Title do you wish to Update?");
						readInput.nextLine();
						writeFile.UpdateMovie((String)readInput.nextLine());
						EditSelect = "Yes";
					}
					else if (EditSelect.equals("Remove")) {
						System.out.println("You wish to Remove a Movie, please follow the given steps");
						System.out.println("Which Movie Title do you wish to Remove?");
						readInput.nextLine();
						writeFile.RemoveMovie((String)readInput.nextLine());
						EditSelect = "Yes";
					}
				}
			}
			// 3. Update Movie Show time and Status
			else if (MenuSelect == 3) {
				// Display Movie List
				writeFile.printMovie();
				System.out.println("You wish to Update which Movie?");
				// Ask Reply
				while ((!EditSelect.equals("No")) && (!EditSelect.equals("Yes"))) {
					readInput.nextLine();
					writeFile.UpdateMovieStatusTime((String)readInput.nextLine());
					EditSelect = "Yes";
				}
			}
			// 4. List Top 5 Movie 
			else if (MenuSelect == 4) {
				// Display Movie List
				writeFile.printRanking();
			}
			// 5. Log out.
			else {
				System.out.println("Logged out");
			}
		}
	}
}
