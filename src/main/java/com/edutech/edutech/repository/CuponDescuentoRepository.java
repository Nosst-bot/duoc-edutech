package com.edutech.edutech.repository;

import com.edutech.edutech.model.CuponDescuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuponDescuentoRepository extends JpaRepository<CuponDescuento, String> {
}
