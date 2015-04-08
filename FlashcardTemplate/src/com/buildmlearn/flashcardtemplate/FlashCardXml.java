package com.buildmlearn.flashcardtemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Intent;
import android.os.Environment;
import android.util.Log;


public class FlashCardXml {

	public void readXml(InputStream xmlFile) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		 
		  MainActivity.mDataList=new ArrayList<FlashCardDataTemplate>();
		   DocumentBuilderFactory documentFactory = DocumentBuilderFactory  
		     .newInstance();  
		   DocumentBuilder documentBuilder = documentFactory  
		     .newDocumentBuilder();  
		   Document doc = documentBuilder.parse(xmlFile);  
		  
		   doc.getDocumentElement().normalize();  
		   
		   
		   
		   NodeList nList = doc.getElementsByTagName("metadata");
			 
			System.out.println("----------------------------");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
		 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
		 
					System.out.println("First Name : " + eElement.getElementsByTagName("type").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("app_name").item(0).getTextContent());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("author_name").item(0).getTextContent());
					String type =eElement.getElementsByTagName("type").item(0).getTextContent();
					Object xml;
					 MainActivity.mModel.setmAppName(eElement.getElementsByTagName("app_name").item(0).getTextContent());
					 MainActivity.mModel.setmAuthorName(eElement.getElementsByTagName("author_name").item(0).getTextContent());
						
					
				
				}
			}
		   
		   
		   
		   
		   
		   
		   NodeList nodeList = doc.getElementsByTagName("data");  
		  
		   System.out.println("Root element :"  
		     + doc.getDocumentElement().getNodeName());  
		  
		   for (int temp = 0; temp < nodeList.getLength(); temp++) {  
		    Node node = nodeList.item(temp);  
		  
		    System.out.println("\nElement type :" + node.getNodeName());  
		  
		    if (node.getNodeType() == Node.ELEMENT_NODE) {  
		  
		     Element student = (Element) node;  
		  
		     System.out.println("Data id : "  
		       + student.getAttribute("id"));  
		     System.out.println("Question : "  
		       + student.getElementsByTagName("question").item(0)  
		         .getTextContent());  
		     System.out.println("Answer : "  
		       + student.getElementsByTagName("answer").item(0)  
		         .getTextContent());  
		     System.out.println("Image Url : "  
		       + student.getElementsByTagName("image").item(0)  
		         .getTextContent());  
		     System.out.println("Hint : "  
		       + student.getElementsByTagName("hint").item(0)  
		         .getTextContent());  
		   
		  MainActivity.mDataList.add(new FlashCardDataTemplate(student.getElementsByTagName("question").item(0)  
			         .getTextContent(), student.getElementsByTagName("answer").item(0)  
			         .getTextContent(), student.getElementsByTagName("image").item(0)  
			         .getTextContent(), student.getElementsByTagName("hint").item(0)  
			         .getTextContent()));
		    }  
		   }  
	}

	


	

}
