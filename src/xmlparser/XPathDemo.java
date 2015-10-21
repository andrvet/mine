package xmlparser;



	import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

	public class XPathDemo {
/*
 * <?xml version="1.0"?>
    <config>
        <Request name="ValidateEmailRequest">
            <requestqueue>emailrequest</requestqueue>
            <responsequeue>emailresponse</responsequeue>
        </Request>
        <Request name="CleanEmail">
            <requestqueue>Cleanrequest</requestqueue>
            <responsequeue>Cleanresponse</responsequeue>
        </Request>
    </config>
 */
	    public static void main(String[] args) {
	        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	        try {
	            DocumentBuilder builder = domFactory.newDocumentBuilder();
	            Document dDoc = builder.parse("C:\\MyEclipse_workspace\\mine\\src\\xmlparser\\xpath.xml");

	            XPath xPath = XPathFactory.newInstance().newXPath();
	            Node node = (Node) xPath.evaluate("/Request/@name", dDoc, XPathConstants.NODE);
	            System.out.println(node.getNodeValue());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}
