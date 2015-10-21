package NCBIXPathSAX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.http.HttpStatus;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class AutoSetArticleDoisFromNCBITest {

	// so called "fron-end WS". can not accept 200 ids. returns "pseudo-xml"
	// (<pre> pseudo-xml-text-with-&lt/&gt </pre>)
	// private static final String XML_SERVICE_URL =
	// "http://www.ncbi.nlm.nih.gov/pubmed/%s?dopt=Abstract&report=xml&format=text";
	private static final String XML_SERVICE_URL = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esummary.fcgi?db=pubmed&id=";

	// returns normal xml and accepts 200 ids
	/*
	 * <eSummaryResult> <DocSum> <Id>25239749</Id> ... <Item Name="DOI"
	 * Type="String">10.1007/978-1-4939-1652-8_11</Item> ... </DocSum> ...
	 * <eSummaryResult>
	 */
	private String makeGetRequest(String urlString) {
		String result = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.setDoOutput(true);

			System.out.println("Sending 'GET' request to URL : " + url);
			int responseCode = urlConn.getResponseCode();
			System.out.println("Response Code : " + responseCode);

			if (responseCode != HttpStatus.SC_OK) {
				System.out.println("There was a problem requesting the data: " + urlString);
			}

			StringBuilder response = new StringBuilder();
			try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()))) {
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
			}

			result = response.toString();
			urlConn.disconnect();
		} catch (Exception e) {
			System.out.println("A problem occurred while making a request" + e);
		}
		return result;
	}

	public static void main(String[] args) {
		// String pmid =
		// "25239749,22923678,22430844,21798944,21166475,17317660,17151019,16287169";
		AutoSetArticleDoisFromNCBITest test = new AutoSetArticleDoisFromNCBITest();
		// String requestXml = String.format(XML_SERVICE_URL, pmid);
		String requestXml = XML_SERVICE_URL + "123,25239749,22923678,22430844,21798944,21166475,17317660,17151019,16287169,123";// "25239749,22923678,123";
																																// //"11003848,11003843,26032777";//"25239749,123";//

		// System.out.println("requestXml=" + requestXml);
		String xmlResponse = test.makeGetRequest(requestXml);
		// System.out.println(xmlResponse + "\n");

		// getByXPath(xmlResponse); //does not work
		getBySaxParser(xmlResponse);
	}

	private static void getBySaxParser(String xmlResponse) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			NBCISAXHandler handler = new NBCISAXHandler();
			saxParser.parse(new InputSource(new StringReader(xmlResponse)), handler);
			List<NCBIDocSum> empList = handler.getDocSumList();

			for (NCBIDocSum emp : empList) {
				System.out.println(emp);
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	private static void getByXPath(String xmlResponse) {
		try {
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlResponse)));
			doc.getDocumentElement().normalize();// optional, but recommended,
													// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work

			XPath xp = XPathFactory.newInstance().newXPath();

			NodeList nlIds = (NodeList) xp.evaluate("/eSummaryResult/DocSum/Id", doc, XPathConstants.NODESET);
			System.out.println("nlIds legnth=" + nlIds.getLength());

			NodeList nlDois = (NodeList) xp.evaluate("/eSummaryResult/DocSum/Item[@Name='DOI']/text()", doc, XPathConstants.NODESET);
			System.out.println("nlDois legnth=" + nlDois.getLength() + "\n");

			// NodeList nlIds = (NodeList)
			// xp.evaluate("/eSummaryResult/DocSum/Id | /eSummaryResult/DocSum/Item[@Name='DOI']",
			// doc, XPathConstants.NODESET);
			// NodeList nlIds = (NodeList)
			// xp.evaluate("//Id | .//Item[@Name='DOI']", doc,
			// XPathConstants.NODESET);
			System.out.println("nlIds legnth=" + nlIds.getLength());

			// NodeList nlDois = (NodeList)
			// xp.evaluate("/eSummaryResult/DocSum/Item[@Name='DOI']/text()",
			// doc, XPathConstants.NODESET);
			// System.out.println("nlDois legnth=" + nlDois.getLength() +"\n");

			// WRONG
			for (int i = 0; i < nlIds.getLength(); i++) {
				Node tempIdNode = nlIds.item(i);
				Node tempDOINode = nlDois.item(i);
				System.out.println(" IdnodeName=" + tempIdNode.getNodeName());
				System.out.println(" IdnodeTextContent= " + tempIdNode.getTextContent());
				System.out.println(" IdnodeValue= " + tempIdNode.getNodeValue());
				// System.out.println(" IdnodeUserData= " +
				// tempIdNode.getUserData("DOI") + " DOIUserData=" +
				// (tempDOINode!=null ? tempDOINode.getUserData("DOI"):"null"));
				// System.out.println(" IdnodeFeature= " +
				// tempIdNode.getFeature("DOI", "") + " DOInodeFeature=" +
				// (tempDOINode!=null ? tempDOINode.getFeature("DOI",
				// ""):"null"));
				System.out.println("\n");

			}

			// for (int i = 0; i < nlIds.getLength(); i++) {
			// Node tempIdNode = nlIds.item(i);
			// NodeList idChildren = tempIdNode.getChildNodes();
			// System.out.println("idChildren length="+idChildren.getLength());
			// System.out.println("idChild v="+idChildren.item(0).getNodeValue()+" idChild tc="+idChildren.item(0).getTextContent());
			// System.out.println(" IdnodeName="+tempIdNode.getNodeName() +
			// " DOInodeName=" + (tempDOINode!=null ?
			// tempDOINode.getNodeName():"null"));
			// System.out.println(" IdnodeTextContent= "+tempIdNode.getTextContent()
			// + " DOInodeTextContent=" + (tempDOINode!=null ?
			// tempDOINode.getTextContent():"null"));
			// System.out.println(" IdnodeValue= " + tempIdNode.getNodeValue() +
			// " DOInodeValue=" + (tempDOINode!=null ?
			// tempDOINode.getNodeValue():"null"));
			// System.out.println(" IdnodeUserData= " +
			// tempIdNode.getUserData("DOI") + " DOIUserData=" +
			// (tempDOINode!=null ? tempDOINode.getUserData("DOI"):"null"));
			// System.out.println(" IdnodeFeature= " +
			// tempIdNode.getFeature("DOI", "") + " DOInodeFeature=" +
			// (tempDOINode!=null ? tempDOINode.getFeature("DOI", ""):"null"));
			// System.out.println("\n");

			// }

			String pubmedid = (String) xp.evaluate("/eSummaryResult/DocSum/Id", doc);// ,
			String doi = (String) xp.evaluate("/eSummaryResult/DocSum/Item[@Name='DOI']/text()", doc, XPathConstants.STRING);
			System.out.println(pubmedid);
			System.out.println(doi);
		} catch (ParserConfigurationException | XPathExpressionException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
