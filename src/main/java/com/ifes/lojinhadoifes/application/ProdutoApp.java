package com.ifes.lojinhadoifes.application;

import com.ifes.lojinhadoifes.application.generic.IGenericApp;
import com.ifes.lojinhadoifes.exception.NotFoundException;
import com.ifes.lojinhadoifes.model.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoApp implements IGenericApp<Produto> {
    List<Produto> produtoList = new ArrayList<Produto>();
    private long lastId = 0;

    public  List<Produto> getAll(){
        return produtoList;
    }

    public Produto create(Produto produto){
        lastId++;
        produto.setId(lastId);
        produto.setNome(produto.getNome());
        produtoList.add(produto);
        return produto;
    }

    public Produto getById(long id) throws NotFoundException {
           for (Produto prod : produtoList) {
               if (prod.getId() == id) {
                   return prod;
               }
           }

        throw new NotFoundException();
    }

    public void deleteById(long id){
        produtoList.removeIf(produto -> produto.getId() == (id));
    }

}
