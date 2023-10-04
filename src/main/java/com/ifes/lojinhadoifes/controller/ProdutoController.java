package com.ifes.lojinhadoifes.controller;

import com.ifes.lojinhadoifes.application.ProdutoApp;
import com.ifes.lojinhadoifes.exception.NotFoundException;
import com.ifes.lojinhadoifes.model.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private ProdutoApp appProduto;

    @GetMapping("/")
    public List<Produto> getAll(){
        return appProduto.getAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable long id){
        try {
            return appProduto.getById(id);
        } catch(NotFoundException exception){
            return null;
        }
    }

    @PostMapping("/")
    public Produto create(@RequestBody Produto produto){
        return appProduto.create(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        appProduto.deleteById(id);
    }
}
