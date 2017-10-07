package br.com.jmsstudio.test;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XsltTransformerTest {

    public static void main(String[] args) throws Exception {
        Source xslStreamSource = new StreamSource(new FileInputStream("src/vendas-to-html.xsl"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer(xslStreamSource);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        File destFile = new File("out/result.html");
        Result streamResult = new StreamResult(new FileOutputStream(destFile));

        Source xmlStreamSource = new StreamSource(new FileInputStream("src/vendas.xml"));

        transformer.transform(xmlStreamSource, streamResult);

        System.out.println("Transformation applied");
    }
}
