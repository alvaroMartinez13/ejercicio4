package com.example.ejercicio4.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ejercicio4.Entity.Producto;

@Controller
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    @GetMapping("/")
    public String redireccionarFormulario(){return "redirect:formulario";}

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario"; 
    }

    @PostMapping("/save")
    @ResponseBody
    public Producto guardarProducto(@ModelAttribute Producto producto) {
        productos.add(producto); 
        return producto; 
    }

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productos);
        return "productos";
    }

}
