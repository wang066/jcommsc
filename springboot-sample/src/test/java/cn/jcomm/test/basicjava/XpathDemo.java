package cn.jcomm.test.basicjava;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

/**
 * Created by jowang on 2016/11/7 0007.
 */
public class XpathDemo {

    private static Document doc;
    private static javax.xml.xpath.XPath xpath;

    public static void main(String[] args) throws Exception {
        //创建doc
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        DocumentBuilder db = dbf.newDocumentBuilder();

        File file = new File("demo2.xml");
        if (!file.exists()) {
            FileWriter fileWriter = new FileWriter("demo2.xml");
            fileWriter.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<rss version=\"2.0\">\n" +
                    "\t<channel>\n" +
                    "\t\t<title>Java Tutorials and Examples 2</title>\n" +
                    "\t\t<language>en-us</language>\n" +
                    "\t\t<item>\n" +
                    "\t\t\t<title><![CDATA[Java Tutorials 2]]></title>\n" +
                    "\t\t\t<link>http://www.javacodegeeks.com/</link>\n" +
                    "\t\t</item>\n" +
                    "\t\t<item>\n" +
                    "\t\t\t<title><![CDATA[Java Examples 2]]></title>\n" +
                    "\t\t\t<link>http://examples.javacodegeeks.com/</link>\n" +
                    "\t\t</item>\n" +
                    "\t</channel>\n" +
                    "\t<college name=\"c1\">\n" +
                    "\t\t<class name=\"class1\">\n" +
                    "\t\t\t<student name=\"stu1\" sex='male' age=\"21\" />\n" +
                    "\t\t\t<student name=\"stu2\" sex='female' age=\"20\" />\n" +
                    "\t\t\t<student name=\"stu3\" sex='female' age=\"20\" />\n" +
                    "\t\t</class>\n" +
                    "\t</college>\n" +
                    "\t<bookstore>\n" +
                    "\t\t<book>\n" +
                    "\t\t\t<title lang=\"eng\">Harry Potter</title>\n" +
                    "\t\t\t<price>29.99</price>\n" +
                    "\t\t</book>\n" +
                    "\t\t<book>\n" +
                    "\t\t\t<title lang=\"eng\">Learning XML</title>\n" +
                    "\t\t\t<price>39.95</price>\n" +
                    "\t\t</book>\n" +
                    "\t</bookstore>\n" +
                    "</rss>");
            fileWriter.close();
        }


        doc = db.parse(new FileInputStream(file));

        //创建xpath
        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();

        Node node = (Node) xpath.evaluate("/*", doc, XPathConstants.NODE);
        System.out.println(node.getNodeName() + "----------" + node.getNodeValue());


        NodeList nodeList = (NodeList) xpath.evaluate("//title", doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeName() + "-----" + nodeList.item(i).getTextContent());
        }

        NodeList nodeList1 = (NodeList) xpath.evaluate("/rss/channel/*", doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList1.getLength(); i++) {
            System.out.println(nodeList1.item(i).getNodeName());
        }
        System.out.println("-----------------------------");

        NodeList nodeList2 = (NodeList) xpath.evaluate("/*/*/*/*", doc,
                XPathConstants.NODESET);
        for (int i = 0; i < nodeList2.getLength(); i++) {
            System.out.print(nodeList2.item(i).getNodeName() + "-->"
                    + nodeList2.item(i).getTextContent() + " ");
        }
        System.out.println("-----------------------------");

        NodeList nodeList3 = (NodeList) xpath.evaluate("//bookstore/book[price>35.00]/title", doc,
                XPathConstants.NODESET);
        for (int i = 0; i < nodeList3.getLength(); i++) {
            System.out.print(nodeList3.item(i).getNodeName() + "-->"
                    + nodeList3.item(i).getTextContent() + " ");
        }
        System.out.println();


    }

    private static void init() throws Exception {

    }
}
