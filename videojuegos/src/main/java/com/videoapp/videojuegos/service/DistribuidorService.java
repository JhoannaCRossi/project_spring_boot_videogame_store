
package com.videoapp.videojuegos.service;

import com.videoapp.videojuegos.domain.Distribuidor;
import com.videoapp.videojuegos.repository.DistribuidorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DistribuidorService {
    
    private final DistribuidorRepository distribuidorRepository;
    
    public DistribuidorService(DistribuidorRepository distribuidorRepository){
        this.distribuidorRepository = distribuidorRepository;
    }
    
    public List<Distribuidor> buscarTodos(){
        return distribuidorRepository.findAll();
    }
}
