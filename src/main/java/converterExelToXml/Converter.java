package converterExelToXml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Converter{
    public String convert(){
        try {
            //Old commit
            // Создаем объект DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Создаем объект DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Создаем объект Document
            Document doc = dBuilder.newDocument();

            // Создаем корневой элемент
            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);

            // Создаем элемент
            Element element = doc.createElement("element");
            rootElement.appendChild(element);

            // Устанавливаем значение элемента
            element.appendChild(doc.createTextNode("Hello, world!"));

            // Создаем объект TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // Создаем объект Transformer
            Transformer transformer = transformerFactory.newTransformer();

            // Создаем объект DOMSource
            DOMSource source = new DOMSource(doc);

            // Создаем объект FileWriter
            FileWriter writer = new FileWriter(new File("example.xml"));

            // Создаем объект StreamResult
            StreamResult result = new StreamResult(writer);

            // Преобразуем исходный код XML и записываем его в файл
            transformer.transform(source, result);

            // Закрываем FileWriter
            writer.close();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "f";
    }
}
