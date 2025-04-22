package com.example.helloworld.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.domain.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ApiController {

    @GetMapping("/")
    public String home(){
        return "Home de campers!";
    } 

    @GetMapping("/saludo") // /saludo?nombre=Alejandra
    public String saludo(
        @RequestParam(name = "nombre", required = true) String name, 
        @RequestParam(name = "apellido", required = false, defaultValue = "Apellido comun") String lastName)
        {
        return "Hello " + name + " " + lastName;
    } 

    @GetMapping("/search") //
    public Map<String, String> buscar(@RequestParam(name = "name", defaultValue = "") String name){
        Map<String, String> cities = new HashMap<>();
        cities.put("BUC", "Bucaramanga");
        cities.put("NYC", "New York");
        cities.put("BOG", "Bogota");
        cities.put("NVA", "Neiva");
        cities.put("LET", "Leticia");
        cities.put("PER", "Pereira");

        if(cities.containsKey(name)){
            return Map.of(name, cities.get(name));
        }
        else{
            return cities;
        }
    } 

    @GetMapping("/tax") 
    public Map<String, Object> calcular(
        @RequestParam(defaultValue = "0") double impuestos
        ) {
            List<Producto> productos = new ArrayList<>(
                List.of(new Producto(1, "Pan", 2000))
                );
            productos.add(new Producto(2, "Gaseosa", 3500));
            productos.add(new Producto(3, "Salchichon Zenu", 1500));
            
            double total = 0;

            for (Producto p : productos){
                total += p.getPrice();
            }

            impuestos = impuestos/100;
            double total_impuesto = impuestos * total + total;

            return Map.of("productos", productos, "total", total_impuesto, "valor_neto", total);
    } 
}