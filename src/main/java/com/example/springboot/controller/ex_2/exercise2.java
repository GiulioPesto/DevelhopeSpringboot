package com.example.springboot.controller.ex_2;

import com.example.springboot.model.Meal;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class exercise2 {

    private List<Meal> list = Arrays.asList(
            new Meal("Rare Florentine", "A fiorentì", 10.99, false),
            new Meal("Wagyu", "Uagliò", 30, false),
            new Meal("Kangaroo Sausage", "A sasicc ro cangur", 40, false));

    @GetMapping("/list/{listIndex}")
    public ResponseEntity<Meal> mealList(@PathVariable("listIndex") int listIndex) {
        return ResponseEntity.ok(list.get(listIndex));
    }

    @GetMapping("/meal/{name}")
    public Meal getMealByName(@PathVariable("name") String name) {
        for (Meal meal : list) {
            if (meal.getName().equals(name)){
                return meal;
            }
        }
        return null;
    }
    @GetMapping("/meal/description-match/{phrase}")
    public Meal getMealByDesc(@PathVariable("phrase") String description) {
        for (Meal meal : list){
            if (meal.getDescription().equalsIgnoreCase(description)){
                return meal;
            }
        }
        return null;
    }
    @GetMapping("/meal/price")
    public List<Meal> range(@RequestParam() int min, @RequestParam() int max) {
        List<Meal> mealMinMax = new ArrayList<>();
        for (Meal m : list) {
            if (m.getPrice() >= min && m.getPrice() <= max) {
                mealMinMax.add(m);
            }
        }
        if(!mealMinMax.isEmpty()) {
            return ResponseEntity.ok(mealMinMax).getBody();
        } else {
            return null;
        }
    }

}