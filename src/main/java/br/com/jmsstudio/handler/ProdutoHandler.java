package br.com.jmsstudio.handler;

import br.com.jmsstudio.model.Produto;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ProdutoHandler extends DefaultHandler {

    private StringBuilder content = new StringBuilder();
    private Produto produto;
    private List<Produto> produtos;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "produto":
                produto = new Produto();
                break;

            case "produtos":
                produtos = new ArrayList<>();
                break;

            case "nome":
                content = new StringBuilder();

            case "preco":
                content = new StringBuilder();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "nome":
                produto.setNome(content.toString());
                break;

            case "preco":
                Double preco = Double.parseDouble(content.toString());
                produto.setPreco(preco);
                break;

            case "produto":
                produtos.add(produto);
        }
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
