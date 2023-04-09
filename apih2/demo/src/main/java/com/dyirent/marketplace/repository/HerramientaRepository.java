package com.dyirent.marketplace.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dyirent.marketplace.model.Herramienta;
import org.springframework.stereotype.Repository;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta, Integer> {
}
