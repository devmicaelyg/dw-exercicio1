package com.ifes.lojinhadoifes.controller;

import com.ifes.lojinhadoifes.application.ProdutoBDApp;
import com.ifes.lojinhadoifes.model.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos/bd")
public class ProdutoBDController {

    @Autowired
    private ProdutoBDApp appProdutoBD;

    @GetMapping("/")
    public List<Produto> getAll() {
        return appProdutoBD.getAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable long id){
            return appProdutoBD.getById(id);
    }
    @PostMapping("/")
    public Produto create(@RequestBody Produto produto){
        return appProdutoBD.create(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        appProdutoBD.delete(id);
    }

}
