
package com.videoapp.videojuegos.controller;

import com.videoapp.videojuegos.domain.Videojuego;
import com.videoapp.videojuegos.service.VideojuegoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListadoController {
    
    //traemos objeto del service
    private final VideojuegoService videojuegoService;
    
    public ListadoController(VideojuegoService videojuegoService){
        this.videojuegoService = videojuegoService;
    }
    
    
    @RequestMapping("/")
    //metodo que atendera las peticiones que vienen a la raíz
    public String listarVideojuegos(Model model){
        
        //busqueda de videojuegos
        List<Videojuego> destacados = videojuegoService.buscarDestacados();
        
        //indicamos al modelo que agrege este listado pa pasarselo a la Lista
        model.addAttribute("videojuegos", destacados);
        
        return "listado";
    }
    
    //nueva url para poder filtrar la vista por distribuidor
    @RequestMapping("/videojuegosPorDistribuidor")
    public String listarVideojuegosPorDistribuidor(int distribuidorId, Model model) {
        List<Videojuego> juegos = videojuegoService.buscarPorDistribuidor(distribuidorId);
        
        model.addAttribute("videojuegos", juegos);
        
        return "listado";
    }
    
    //metodo para el buscador
    @RequestMapping("/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model) {
        List<Videojuego> juegos = videojuegoService.buscar(consulta);
        model.addAttribute("videojuegos", juegos);
        
        return "listado";
    }
    
   
    
}
