package ua.vladyslav.params.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/request")
public class ParamController {
    @GetMapping()
    public String getUserInfo(@RequestParam(name = "name", required = false, defaultValue = "anonime") String name, @RequestParam("age") int age) {
        System.out.println(String.format("Hello %s, %d", name, age));
        return "Main";

    }@GetMapping("/{age}")
    public String getUserInfo1(@RequestParam(name = "name", required = false, defaultValue = "anonime") String name, @PathVariable("age") int age) {
        System.out.println(String.format("Hello %s, %d", name, age));
        return "Main";
    }

    /*Зробити калькулятор він приймає паз веріеблом action(plus,minus,mnozh,dilen), 
    а також два реквест параметри a та b і виконує цю операцію над ними і результат виводить в консоль.
    ВИкористовувати switch case */
    
    @GetMapping("/calc/{action}/{arg1}/{arg2}")
    public String getCalculator(@PathVariable(name = "arg1") float arg1, 
                                @PathVariable(name = "arg2") float arg2, 
                                @PathVariable(name = "action") String action) {
            System.out.println(switch(action) {
                case "plus" -> arg1 + arg2;
                case "minus" -> arg1 - arg2;
                case "multiply" -> arg1 * arg2;
                case "divide" -> arg1 / arg2;
                default -> "Something went wrong";
            });
        return "Main";
    }

    /*
     * Зробити обмін валют кажем з якої валюти в яку міняєм і суму передаєм яку міняєм 
     * (долар злоті гривні) вальта 1 і валюта 2  реквкст параметри, сума це pathvariable
     */

     @GetMapping("/exchange")
     public String getCurrencyExchange(@RequestParam String param) {
         return new String();
     }
     
    
}
