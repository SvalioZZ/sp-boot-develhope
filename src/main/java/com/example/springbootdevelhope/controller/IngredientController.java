package com.example.springbootdevelhope.controller;

import com.example.springbootdevelhope.model.Ingredient;
import com.example.springbootdevelhope.model.Meal;
import com.example.springbootdevelhope.service.IngredientService;
import com.example.springbootdevelhope.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    private IngredientService ingredientService;
    private MealService mealService;
    
    @Autowired
    public IngredientController(IngredientService ingredientService, MealService mealService) {
        this.ingredientService = ingredientService;
        this.mealService = mealService;
    }
    
    @PostMapping("/add-ingredient")
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok("Ingredient Added!");
        
    }
    
    @PutMapping("/update-ingredient/{id}")
    public ResponseEntity<String> updateIngredient(@PathVariable long id, @RequestBody Ingredient ingredient){
        ingredientService.replaceItem(ingredient, id);
        return ResponseEntity.ok("Ingredient Updated!");
    }
    
    @DeleteMapping("/delete-ingredient")
    public ResponseEntity<String> deleteIngredient(@RequestParam long id){
        ingredientService.removeById(id);
        return ResponseEntity.ok("Ingredient Deleted!");
    }
    
    @GetMapping("/get-ingredient")
    public ResponseEntity<Ingredient> getIngredient(@RequestParam long id){
        Ingredient ingredient = ingredientService.getIngredient(id);
        return ResponseEntity.ok(ingredient);
    }
    
}
