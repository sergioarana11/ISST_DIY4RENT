package com.example.testspring.demo.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class Controller {

    @GetMapping(value="/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        return modelAndView;
    }
    
}
