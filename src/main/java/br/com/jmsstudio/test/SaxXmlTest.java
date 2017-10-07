package br.com.jmsstudio.test;

import br.com.jmsstudio.handler.ProdutoHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.FileInputStream;

public class SaxXmlTest {

    public static void main(String[] args) throws Exception {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        ProdutoHandler produtoHandler = new ProdutoHandler();
        xmlReader.setContentHandler(produtoHandler);

        FileInputStream fis = new FileInputStream(new File("src/vendas.xml"));

        xmlReader.parse(new InputSource(fis));
        System.out.println(produtoHandler.getProdutos());

    }
}
