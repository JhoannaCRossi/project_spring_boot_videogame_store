
package com.videoapp.videojuegos.repository;


import com.videoapp.videojuegos.domain.Videojuego;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer>{
    
    //todas las instancias v que pertenecen a la clase videojuego y ordenalas por el atributo nombre de cada instancia
    @Query("select v from Videojuego v order by v.nombre")
    List<Videojuego> buscarTodos();
    
    //JPQL es lo ideal cuando trabajamos cn jpa
    //filtraremos por un atributo del videojuego (no a la columna sino a la clase a la instancia)
    @Query("from Videojuego v where v.distribuidor.id = ?1 order by v.nombre")
    List<Videojuego> buscarPorDistribuidor(int distribuidorId);
    
    
   // @Query("from Videojuego v where v.nombre like %?1%")
   // List<Videojuego> buscar(String consulta);

    //spring data ya tiene integrado esta busqueda QUERY METHOD
    List<Videojuego> findByNombreContaining(String consulta);
}
