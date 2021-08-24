
package com.kevin.apistarwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.apistarwars.model.Personagem;

public interface PersongemRepository extends JpaRepository<Personagem, Long> {

}
