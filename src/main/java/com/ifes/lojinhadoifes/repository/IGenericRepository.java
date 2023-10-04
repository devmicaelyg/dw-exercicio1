package com.ifes.lojinhadoifes.repository;

import com.ifes.lojinhadoifes.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenericRepository<T, W> extends JpaRepository<T, W> {
}
