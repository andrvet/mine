package xmlparser;

/*
 * http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser
 * 
 * 2. Looping the Node
 This example reads the same “staff.xml“, 
 and showing you how to loop the node one by one, and print out the node name and value, 
 and also the attribute if any.
 */

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLDOMLoopNodes {

	public static void main(String[] args) {

		try {
			File file = new File("C:\\MyEclipse_workspace\\mine\\src\\xmlparser\\staff.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			if (doc.hasChildNodes()) {
				printNote(doc.getChildNodes());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void printNote(NodeList nodeList) {
/*
<?xml version="1.0"?>
<company>
	<staff id="1001">
		<firstname>yong</firstname>
		<lastname>mook kim</lastname>
		<nickname>mkyong</nickname>
		<salary>100000</salary>
	</staff>
	<staff id="2001">
		<firstname>low</firstname>
		<lastname>yin fong</lastname>
		<nickname>fong fong</nickname>
		<salary>200000</salary>
	</staff>
</company>
 */
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node name and value
				System.out.println("======== count="+count+" =====");
				//Node Name =company [OPEN]
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]"); 
				//Node Value =
//				
//				yong
//				mook kim
//				mkyong
//				100000
				
				System.out.println("Node Value =" + tempNode.getTextContent() +"---");
				System.out.println("=================");
				if (tempNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());
					}
				}
				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					printNote(tempNode.getChildNodes());
				}
				System.out.println("Node Name =" + tempNode.getNodeName()+ " [CLOSE]");
			}
		}
	}
}