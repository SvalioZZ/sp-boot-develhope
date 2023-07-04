package com.example.springbootdevelhope.controller;

import com.example.springbootdevelhope.model.Meal;
import com.example.springbootdevelhope.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {
    private MealService mealService;
    
    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }
    
    @PutMapping("/add")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        mealService.addMeal(meal);
        return ResponseEntity.ok(meal);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/update")
    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok(meal);
    }
    
    @GetMapping("/summer-meals")
    public ResponseEntity<List<Meal>> getWinterMeals() {
        return ResponseEntity.ok(mealService.getWinterMeals());
    }
    
    @GetMapping("/secret-formula")
    public ResponseEntity<String> getSecretFormula() {
        return ResponseEntity.ok("2 + 2 = 4");
    }
    
}

