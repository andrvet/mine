package NCBIXPathSAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class NBCISAXHandler extends DefaultHandler{

	private List<NCBIDocSum> empList = null;
	private NCBIDocSum emp = null;

	boolean bDOI = false;
	boolean bId = false;


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("DocSum")) {
			String id = null;
			emp = new NCBIDocSum();
			emp.setId(id);
			if (empList == null)
				empList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("Id")) {
			bId = true;
		} 
		else if (qName.equalsIgnoreCase("Item")) {
			if (attributes.getValue("Name").equalsIgnoreCase("DOI")) {
				bDOI = true;
			}
		} 
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("DocSum")) {
			empList.add(emp);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {

		if (bId) {
			emp.setId(new String(ch, start, length));
			bId = false;
		} else if (bDOI) {
			emp.setDoi(new String(ch, start, length));
			bDOI = false;
		} 
	}
	
	public List<NCBIDocSum> getDocSumList() {
		return empList;
	}

	

}
