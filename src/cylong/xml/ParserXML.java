package cylong.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 使用 DOM 解析和创建 XML 文件
 * @author cylong
 * @version 2017年4月3日 上午2:22:28
 */
public class ParserXML {

	private static final String path = "data/test.xml";

	public static void main(String[] args) {
		createXML(path);
		parserXML(path);
	}

	/**
	 * 创建 XML 文件
	 * @param path
	 * @author cylong
	 * @version 2017年4月3日 上午2:48:21
	 */
	private static void createXML(String path) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("college");
			document.appendChild(root);

			Element student = document.createElement("student");
			student.setAttribute("id", "0");
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode("cylong"));
			student.appendChild(name);
			Element biography = document.createElement("biography");
			biography.appendChild(document.createCDATASection("Hello"));
			student.appendChild(biography);
			Element age = document.createElement("age");
			age.appendChild(document.createTextNode("24"));
			student.appendChild(age);

			Element student1 = document.createElement("student");
			student1.setAttribute("id", "1");
			Element name1 = document.createElement("name");
			name1.appendChild(document.createTextNode("cylong1"));
			student1.appendChild(name1);
			Element biography1 = document.createElement("biography");
			biography1.appendChild(document.createCDATASection("World"));
			student1.appendChild(biography1);
			Element age1 = document.createElement("age");
			age1.appendChild(document.createTextNode("25"));
			student1.appendChild(age1);

			root.appendChild(document.createComment("学生0"));
			root.appendChild(student);
			root.appendChild(document.createComment("学生1"));
			root.appendChild(student1);

			writeXML(document, path);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将创建的 xml document 写入到文件中
	 * @param document
	 * @param path 文件路径
	 * @author cylong
	 * @version 2017年4月3日 上午2:39:32
	 */
	private static void writeXML(Document document, String path) {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream(path));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析 XML 文件
	 * @param path
	 * @author cylong
	 * @version 2017年4月3日 上午2:48:53
	 */
	private static void parserXML(String path) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(path);

			// optional, but recommended
			// read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			document.getDocumentElement().normalize();

			Element root = document.getDocumentElement();
			System.out.println("Root element : " + root.getNodeName());
			NodeList students = root.getElementsByTagName("student");
			for(int i = 0; i < students.getLength(); i++) {
				Node student = students.item(i);
				System.out.println(student.getNodeName());

				NodeList info = student.getChildNodes();
				for(int j = 0; j < info.getLength(); j++) {
					Node meta = info.item(j);
					if (meta.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(meta.getNodeName() + ":" + meta.getTextContent());
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
