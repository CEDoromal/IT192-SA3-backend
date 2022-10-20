package com.rijai.LocationApi.controller;

import com.rijai.LocationApi.model.Dog;
import com.rijai.LocationApi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;

    @RequestMapping("/dogs")
    public List<Dog> getAllDog()
    {
        return dogService.getAllDogs();
    }

    @RequestMapping(value="/dogs/{id}")
    public Dog getDog(@PathVariable int id)
    {
        return dogService.getDog(id);
    }

    @RequestMapping(value="/add-dog", method= RequestMethod.POST)
    public Dog addDog(@RequestBody Dog dog)
    {
        return dogService.addDog(dog);
    }

    @RequestMapping(value="/update-dog", method=RequestMethod.PUT)
    public Dog updateDog(@RequestBody Dog dog)
    {
        return dogService.updateDog(dog);
    }
    @RequestMapping(value="/remove-dog/{id}", method=RequestMethod.DELETE)
    public void deleteDog(@PathVariable int id)
    {
        dogService.deleteDog(id);
    }
}
