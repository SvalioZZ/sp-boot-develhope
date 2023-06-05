package com.example.springbootdevelhope.dao;

import com.example.springbootdevelhope.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient, Long>{
}
