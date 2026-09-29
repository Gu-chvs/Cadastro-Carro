package com.empresa.cadastro_carro.infrasctruture.repository;

import com.empresa.cadastro_carro.infrasctruture.entitys.Carro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.Transient;
import java.util.Optional;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

    Optional<Carro> findByPlaca(String Placa);

    @Transactional
    void deleteByPlaca(String placa);
}
