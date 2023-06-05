package com.example.springbootdevelhope.service;

import com.example.springbootdevelhope.dao.IngredientDao;
import com.example.springbootdevelhope.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class IngredientService  {
    private IngredientDao ingredientDao;
    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
    public void addIngredient(Ingredient dumpling) {
        ingredientDao.save(dumpling);
    }
    
    public void removeIngredient(Ingredient ingredient){ ingredientDao.delete(ingredient); }
    
    public void removeById(Long id){ ingredientDao.deleteById(id);}
    
    public void replaceItem(Ingredient ingredient, Long id){
        removeById(id);
        addIngredient(ingredient);
    }
    
    public Ingredient getIngredient(Long id){
        return ingredientDao.findById(id).orElse(null);
    }
}

