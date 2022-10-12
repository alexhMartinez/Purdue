import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetGrades {
    private static final String FILENAME = "/Users/homeputer/eclipse-workspace/IT391_Martinez_Unit7/studentGrades.xml";
    
    public static int minGrade;
    public static int maxGrade;
    public static int avgGrade;
    
    public static void results() {

        /*
         * read the file
         */

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));

            doc.getDocumentElement().normalize();

            NodeList blocks = doc.getElementsByTagName("student");
            ArrayList<String> strGrades = new ArrayList<>();
            for(int i = 0; i<blocks.getLength(); i++){
                Element children = (Element) blocks.item(i);
                if(children.getElementsByTagName("grade") != null){
                    strGrades.add(children.getElementsByTagName("grade").item(0).getTextContent());
                }else{
                    strGrades.add("");
                }
            }

            List<Integer> intGrades = new ArrayList<Integer>(strGrades.size()) ;
            for (String myInt : strGrades) {
                intGrades.add(Integer.valueOf(myInt));
            }

            minGrade = Collections.min(intGrades);
            maxGrade = Collections.max(intGrades);

            int sumList = intGrades.stream().mapToInt(Integer::intValue).sum();
            int lenList = intGrades.size();
            avgGrade = sumList / lenList;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
