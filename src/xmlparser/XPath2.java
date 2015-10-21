package xmlparser;


	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.xpath.XPath;
	import javax.xml.xpath.XPathConstants;
	import javax.xml.xpath.XPathFactory;

	import org.w3c.dom.Document;
	import org.w3c.dom.NodeList;

	public class XPath2 {

		/*

 <?xml version="1.0" encoding="UTF-8"?>
<root xmlns="http://www.mydomain.com/schema">
  <author>
    <book title="t1"/>
    <book title="t2"/>
  </author>
</root>

		 */
	    public static void main(String[] args) {
	        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	        try {
	            DocumentBuilder builder = domFactory.newDocumentBuilder();
	            Document dDoc = builder.parse("C:\\MyEclipse_workspace\\mine\\src\\xmlparser\\xpath2.xml");

	            XPath xPath = XPathFactory.newInstance().newXPath();
	            NodeList nl = (NodeList) xPath.evaluate("/root/author", dDoc, XPathConstants.NODESET);
	            
	            System.out.println(nl.getLength());
	            System.out.println(nl.item(0));
	            System.out.println(nl.item(1));
	            System.out.println(nl.item(2));
	            System.out.println(nl.toString());
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	}