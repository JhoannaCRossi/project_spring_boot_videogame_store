
package com.videoapp.videojuegos.service;

import com.videoapp.videojuegos.domain.Videojuego;
import com.videoapp.videojuegos.repository.VideojuegoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VideojuegoService {
    
    private final VideojuegoRepository videojuegoRepository;
    
    public VideojuegoService(VideojuegoRepository videojuegoRepository){
        this.videojuegoRepository = videojuegoRepository;
    }
    
    //creamos metodo para buscar videojuegos ordenados
    public List<Videojuego> buscarDestacados(){
        return videojuegoRepository.buscarTodos();
    }
    
    //metodo para buscar videojuegos por distribuidor ordenados
    public List<Videojuego> buscarPorDistribuidor(int distribuidorId) {
        return videojuegoRepository.buscarPorDistribuidor(distribuidorId);
    }
    
    //metodo para mi buscador
    public List<Videojuego> buscar(String consulta){
        return videojuegoRepository.findByNombreContaining(consulta);
    }
    
    //metodo guardar videojuego
   public Videojuego guardar(Videojuego videojuego){
       return videojuegoRepository.save(videojuego);
   } 
}
