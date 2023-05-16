package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class CalculatorController {
    @GetMapping("/calculate")
    public String getValue(@RequestParam (name = "a") String vacationStartStr,
                           @RequestParam (name = "b") String vacationEndStr,
                           @RequestParam (name = "c") float salary){
        return VacationPayCalculation.calculation(vacationStartStr, vacationEndStr, salary);
    }
}
