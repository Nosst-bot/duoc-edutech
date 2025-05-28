package com.edutech.edutech.repository;

import com.edutech.edutech.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    Proveedor findByRut(String rut);
}
