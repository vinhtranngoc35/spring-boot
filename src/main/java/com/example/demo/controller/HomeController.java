package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class HomeController {

    @Autowired
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public String getIndex(Model model){
        model.addAttribute("message","Học xong controller");

        model.addAttribute("products", productService.getProducts());
        return "index";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product){
        productService.add(product);
        return "create";
    }
}
