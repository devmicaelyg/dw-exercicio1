package com.ifes.lojinhadoifes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ifes.lojinhadoifes.model.entity.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long>{
}
