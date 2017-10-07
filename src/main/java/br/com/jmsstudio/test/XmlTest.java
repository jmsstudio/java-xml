package br.com.jmsstudio.test;

import br.com.jmsstudio.model.Produto;
import com.sun.org.apache.xml.internal.utils.DefaultErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.util.List;

public class XmlTest {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                "http://www.w3.org/2001/XMLSchema");
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        documentBuilder.setErrorHandler(new DefaultErrorHandler());
        Document document = documentBuilder.parse("src/vendas.xml");

        Element formaDePagamento = (Element) document.getElementsByTagName("formaDePagamento").item(0);
        System.out.println(formaDePagamento.getTextContent());

        Element vendaElement = document.getDocumentElement();
        System.out.println(vendaElement.getAttribute("moeda"));

        NodeList produtos = document.getElementsByTagName("produto");
        for (int i = 0; i < produtos.getLength(); i++) {
            Element elProduto = (Element) produtos.item(i);

            String nome = elProduto.getElementsByTagName("nome").item(0).getTextContent();
            Double preco = Double.parseDouble(elProduto.getElementsByTagName("preco").item(0).getTextContent());

            Produto produto = new Produto(nome, preco);

            System.out.println("Produto: " + produto);
        }

        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expression = xPath.compile("/venda/produtos/produto[2]");
        NodeList result = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        System.out.println(result.item(0).getTextContent());
    }
}
