package com.ifes.lojinhadoifes.repository;

import com.ifes.lojinhadoifes.application.IGenericApp;
import com.ifes.lojinhadoifes.model.entity.Produto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoArquivoRepository implements IGenericApp<Produto> {

    private String filePath = "src/main/java/com/ifes/lojinhadoifes/repository/produtos.csv";
    public List<Produto> getAll() throws IOException {
        List<Produto> produtoList = new ArrayList<>();

        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> produtos = csvReader.readAll();
        for(String[] item : produtos) {
            Produto prod = new Produto();
            prod.setId(Long.parseLong(item[0]));
            prod.setNome(item[1]);
            prod.setPreco(Double.parseDouble(item[2]));
            produtoList.add(prod);
        }

        return produtoList;
    }

    public Produto create(Produto produto) throws IOException{
            FileWriter outputfile = new FileWriter(filePath, true);
            CSVWriter writer = new CSVWriter(outputfile);

            String[] novoProduto = new String[] {
                    String.valueOf(produto.getId()),
                    produto.getNome(),
                    String.valueOf(produto.getPreco())
            };

            writer.writeNext(novoProduto);
            writer.close();

            return produto;
    }

    public Produto getById(long id) throws IOException {
        List<Produto> produtoList = getAll();

        for (Produto prod : produtoList) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    public void deleteById(long Id)  throws IOException {
        List<Produto> newProdutoList = getAll();
        List<String[]> novaLista = new ArrayList<>();
        String[] cabecalho = new String[] {"id", "nome", "preço"};

        newProdutoList.removeIf(prod -> prod.getId() == (Id));
        novaLista.add(cabecalho);

        for(Produto item : newProdutoList) {
            String[] novoProduto = new String[] {
                    String.valueOf(item.getId()),
                    item.getNome(),
                    String.valueOf(item.getPreco())
            };
            novaLista.add(novoProduto);
        }

        rescreverArquivo(novaLista);
    }

    public void rescreverArquivo(List<String[]> produtos) throws IOException {
        FileWriter outputfile = new FileWriter(filePath);
        CSVWriter writer = new CSVWriter(outputfile);

        writer.writeAll(produtos);
        writer.close();
    }
}
