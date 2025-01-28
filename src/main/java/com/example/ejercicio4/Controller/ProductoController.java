package com.example.ejercicio4.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejercicio4.Entity.Producto;

@Controller
public class ProductoController {
    
    private final List<Producto> productos = new ArrayList<>();

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model){
        model.addAttribute("producto", new Producto());
        return "formulario";
    }

    @GetMapping("/")
    public String redireccionarFormulario(){return "redirect:/formulario";}

    @PostMapping("/save")
    @ResponseBody
    public Producto guardarProducto(@ModelAttribute Producto producto){
        productos.add(producto);
        return producto;
    }

    @RestController
    @RequestMapping("/api")
    public class ProductoApiController {
        @GetMapping("/productos")
        public List<Producto> lista_Productos(){
            return productos;
        }
    }

}
