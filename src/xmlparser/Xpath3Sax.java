package xmlparser;

import javax.xml.stream.events.Namespace;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.xpath.XPathExpression;

//http://stackoverflow.com/questions/16315378/select-a-node-using-xpath-and-jdom
public class Xpath3Sax {

	public static void main(String args[]) throws Exception {
//
//		SAXBuilder builder = new SAXBuilder();
//		Document d = builder.build("xpath.xml");
//
//		// XPath xpath = XPath.newInstance("x:collection/x:dvd");
//		// xpath.addNamespace("x", d.getRootElement().getNamespaceURI());
//
//		XPathFactory xpf = XPathFactory.instance();
//		XPathExpression<Element> xpath = xpf.compile("/h:html/h:head/xpns:model", Filters.element(), null,
//				Namespace.getNamesace("xpns", "http://www.w3.org/2002/xforms"));
//		Element model = xpath.evaluateFirst(mydoc);
//
//		System.out.println(xpath.selectNodes(d));
	}

}
