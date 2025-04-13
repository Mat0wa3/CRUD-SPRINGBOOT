package com.registro.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.registro.CRUD.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
