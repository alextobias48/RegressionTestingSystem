package classes;
import java.io.File;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.text.DecimalFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestBean {

 public static void main(String argv[]) {
	 	  
	 String Name = "";
	 double RunTime = 0.0;
	 int Result = 1;
	 String TestDate = "unknown";
		 
	 try {
			File xml = new File("C:\\Users\\jamesduin\\sahi_prov511\\userdata\\logs\\playback\\TEST-invalidLogin_ie.xml");

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(xml);
			
			doc.getDocumentElement ().normalize ();
			System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());
			
			NodeList listOfTests = doc.getElementsByTagName("testcase");
			int totalTests = listOfTests.getLength();
			System.out.println("Total no of test cases is : " + totalTests);
			
			for(int s=0; s<totalTests ; s++){
				Node test = listOfTests.item(s);
				if(test.getNodeType() == Node.ELEMENT_NODE){
						Element testElement = (Element)test; 
						Name = testElement.getAttribute("name").replaceAll("\\.sah", "");
						System.out.println("name is: "+Name);						
						System.out.println("duration is: "+testElement.getAttribute("time"));
						RunTime = Double.parseDouble(testElement.getAttribute("time"));
						DecimalFormat df = new DecimalFormat("#.00");
						String tmpRunTime = df.format(RunTime);
						RunTime = Double.parseDouble(tmpRunTime);
						String str = testElement.getTextContent();
						System.out.println(str.contains("SUCCESS"));
						if(str.contains("SUCCESS")) {
							Result = 1;
						} else {
							Result = 0;
						}
						System.out.println(str.substring(str.indexOf("suiteReportId")+31,str.indexOf("suiteReportId")+47));
						TestDate = str.substring(str.indexOf("suiteReportId")+31,str.indexOf("suiteReportId")+47);			
				}													
			}
		
		}catch (SAXParseException err) {
			System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
			System.out.println(" " + err.getMessage ());
		
		}catch (SAXException e) {
			Exception x = e.getException ();
			((x == null) ? e : x).printStackTrace ();
		
		}catch (Throwable t) {
			t.printStackTrace ();
		}

	 	TestResult tr = new TestResult(Name,Result,RunTime,TestDate);	
	 	tr.addTestResult(tr);
	 
	}
}