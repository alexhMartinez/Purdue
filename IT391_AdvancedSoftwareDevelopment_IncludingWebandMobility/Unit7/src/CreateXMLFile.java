import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class CreateXMLFile {

    public static final String xmlFilePath = "studentGrades.xml";
    static Document document;
    static Element root;
    static void loadElement(Integer id) {
        //create faster naming for students in scenario
        String strID = id.toString();
        String studentName = "student";
        //generate random grade between 50 and 100
        int Random = (70) + (int)(Math.random()* ( 100 - 70 + 1));
        String strGrade = String.valueOf(Random);

        Element student = document.createElement(studentName);
        root.appendChild(student);
        Attr attr = document.createAttribute("id");
        attr.setValue(strID);
        student.setAttributeNode(attr);
        Element grade = document.createElement("grade");
        grade.appendChild(document.createTextNode(strGrade));
        student.appendChild(grade);
    }

    public static void main() {

        /*
         * create file
         */

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();

            root = document.createElement("school");
            document.appendChild(root);

            loadElement(1);
            loadElement(2);
            loadElement(3);
            loadElement(4);
            loadElement(5);
            loadElement(6);
            loadElement(7);
            loadElement(8);
            loadElement(9);
            loadElement(10);
            loadElement(11);
            loadElement(12);
            loadElement(13);
            loadElement(14);
            loadElement(15);
            loadElement(16);
            loadElement(17);
            loadElement(18);
            loadElement(19);
            loadElement(20);
            loadElement(21);
            loadElement(22);
            loadElement(23);
            loadElement(24);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);
            System.out.println("XML File Created");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
