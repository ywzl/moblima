import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;

import javax.xml.crypto.NodeSetData;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

	public String UserName;
	
	public Boolean GetLoginData(String UserID, String Pass) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		boolean LoginStatus = false;
		File XmlFile = new File("res/Login.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
			Document document = dBuilder.parse(XmlFile);
			document.normalize();
			NodeList rootNode = document.getElementsByTagName("StaffLogin");
			LoginStatus = handleTopicTag(rootNode, "\t", UserID, Pass);
			
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return LoginStatus;
	}
	private Boolean handleTopicTag(NodeList rootList, String tab, String UserID, String Pass) {
		Node rootNode = rootList.item(0);
		Element rootElement = (Element) rootNode;
		NodeList notesList = rootElement.getElementsByTagName("Staff");

		/*for (int i = 0; i < notesList.getLength(); i++) {
			Node theNode = notesList.item(i);
			Element noteElement = (Element) theNode;
			
			System.out.println("UserID is " + noteElement.getAttribute("key"));
			System.out.println("Password is " + noteElement.getAttribute("password"));
			
			Node theName = noteElement.getElementsByTagName("StaffName").item(0);
			Element NameElement = (Element) theName;
			System.out.println("User name is " + NameElement.getTextContent());
		}
		*/
		UserName = "No Name";
		return true;
	}
}
