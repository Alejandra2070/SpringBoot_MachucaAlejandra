package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;

@RestController
public class ProductRepository {
    List<Product> products = new ArrayList<>(
        List.of(new Product(1, "Gaseosa", "Bebida", 500, 5))
    );

    public ProductRepository(){
        products.add(new Product(2, "Festival", "Galleta", 800, 9));
        products.add(new Product(3, "Hit", "Jugo", 1.800, 5));
        products.add(new Product(4, "Oreo", "Galleta", 1000, 8));
        products.add(new Product(5, "Lily Pink", "Perfume", 29000, 17));
        products.add(new Product(6, "Uvas", "Fruta", 800, 14));
        products.add(new Product(7, "Fresas", "Fruta", 500, 12));
        products.add(new Product(8, "Jet", "Chocolate", 1800, 7));
        products.add(new Product(9, "Jumbo", "Chocolate", 2000, 4));
        products.add(new Product(10, "Flower Power", "Cuaderno", 800, 20));    
        products.add(new Product(11, "Kiut", "Resaltador", 2500, 19));
        products.add(new Product(12, "Glipao", "Resaltador", 2000, 15));
        products.add(new Product(13, "Offi-Esco", "Lapiz", 900, 12));
        products.add(new Product(14, "Nectar", "Jugo", 2800, 14));
        products.add(new Product(15, "Dior", "Perfume", 25000, 8));
        products.add(new Product(16, "Scribe", "Cuaderno", 800, 9));
        products.add(new Product(17, "Mongo", "Lapiz", 800, 17));
        products.add(new Product(18, "Fresa", "Bombon", 800, 19));
        products.add(new Product(19, "Lemon", "Bombon", 800, 5));
        products.add(new Product(20, "Piña", "Bombon", 800, 3));
    }
}
