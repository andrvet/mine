package xmlparser;

//http://stackoverflow.com/questions/773012/getting-xml-node-text-value-with-java-dom

//import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XPathTest {

	   // private Document document;

	//    @Before
	//    public void setup() throws Exception {
//	        String xml = "<add job=\"351\"><tag>foobar</tag><tag>foobar2</tag></add>";
//	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//	        DocumentBuilder db = dbf.newDocumentBuilder();
//	        document = db.parse(new InputSource(new StringReader(xml)));
//	    }

	    //@Test
	    public static void main (String[] args) throws Exception {
	    	
	    	String xml = "<add job=\"351\">"
	    			+ "<tag>foobar</tag>"
	    			+ "<tag>foobar2</tag>"
	    			+ "</add>";
	    	
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new InputSource(new StringReader(xml)));
	        
	        
	        XPathFactory xpf = XPathFactory.newInstance();
	        XPath xp = xpf.newXPath();
	        String text = xp.evaluate("//add[@job='351']/tag[position()=1]/text()",
	            document.getDocumentElement());
	        
	        System.out.println(text);
	        
	        
	        String text2 = xp.evaluate("//add[@job='351']/tag[position()=2]/text()",
		            document.getDocumentElement());
	        
	        System.out.println(text2);
	       // assertEquals("foobar", text);
	    }
	}