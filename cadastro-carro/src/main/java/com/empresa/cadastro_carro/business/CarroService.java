package com.empresa.cadastro_carro.business;

import com.empresa.cadastro_carro.infrasctruture.entitys.Carro;
import com.empresa.cadastro_carro.infrasctruture.repository.CarroRepository;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public void salvarCarro(Carro carro){
        repository.saveAndFlush(carro);
    }

    public Carro buscarCarroPorPlaca(String placa){

        return repository.findByPlaca(placa).orElseThrow(
                () -> new RuntimeException("Carro não encontrado!")
        );
    }

    public void deletarCarroPorPlaca(String placa){
        repository.deleteByPlaca(placa);
    }

    public void atualizarCarroPorId(Integer id, Carro carro){
        Carro carroEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Carro não encontrado!"));
        Carro carroAtualizado = Carro.builder()
                .placa(carro.getPlaca() != null ? carro.getPlaca() :
                        carroEntity.getPlaca())
                .modelo(carro.getModelo() != null ? carro.getModelo() :
                        carroEntity.getModelo())
                .ano(carro.getAno() != null ? carro.getAno() : carroEntity.getAno() )
                .marca(carro.getMarca() != null ? carro.getMarca() : carroEntity.getMarca())
                .id(carroEntity.getId())
                .build();
        repository.saveAndFlush(carroAtualizado);
    }



}
