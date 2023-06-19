package com.example.springboot.controller.ex_4.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.controller.ex_4.service.IngredientService;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ingredient/")
@RestController
public class IngredientController {
    private IngredientService ingredientService;
    private MealService mealService;

    @Autowired
    public IngredientController(IngredientService ingredientService, MealService mealService) {
        this.ingredientService = ingredientService;
        this.mealService = mealService;
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestParam Ingredient ingredient) {
        ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{ingredientId}")
    public ResponseEntity<Ingredient> retrieveIngredient(@PathVariable("ingredientId") long ingredientId) {

        return ResponseEntity.ok(ingredientService.getIngredient(ingredientId));
    }

    @PostMapping("{ingredientId}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable("ingredientId") long ingredientId, @RequestBody Ingredient ingredient) {
        ingredientService.updateIngredient(ingredient, ingredientId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{ingredientId}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable("ingredientId") long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
        return ResponseEntity.ok().build();
    }
}
