
package com.example.diy4rent.demo.controllers;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.diy4rent.demo.model.Herramientas;
import com.example.diy4rent.demo.repo.IHerramientaRepo;

/*
 * Autor: Sergio Arana y María Galán
 */

@Controller
public class BuscarController {
    @Autowired
    private IHerramientaRepo repo;

    @GetMapping("/filtradoherramientas")
    public String filterByCategory(@RequestParam("category") String category, Model model) {
        List<Herramientas> filteredTools = repo.findByCategory(category);
        model.addAttribute("herramientas", filteredTools);
        return "index";
    }

    @GetMapping("/buscar")
    public ModelAndView buscarHerramienta(@RequestParam("title") String title) {
        List<Herramientas> herramientas = repo.findByTitleContaining(title);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("herramientas", herramientas);
        System.out.println("Número de herramientas encontradas: " + herramientas.size());

        return modelAndView;
    }
}
