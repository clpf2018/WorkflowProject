package dynamicview;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLParser {

    public static void main(String[] args) {
        String filePath = "fields.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("field");
            //now XML is loaded as Document in memory, lets convert it to Object List
            List<field> fieList = new ArrayList<field>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                fieList.add(getfield(nodeList.item(i)));
                
            }
            
            //lets print field list information
            for (field f : fieList) {
                System.out.println(f.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }


    private static field getfield(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        field f = new field();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            f.setOrder(Integer.parseInt(getTagValue("order", element)));
            f.setdesc(getTagValue("desc", element));
            f.setName(getTagValue("name", element));
            f.setsqlType(getTagValue("sqlType", element));
            f.setformType(getTagValue("formType", element));
            f.settype(getTagValue("type", element));
            f.setsqlSize(Integer.parseInt(getTagValue("sqlSize", element)));
            f.setmin(Integer.parseInt(getTagValue("min", element)));
            f.setmin_sort_order(Integer.parseInt(getTagValue("min_sort_order", element)));
            f.setsize(Integer.parseInt(getTagValue("size", element)));
            f.setsqlPK(checked("sqlPK", element));
            f.setmandatory(checked("mandatory", element));
            f.setshow(checked("show",element));
            f.setupdate(checked("update", element));
            f.setinsert(checked("insert", element));
            f.setunicity(checked("unicity", element));
   
        }

        return f;
    }
    
    public static boolean checked(String tagName, Element element){
        boolean state = true;
     if(!"checked".equals(getTagValue("tagName",element))){
         state=false;
     }
 
        return state;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}
