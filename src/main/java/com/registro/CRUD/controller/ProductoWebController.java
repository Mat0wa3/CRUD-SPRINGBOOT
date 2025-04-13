package com.registro.CRUD.controller;

import com.registro.CRUD.model.Producto;
import com.registro.CRUD.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoWebController {
    @Autowired
    private ProductoRepository repository;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", repository.findAll());
        return "productos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario-producto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        repository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("producto", repository.findById(id).orElse(null));
        return "formulario-producto";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/productos";
    }
}
