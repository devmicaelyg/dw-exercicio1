package com.ifes.lojinhadoifes.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@NoRepositoryBean
public interface IGenericRepository<T> extends JpaRepository<T, Long> {
}
