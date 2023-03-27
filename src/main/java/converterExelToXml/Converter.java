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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Converter{
    public String convert(){
        try {
            // Создаем фабрику XML-выходных потоков
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

            // Создаем XML-поток для записи в файл
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(new File("kaspi_catalog.xml")));

            // Начало документа
            xmlStreamWriter.writeStartDocument("UTF-8", "1.0");

            // Открываем корневой элемент
            xmlStreamWriter.writeStartElement("kaspi_catalog");
            xmlStreamWriter.writeAttribute("date", "string");
            xmlStreamWriter.writeDefaultNamespace("kaspiShopping");
            xmlStreamWriter.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            xmlStreamWriter.writeAttribute("xsi:schemaLocation", "kaspiShopping http://kaspi.kz/kaspishopping.xsd");

            // Добавляем элементы company и merchantid
            xmlStreamWriter.writeStartElement("company");
            xmlStreamWriter.writeCharacters("CompanyName");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("merchantid");
            xmlStreamWriter.writeCharacters("CompanyID");
            xmlStreamWriter.writeEndElement();

            // Добавляем элемент offers
            xmlStreamWriter.writeStartElement("offers");

            // Добавляем элемент offer
            xmlStreamWriter.writeStartElement("offer");
            xmlStreamWriter.writeAttribute("sku", "232130213");

            // Добавляем элементы model, brand, availabilities и price в элемент offer
            xmlStreamWriter.writeStartElement("model");
            xmlStreamWriter.writeCharacters("iphone 5s white 32gb");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("brand");
            xmlStreamWriter.writeCharacters("Apple");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("availabilities");
            xmlStreamWriter.writeEmptyElement("availability");
            xmlStreamWriter.writeAttribute("available", "yes");
            xmlStreamWriter.writeAttribute("storeId", "myFavoritePickupPoint1");
            xmlStreamWriter.writeEmptyElement("availability");
            xmlStreamWriter.writeAttribute("available", "yes");
            xmlStreamWriter.writeAttribute("storeId", "myFavoritePickupPoint2");
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeStartElement("price");
            xmlStreamWriter.writeCharacters("6418");
            xmlStreamWriter.writeEndElement();

            // Закрываем элемент offer
            xmlStreamWriter.writeEndElement();

            // Закрываем элемент offers
            xmlStreamWriter.writeEndElement();

            // Закрываем элемент kaspi_catalog
            xmlStreamWriter.writeEndElement();

            // Конец документа
            xmlStreamWriter.writeEndDocument();

            // Закрываем поток
            xmlStreamWriter.close();

            System.out.println("XML-файл успешно создан!");

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        return "f";
    }
}
