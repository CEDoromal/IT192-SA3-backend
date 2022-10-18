package com.rijai.LocationApi.controller;

import com.rijai.LocationApi.model.Country;
import com.rijai.LocationApi.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private ICountryService countryService;

    @GetMapping("/countries")
    public String findCountries(Model model){
        var countries= (List<Country>) countryService.findAll();
        model.addAttribute("countries",countries);
        return "showCountries";
    }

    @GetMapping("/add-country")
    public String addCountry(Model model){
        model.addAttribute("add country",new Country());
        return "addCountry";
    }

    @PostMapping("/add-country")
    public String addCountrySubmit(@ModelAttribute Country country, Model model) {
        model.addAttribute("country", country);
        countryService.addCountry(country);
        var countries= (List<Country>) countryService.findAll();
        model.addAttribute("countries",countries);
        return "showCountries";
    }

    @GetMapping("/update-country/{id}")
    public ModelAndView updateCountrySubmit(@PathVariable long id) {
        Country country = countryService.getCountry(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(country);

        // Template file name
        mv.setViewName("updateCountry");
        return mv;
    }

    @GetMapping("/show-country/{id}")
    public ModelAndView showCountrySubmit(@PathVariable long id) {
        Country country = countryService.getCountry(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject(country);

        // Template file name
        mv.setViewName("showCountry");
        return mv;
    }
}
