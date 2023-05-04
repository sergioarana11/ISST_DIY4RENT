package com.example.diy4rent.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diy4rent.demo.model.Usuarios;

public interface IUsuarioRepo extends JpaRepository<Usuarios, UUID> {

}
