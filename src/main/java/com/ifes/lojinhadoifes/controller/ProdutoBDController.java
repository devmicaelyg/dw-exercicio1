package com.ifes.lojinhadoifes.controller;

import com.ifes.lojinhadoifes.application.generic.ApplicationAbstract;
import com.ifes.lojinhadoifes.exception.NotFoundException;
import com.ifes.lojinhadoifes.model.Produto;
import com.ifes.lojinhadoifes.repository.IProdutoRepository;
import com.ifes.lojinhadoifes.repository.generic.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("produtos/bd")
public class ProdutoBDController {

    @Autowired
    private ApplicationAbstract<Produto, IProdutoRepository> applicationAbstract;

    @GetMapping("/")
    public List<Produto> getAll() throws IOException {
        return applicationAbstract.getAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable long id) throws NotFoundException, IOException {
            return applicationAbstract.getById(id);
    }
    @PostMapping("/")
    public Produto create(@RequestBody Produto produto) throws IOException {
        return applicationAbstract.create(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws IOException {
        applicationAbstract.deleteById(id);
    }

}
