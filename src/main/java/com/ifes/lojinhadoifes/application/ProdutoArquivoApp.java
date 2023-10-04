package com.ifes.lojinhadoifes.application;

import com.ifes.lojinhadoifes.exception.NotFoundException;
import com.ifes.lojinhadoifes.model.entity.Produto;
import com.ifes.lojinhadoifes.repository.ProdutoArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

import java.util.List;

@Component
public class ProdutoArquivoApp implements IGenericApp<Produto> {
    @Autowired
    private ProdutoArquivoRepository produtoArquivoRepository;

    public List<Produto> getAll() throws IOException {
        return produtoArquivoRepository.getAll();
    }

    public Produto create(Produto produto) throws IOException{
       return produtoArquivoRepository.create(produto);
    }

    public Produto getById(long id) throws IOException, NotFoundException {
        return produtoArquivoRepository.getById(id);
    }

    public void deleteById(long id) throws IOException  {
        produtoArquivoRepository.deleteById(id);
    }
}
