package br.com.jmsstudio.test;

import br.com.jmsstudio.model.Produto;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxXmlTest {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("src/vendas.xml");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader eventReader = xmlInputFactory.createXMLEventReader(inputStream);

        List<Produto> produtos = new ArrayList<>();
        Produto produto = null;
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            String elementContent = null;

            if (event.isStartElement()) {
                String elementName = event.asStartElement().getName().getLocalPart();

                switch (elementName) {
                    case "produto":
                        produto = new Produto();
                        break;

                    case "nome":
                        produto.setNome(getValueOfNextElement(eventReader));
                        break;

                    case "preco":
                        Double preco = Double.parseDouble(getValueOfNextElement(eventReader));
                        produto.setPreco(preco);
                        break;
                }
            } else if (event.isEndElement() && "produto".equals(event.asEndElement().getName().getLocalPart())) {
                produtos.add(produto);
            }
        }

        System.out.println(produtos);
    }

    private static String getValueOfNextElement(XMLEventReader eventReader) throws XMLStreamException {
        XMLEvent event = eventReader.nextEvent();
        return event.asCharacters().getData();
    }
}
