package com.ifes.lojinhadoifes.application;

import com.ifes.lojinhadoifes.model.entity.Produto;
import com.ifes.lojinhadoifes.repository.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProdutoBDApp implements IGenericApp<Produto> {
    @Autowired
    private IGenericRepository<Produto, Long> repository;

    public List<Produto> getAll(){
        return repository.findAll();
    }

    public Produto create(Produto produto){
        return repository.save(produto);
    }

    public Produto getById(long Id){
        return repository.getReferenceById(Id);
    }

    @Override
    public void deleteById(long id) throws IOException {
        repository.deleteById(id);
    }
}
