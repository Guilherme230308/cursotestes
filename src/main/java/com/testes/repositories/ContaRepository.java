package com.testes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testes.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
