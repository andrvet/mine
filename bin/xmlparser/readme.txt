DOM parser
http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser

read an XML file via DOM XML parser. DOM parser parses the entire XML document and loads it into memory; 
then models it in a “TREE” structure for easy traversal or manipulation.

In short, it turns a XML file into DOM [http://www.w3schools.com/dom/default.asp] or Tree structure, and you have to traverse a node by node to get what you want.

What is Node? In the DOM, everything in an XML document is a node, read this http://www.w3schools.com/dom/dom_nodes.asp 
Warning: DOM Parser is slow and consumes a lot of memory when it loads an XML document which contains a lot of data. 
Please consider SAX parser as solution for it, SAX is faster than DOM and use less memory.

////////////////////
SAX parser
****
http://www.journaldev.com/1198/java-sax-parser-example-tutorial-to-parse-xml-to-list-of-objects
****
http://www.mkyong.com/java/how-to-read-xml-file-in-java-sax-parser/

SAX parser is working differently with a DOM parser, it neither load any XML document into memory nor create any object representation of the XML document. Instead, the SAX parser use callback function (org.xml.sax.helpers.DefaultHandler) to informs clients of the XML document structure.

SAX Parser is faster and uses less memory than DOM parser.
See following SAX callback methods :

startDocument() and endDocument() – Method called at the start and end of an XML document.
startElement() and endElement() – Method called at the start and end of a document element.
characters() – Method called with the text contents in between the start and end tags of an XML document element.

/////////// XPath

If you are just looking to get a single value from the XML you may want to use Java's XPath library

http://stackoverflow.com/questions/4076910/how-to-retrieve-element-value-of-xml-using-java
http://stackoverflow.com/questions/3939636/how-to-use-xpath-on-xml-docs-having-default-namespace

--- 
SAX xpath
http://stackoverflow.com/questions/543049/default-xml-namespace-jdom-and-xpath

http://stackoverflow.com/questions/16315378/select-a-node-using-xpath-and-jdom


http://stackoverflow.com/questions/2618136/running-xpath-on-child-node
http://stackoverflow.com/questions/8358994/xpath-search-on-subtree