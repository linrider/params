package ua.vladyslav.params.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class ParamController {
    @GetMapping()
    public String getUserInfo(@RequestParam(name = "name", required = false, defaultValue = "anonime") String name,
            @RequestParam("age") int age) {
        System.out.println(String.format("Hello %s, %d", name, age));
        return "empty";

    }

    @GetMapping("/{age}")
    public String getUserInfo1(@RequestParam(name = "name", required = false, defaultValue = "anonime") String name,
            @PathVariable("age") int age) {
        System.out.println(String.format("Hello %s, %d", name, age));
        return "empty";
    }

    /*
     * Зробити калькулятор він приймає паз веріеблом action(plus,minus,mnozh,dilen),
     * а також два реквест параметри a та b і виконує цю операцію над ними і
     * результат виводить в консоль.
     * ВИкористовувати switch case
     */

    @GetMapping("/calc/{action}/{arg1}/{arg2}")
    public String getCalculator(
            @PathVariable(name = "arg1") float arg1,
            @PathVariable(name = "arg2") float arg2,
            @PathVariable(name = "action") String action) {
        System.out.println(switch (action) {
            case "plus" -> arg1 + arg2;
            case "minus" -> arg1 - arg2;
            case "multiply" -> arg1 * arg2;
            case "divide" -> arg1 / arg2;
            default -> "Something went wrong";
        });
        return "empty";
    }

    /*
     * Зробити обмін валют кажем з якої валюти в яку міняєм і суму передаєм яку
     * міняєм
     * (долар злоті гривні) валюта 1 і валюта 2 реквкст параметри, сума це
     * pathvariable
     */

    @GetMapping("/exchange/{amount}/currency")
    public String getCurrencyExchange(
            @RequestParam(name = "currency1") String currency1,
            @RequestParam(name = "currency2") String currency2,
            @PathVariable(name = "amount") int amount) {

        final Map<String, Double> exchangRates = new HashMap<>();
        exchangRates.put("UAH_TO_USD", .0272);
        exchangRates.put("UAH_TO_PLN", .0971);
        exchangRates.put("PLN_TO_USD", .2508);
        exchangRates.put("PLN_TO_UAH", 10.4084);
        exchangRates.put("USD_TO_PLN", 4.41);
        exchangRates.put("USD_TO_UAH", 41.4068);

        StringBuilder stringBuilder = new StringBuilder(9);
        stringBuilder.append(currency1.toUpperCase());
        stringBuilder.append("_TO_");
        stringBuilder.append(currency2.toUpperCase());

        System.out.println(amount * exchangRates.get(stringBuilder.toString()));

        return "empty";
    }

}
