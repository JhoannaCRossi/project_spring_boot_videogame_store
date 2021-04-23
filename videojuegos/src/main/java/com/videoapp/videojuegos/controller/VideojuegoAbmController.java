
package com.videoapp.videojuegos.controller;

import com.videoapp.videojuegos.domain.Videojuego;
import com.videoapp.videojuegos.service.DistribuidorService;
import com.videoapp.videojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideojuegoAbmController {
    
    //objetos de nuestros services
    private final DistribuidorService distribuidorService;
    private final VideojuegoService videojuegoService;

    
    //constructor 
    public VideojuegoAbmController(DistribuidorService distribuidorService, VideojuegoService videojuegoService) {
        this.distribuidorService = distribuidorService;
        this.videojuegoService = videojuegoService;
    }
    
    
    
    //método para crear videojuego
    @RequestMapping("/videojuego/crear")
    public String mostrarFormAlta(Model model) {
        model.addAttribute("distribuidores", distribuidorService.buscarTodos());
        model.addAttribute("videojuego", new Videojuego());
        return "formVideojuego";
    }
    
    //método para guardar video juego y redirigir al inicio 
    @PostMapping("/videojuego/guardar")
    public String guardr(Videojuego videojuego) {
        videojuegoService.guardar(videojuego);
        return "redirect:/";
    }
    
    
}
