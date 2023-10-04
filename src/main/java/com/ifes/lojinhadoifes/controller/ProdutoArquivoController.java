package com.ifes.lojinhadoifes.controller;

import com.ifes.lojinhadoifes.application.ApplicationAbstract;
import com.ifes.lojinhadoifes.application.ProdutoArquivoApp;
import com.ifes.lojinhadoifes.exception.NotFoundException;
import com.ifes.lojinhadoifes.model.entity.Produto;
import com.ifes.lojinhadoifes.repository.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("produtos/arquivo")
public class ProdutoArquivoController {
    @Autowired
    private ApplicationAbstract<Produto, IGenericRepository<Produto,Long>> applicationAbstract;

    @GetMapping("/")
    public List<Produto> getAll() throws IOException {
        return applicationAbstract.getAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable long id) throws IOException, NotFoundException{
        return applicationAbstract.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) throws IOException, NotFoundException{
        applicationAbstract.deleteById(id);
    }

    @PostMapping("/")
    public Produto create(@RequestBody Produto produto) throws IOException {
        return applicationAbstract.create(produto);
    }
}
