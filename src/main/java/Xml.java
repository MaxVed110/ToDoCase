import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Xml {

    private Document createXml(ToDoList list) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("toDoList");
        doc.appendChild(rootElement);

        int count =1;

        for (int key : list.storage.keySet()) {
            for (Case c : list.storage.get(key)) {
                Element name = doc.createElement("Case" + count);
                count++;
                rootElement.appendChild(name);

                Element nameCase = doc.createElement("Name_Case");
                nameCase.setTextContent(c.name);
                name.appendChild(nameCase);

                Element priority = doc.createElement("Priority");
                priority.setTextContent(key + "");
                name.appendChild(priority);

                Element dataTime = doc.createElement("Add");
                dataTime.setTextContent(c.dataTime);
                name.appendChild(dataTime);

                Element deadline = doc.createElement("Deadline");
                deadline.setTextContent(c.deadline);
                name.appendChild(deadline);

                Element author = doc.createElement("Author");
                author.setTextContent(c.author);
                name.appendChild(author);
            }
        }
        return doc;
    }

    public void printXml(ToDoList list) throws TransformerException, ParserConfigurationException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.ENCODING, "Windows-1251");

        DOMSource source = new DOMSource(createXml(list));
        StreamResult result = new StreamResult(new File("toDoList.xml"));

        transformer.transform(source, result);
    }
}
