import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;

import javax.xml.crypto.NodeSetData;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.NamedNodeMap;

public class XMLWrite {
	public static final String xmlSystemFilePath = "res/SystemDatabase.xml";
	public static final String xmlMovieFilePath = "res/MovieDatabase.xml";
	Document Systemdocument;
	Document Moviedocument;
	
	XMLWrite() throws SAXException, IOException, ParserConfigurationException {
		// Constructor
		try {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Systemdocument = documentBuilder.parse(xmlSystemFilePath);
		Moviedocument = documentBuilder.parse(xmlMovieFilePath);
		} catch (ParserConfigurationException pce) {
		pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
	    } catch (SAXException sae) {
	    	sae.printStackTrace();
	    }
	}
	
	public void EditSystem (String Day, String Type, String Time, String Ticket, Double Price) throws TransformerException, SAXException, IOException, ParserConfigurationException {

		NodeList nodeList = Systemdocument.getElementsByTagName("Price");
		
		if(nodeList != null && nodeList.getLength() > 0){
			 for (int j = 0; j < nodeList.getLength(); j++) {
				 // Get the staff element by tag name directly
				 Node DayPrice = Systemdocument.getElementsByTagName("Price").item(j);
				 // loop the staff child node
				 NodeList list = DayPrice.getChildNodes();
				 Node nNode = nodeList.item(j);
				 Element eElement = (Element) nNode;
				 if (eElement.getAttribute("day").equals(Day) && eElement.getAttribute("Time").equals(Time) && eElement.getAttribute("type").equals(Type)){
					 System.out.println("\nTicket for " + eElement.getAttribute("day") + " has changed to: \n");
					 for (int i = 0; i < list.getLength(); i++) {
						 Node node = list.item(i);
						 if (Ticket.equals(node.getNodeName())) {
							 node.setTextContent(String.valueOf(Price));
							 System.out.println("Ticket for " + eElement.getElementsByTagName(Ticket).item(0).getTextContent());
						 }
					 }
				 }
			 }
		}
		
		try {
			// write the DOM object to the file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(Systemdocument);
			StreamResult streamResult = new StreamResult(new File(xmlSystemFilePath));
			transformer.transform(domSource, streamResult);
			System.out.println("The XML File was Saved\n\n");
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	public void printSetting() {
		String day = " ";
		System.out.println("************Ticket Price*****************");
		NodeList nodeList = Systemdocument.getElementsByTagName("Price");
		
		if(nodeList != null && nodeList.getLength() > 0){
			 for (int j = 0; j < nodeList.getLength(); j++) {
				 Node nNode = nodeList.item(j);
				 Element eElement = (Element) nNode;
				 if (!(eElement.getAttribute("day").equals(day))){
					 day = eElement.getAttribute("day");
					 System.out.println("\n\nTicket for " + eElement.getAttribute("day") + "\n");
				 }
				 System.out.println( eElement.getAttribute("type") + " Movie Ticket price for " + eElement.getAttribute("day") + " on the " + eElement.getAttribute("Time"));
				 System.out.println("Children Price: \t " + eElement.getElementsByTagName("Child").item(0).getTextContent());
				 System.out.println("Student Price: \t\t " + eElement.getElementsByTagName("Student").item(0).getTextContent());
				 System.out.println("Adult Price: \t\t" + eElement.getElementsByTagName("Adult").item(0).getTextContent());
				 System.out.println("Senior Citizen Price: \t " + eElement.getElementsByTagName("SeniorCitizen").item(0).getTextContent() + " \n");
			 
			 }
		}
		System.out.println("************End of Ticket Price*****************\n\n\n");
	}
	
	public void AddMovie() throws TransformerException, SAXException, IOException, ParserConfigurationException {
		
		Scanner readInput =  new Scanner(System.in);

		Element dataTag = Moviedocument.getDocumentElement();
		Element newMovie = Moviedocument.createElement("Movie");
		
		readInput.nextLine();
		
		System.out.println("What will be the Movie Title?");
		Element Title = Moviedocument.createElement("Title");
		Title.setTextContent(readInput.nextLine());
		
		System.out.println("What will be the Rating (PG/N16/M18/R21)?");
		Element Rate = Moviedocument.createElement("Rate");
		Rate.setTextContent(readInput.nextLine());
		
		System.out.println("What will be the type of Movie (2D/3D/iMax/D-Box)?");
		Element Type = Moviedocument.createElement("Type");
		Type.setTextContent(readInput.nextLine());
		
		System.out.println("What will be the show time of this Movie in 12 hour formate?");
		Element ShowTime = Moviedocument.createElement("ShowTime");
		ShowTime.setTextContent((String)readInput.nextLine());
		
		System.out.println("What will be the Status of the Movie (Coming Soon, Preview, Now Showing, End Of Showing)?");
		Element Status = Moviedocument.createElement("Status");
		Status.setTextContent((String)readInput.nextLine());
		
		System.out.println("Which Cinema show this Movie (AMK/JEM/J8/Cine)?");
		Element Cinema = Moviedocument.createElement("Cinema");
		Cinema.setTextContent((String)readInput.nextLine());
		
		newMovie.appendChild(Title);
		newMovie.appendChild(Rate);
		newMovie.appendChild(Type);
		newMovie.appendChild(ShowTime);
		newMovie.appendChild(Status);
		newMovie.appendChild(Cinema);
		
		dataTag.appendChild(newMovie);
		
		try {
			// write the DOM object to the file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(Moviedocument);
			StreamResult streamResult = new StreamResult(new File(xmlMovieFilePath));
			transformer.transform(domSource, streamResult);
			System.out.println("The XML File was Saved\n\n");
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
	public void UpdateMovie(String Title) throws TransformerException, SAXException, IOException, ParserConfigurationException {
		Scanner readInput =  new Scanner(System.in);
		
		NodeList nodeList = Moviedocument.getElementsByTagName("Movie");
		System.out.println("You have selected " + Title + " for update.");
		System.out.println("What do want to make changes for this movie (Title/Type/Rate/Status)?");
		
		String Update = readInput.nextLine();
				
		if(nodeList != null && nodeList.getLength() > 0){
			 for (int j = 0; j < nodeList.getLength(); j++) {
				 // Get the staff element by tag name directly
				 Node MovieNode = Moviedocument.getElementsByTagName("Movie").item(j);
				 // loop the staff child node
				 NodeList Detailist = MovieNode.getChildNodes();
				 Node nNode = nodeList.item(j);
				 Element eElement = (Element) nNode;
				 if (eElement.getElementsByTagName("Title").item(0).getTextContent().equals(Title)){
					 for (int i = 0; i < Detailist.getLength(); i++) {
						 Node node = Detailist.item(i);
						 if (Update.equals(node.getNodeName())) {
							System.out.println("Current " + Update + " is " + eElement.getElementsByTagName(Update).item(0).getTextContent());
							System.out.println("Please enter the changes: ");
							node.setTextContent((String)readInput.nextLine());
							System.out.println("Changes have been saved.");
						 }
					 }
				 }
			 }
		}
		
		try {
			// write the DOM object to the file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(Moviedocument);
			StreamResult streamResult = new StreamResult(new File(xmlMovieFilePath));
			transformer.transform(domSource, streamResult);
			System.out.println("The XML File was Saved\n\n");
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}		
	}
	
	public void RemoveMovie(String Title) throws TransformerException, SAXException, IOException, ParserConfigurationException {
		
		NodeList nodeList = Moviedocument.getElementsByTagName("Movie");
		System.out.println("You have selected " + Title + " for Remove.");
		
		if(nodeList != null && nodeList.getLength() > 0){
			 for (int j = 0; j < nodeList.getLength(); j++) {
				 // Get the staff element by tag name directly
				 Node nNode = nodeList.item(j);
				 // retrieve the element
				 Element eElement = (Element) nNode;
				 Element element = (Element) Moviedocument.getElementsByTagName("Movie").item(j);
				 if (eElement.getElementsByTagName("Title").item(0).getTextContent().equals(Title)){
					 // remove the specific node
					 System.out.println(Title + " Movie have been removed.");
					 element.getParentNode().removeChild(element);
				 }
			 }
		}
		
		try {
			// write the DOM object to the file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(Moviedocument);
			StreamResult streamResult = new StreamResult(new File(xmlMovieFilePath));
			transformer.transform(domSource, streamResult);
			System.out.println("The XML File was Saved\n\n");
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}		
	}
	
	public void UpdateMovieStatusTime(String Title) throws TransformerException, SAXException, IOException, ParserConfigurationException {
		Scanner readInput =  new Scanner(System.in);
		
		NodeList nodeList = Moviedocument.getElementsByTagName("Movie");
		System.out.println("You have selected " + Title + " for update.");
		System.out.println("What do want to make changes for this movie (ShowTime/Status)?");
		
		String Update = readInput.nextLine();
				
		if(nodeList != null && nodeList.getLength() > 0){
			 for (int j = 0; j < nodeList.getLength(); j++) {
				 // Get the staff element by tag name directly
				 Node MovieNode = Moviedocument.getElementsByTagName("Movie").item(j);
				 // loop the staff child node
				 NodeList Detailist = MovieNode.getChildNodes();
				 Node nNode = nodeList.item(j);
				 Element eElement = (Element) nNode;
				 if (eElement.getElementsByTagName("Title").item(0).getTextContent().equals(Title)){
					 for (int i = 0; i < Detailist.getLength(); i++) {
						 Node node = Detailist.item(i);
						 if (Update.equals(node.getNodeName())) {
							// If Update for Status
							if ( Update.equals("Status")) { 
								System.out.println("Current " + Update + " is " + eElement.getElementsByTagName(Update).item(0).getTextContent());
								System.out.println("Please enter the changes: ");
								node.setTextContent((String)readInput.nextLine());
								System.out.println("Changes have been saved.");
							}
							else if (Update.equals("ShowTime")) {
								System.out.println("Current " + Update + " is " + eElement.getElementsByTagName(Update).item(0).getTextContent());
								System.out.println("Please enter the changes: ");
								node.setTextContent((String)readInput.nextLine());
								System.out.println("Changes have been saved.");
							}
						 }
					 }
				 }
			 }
		}
		
		try {
			// write the DOM object to the file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(Moviedocument);
			StreamResult streamResult = new StreamResult(new File(xmlMovieFilePath));
			transformer.transform(domSource, streamResult);
			System.out.println("The XML File was Saved\n\n");
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}		
	}
	
	public void printMovie() {
		
		System.out.println("************Movie List*****************\n");
		NodeList nodeList = Moviedocument.getElementsByTagName("Movie");
		
		if(nodeList != null && nodeList.getLength() > 0){
			 for (int j = 0; j < nodeList.getLength(); j++) {
				 Node nNode = nodeList.item(j);
				 Element eElement = (Element) nNode;
				 
				 System.out.println("Title: \t\t" + eElement.getElementsByTagName("Title").item(0).getTextContent());
				 System.out.println("Rate: \t\t" + eElement.getElementsByTagName("Rate").item(0).getTextContent());
				 System.out.println("Type: \t\t" + eElement.getElementsByTagName("Type").item(0).getTextContent());
				 System.out.println("Cinema: \t" + eElement.getElementsByTagName("Cinema").item(0).getTextContent());
				 System.out.println("ShowTime: \t" + eElement.getElementsByTagName("ShowTime").item(0).getTextContent());
				 System.out.println("Status: \t" + eElement.getElementsByTagName("Status").item(0).getTextContent() + " \n\n");
				 
			 }
		}
		System.out.println("************End of Movie List*****************\n\n\n");
	}
	
	public void printRanking() {
		
		System.out.println("************Ranking List*****************\n");
		NodeList nodeList = Moviedocument.getElementsByTagName("Ranking");

		 Node nNode = nodeList.item(0);
		 Element eElement = (Element) nNode;
		 
		 System.out.println("First: \t\t" + eElement.getElementsByTagName("First").item(0).getTextContent() + " of " + eElement.getAttribute("First") + " Ticket Sales");
		 System.out.println("Second: \t\t" + eElement.getElementsByTagName("Second").item(0).getTextContent() + " of " + eElement.getAttribute("Second") + " Ticket Sales");
		 System.out.println("Third: \t\t" + eElement.getElementsByTagName("Third").item(0).getTextContent() + " of " + eElement.getAttribute("Third") + " Ticket Sales");
		 System.out.println("Fourth: \t" + eElement.getElementsByTagName("Fourth").item(0).getTextContent() + " of " + eElement.getAttribute("Fourth") + " Ticket Sales");
		 System.out.println("Fifth: \t" + eElement.getElementsByTagName("Fifth").item(0).getTextContent() + " of " + eElement.getAttribute("Fifth") + " Ticket Sales");
		 System.out.println("In Top Ticket Sales Order \n\n");

		System.out.println("************End of Ranking List*****************\n\n\n");
	}
}
