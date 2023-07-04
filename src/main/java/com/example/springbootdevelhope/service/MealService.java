package com.example.springbootdevelhope.service;

import com.example.springbootdevelhope.dao.MealDao;
import com.example.springbootdevelhope.model.Meal;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;
    private Double MIN_WINTER_TEMP = 12.0;
    
    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }
    
    public void addMeal(Meal meal) {
        mealDao.save(meal);
    }
    
    public List<Meal> getMeals() {
        return mealDao.findAll();
    }
    
    public void deleteMeal(long id) {
        mealDao.deleteById(id);
    }
    
    public void updateMeal(Meal meal) {
        mealDao.save(meal);
    }
    
    public List<Meal> getWinterMeals() {
        Double currentTemperatureInCentigrade = getCurrentTemperatureInCentigrade();
        
        if (currentTemperatureInCentigrade > MIN_WINTER_TEMP) return new ArrayList<>();
        
        return mealDao.findByIsWinterMeal(true);
    }
    
    private Double getCurrentTemperatureInCentigrade() {
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=16.00&longitude=30.0&current_weather=true")
                                          .asJson().getBody().getObject();
            
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
