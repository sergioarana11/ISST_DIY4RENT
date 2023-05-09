
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

@Controller
public class HerramientasController {

    @Autowired
    private IHerramientaRepo repo;
    /*
     * @GetMapping("/herramientas")
     * public ModelAndView herramientas() {
     * ModelAndView modelAndView = new ModelAndView("herramientas");
     * List<Herramientas> herramientas = repo.findAll();
     * modelAndView.addObject("herramientas", herramientas);
     * return modelAndView;
     * }
     * 
     * @GetMapping("/buscar-herramienta")
     * public ModelAndView buscarHerramienta(@RequestParam("title") String title) {
     * List<Herramientas> herramientas = repo.findByTitleContaining(title);
     * ModelAndView modelAndView = new ModelAndView("herramientas");
     * modelAndView.addObject("herramientas", herramientas);
     * return modelAndView;
     * }
     */
    /*
     * @GetMapping("/filtradoherramientas")
     * public ModelAndView filtrarHerramientas(@RequestParam(value = "category",
     * required = false) String category,
     * 
     * @RequestParam(value = "price", required = false) Float price) {
     * List<Herramientas> herramientas = repo.findByCategory(category);
     * ModelAndView modelAndView = new ModelAndView("filtradoherramientas");
     * modelAndView.addObject("herramientas", herramientas);
     * modelAndView.addObject("filtradoherramienta", category);
     * // modelAndView.addObject("filtroPrecio", price);
     * return modelAndView;
     * }
     */

    @GetMapping("/filtradoherramientas")
    public String filterByCategory(@RequestParam("category") String category, Model model) {
        List<Herramientas> filteredTools = repo.findByCategory(category);
        model.addAttribute("herramientas", filteredTools);
        return "index";
    }
}
