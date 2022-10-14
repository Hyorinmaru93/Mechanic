package pl.hyorinmaru.mechanic.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.hyorinmaru.mechanic.domain.Car;
import pl.hyorinmaru.mechanic.service.CarService;
import pl.hyorinmaru.mechanic.service.UserService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user/car")
public class CarController {

    private final CarService carService;

    private final UserService userService;

    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping("/brand")
    public String brand(Model model) {
        List<String> brands = Arrays.asList("Mercedes", "Audi", "BMW");
        model.addAttribute("car", new Car());
        model.addAttribute("brands", brands);
        return "/user/brand";
    }

    @PostMapping("/model")
    public String model(@ModelAttribute Car car, Model model) {
        List<String> models;
        switch (car.getBrand()) {
            case "Mercedes" -> {
                models = Arrays.asList("CL", "CLS", "EQV");
            }
            case "BMW" -> {
                models = Arrays.asList("M2", "X5", "Z4");
            }
            case "Audi" -> {
                models = Arrays.asList("A4", "A5", "A6");
            }
            default -> {
                return "redirect:error";
            }
        }
        model.addAttribute("car", car);
        model.addAttribute("models", models);
        return "/user/model";
    }

    @PostMapping("/category")
    public String category(@ModelAttribute Car car, Model model) {
        List<String> categories = Arrays.asList("SUV", "Coupe", "Sedan", "Wagon");
        model.addAttribute("car", car);
        model.addAttribute("categories", categories);
        return "/user/categories";
    }

    @PostMapping("/year")
    public String productionYear(@ModelAttribute Car car, Model model) {
        model.addAttribute("car", car);
        return "/user/year";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Car car) {
        car.setCustomName(car.getBrand() + " " + car.getModel() + " " + car.getProductionDate());
        carService.create(car);
        return "redirect:/user/main";
    }
}
