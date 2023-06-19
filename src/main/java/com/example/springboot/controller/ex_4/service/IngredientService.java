package com.example.springboot.controller.ex_4.service;

import com.example.springboot.controller.ex_4.dao.IngredientDao;
import com.example.springboot.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService  {
    private IngredientDao ingredientDao;

    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void createIngredient(Ingredient ingredient) {
        ingredientDao.save(ingredient);
    }

    public Ingredient getIngredient(long ingredientId) { return ingredientDao.findById(ingredientId).orElse(null);}

    public void updateIngredient(Ingredient ingredient, long ingredientId) {
        ingredientDao.deleteById(ingredientId);
        ingredientDao.save(ingredient);
    }

    public void deleteIngredient(long ingredientId) {
        ingredientDao.deleteById(ingredientId);
    }
}
