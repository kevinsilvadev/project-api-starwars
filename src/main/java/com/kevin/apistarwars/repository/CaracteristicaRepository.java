
package com.kevin.apistarwars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.apistarwars.model.Caracteristicas;

public interface CaracteristicaRepository extends JpaRepository<Caracteristicas, Long> {
    public List<Caracteristicas> findAllByOrderByIdAsc();

}
