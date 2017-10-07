package br.com.jmsstudio.test;

import br.com.jmsstudio.model.Produto;
import br.com.jmsstudio.model.Venda;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JaxBTest {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
        doUnmarshal(jaxbContext);
        doMarshal(jaxbContext);
    }

    private static void doUnmarshal(JAXBContext jaxbContext) throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        File vendaFile = new File("src/vendas.xml");

        Venda unmarshalledVenda = (Venda) unmarshaller.unmarshal(vendaFile);
        System.out.println(unmarshalledVenda);
    }

    private static void doMarshal(JAXBContext jaxbContext) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Produto produto1 = new Produto("Lavadora Brastemp 11 Kg", 1900.0);
        Produto produto2 = new Produto("Fone de ouvido", 10.0);

        List<Produto> produtos = Arrays.asList(produto1, produto2);
        Venda venda = new Venda();
        venda.setMoeda("Dolar");
        venda.setFormaDePagamento("Cartão de Crédito");
        venda.setProdutos(produtos);

        marshaller.marshal(venda, new File("out/novaVenda.xml"));
        System.out.println("Arquivo gerado com sucesso");
    }
}
