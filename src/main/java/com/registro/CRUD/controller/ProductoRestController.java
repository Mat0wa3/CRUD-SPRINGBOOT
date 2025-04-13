package com.registro.CRUD.controller;

import com.registro.CRUD.model.Producto;
import com.registro.CRUD.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoRestController {

    @Autowired
    private ProductoRepository repository;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        return repository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoActualizado.getNombre());
                    producto.setPrecio(productoActualizado.getPrecio());
                    return repository.save(producto);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
