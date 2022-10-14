package pl.hyorinmaru.mechanic.web;

import lombok.extern.java.Log;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.hyorinmaru.mechanic.domain.Car;
import pl.hyorinmaru.mechanic.domain.User;
import pl.hyorinmaru.mechanic.domain.UserData;
import pl.hyorinmaru.mechanic.service.CarService;
import pl.hyorinmaru.mechanic.service.UserDataService;
import pl.hyorinmaru.mechanic.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("DBUser")
public class UserController {

    private final UserService userService;
    private final UserDataService userDataService;
    private final CarService carService;

    public UserController(UserService userService, UserDataService userDataService, CarService carService) {
        this.userService = userService;
        this.userDataService = userDataService;
        this.carService = carService;
    }
    @RequestMapping("/forward")
    public String forward(@AuthenticationPrincipal UserDetails userDetails, Model model){
        User user = userService.findByUserName(userDetails.getUsername());
        model.addAttribute("DBUser", user);
        return "redirect:/user/main";
    }

    @RequestMapping("/main")
    public String main(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUserName(userDetails.getUsername());
        List<Car> cars = carService.readByOwner(userService.findByUserName(user.getUsername()));
        if (cars.size() != 0) {
            model.addAttribute("carList", cars);
        }
        return "/user/main";
    }

    @GetMapping("/settings")
    public String settingsForm(HttpSession session, Model model) {
        UserData userData = ((User) session.getAttribute("DBUser")).getUserData();
        model.addAttribute("userData", userData);
        return "/user/settings";
    }

    @PostMapping("/settings")
    public String settings(@ModelAttribute UserData userData, BindingResult bindingResult,
                           Model model, @AuthenticationPrincipal UserDetails userDetails) {
        UserData byUserEmail = userDataService.readByEmail(userData.getEmail());
        if ((byUserEmail != null) && (!byUserEmail.getId().equals(userData.getId()))) {
            bindingResult.rejectValue("email", "error.email",
                    "User with that email address already exist, contact us to resolve this problem");
        }
        if (userData.getPhoneNumber().matches("\\d{9}")) {
            bindingResult.rejectValue("phoneNumber", "error.phoneNumber",
                    "Please remember that the phone number contains 9 digits.");
        }
        if (bindingResult.hasErrors()) {
            return "/user/settings";
        }
        User user = userService.findByUserName(userDetails.getUsername());
        user.setUserData(userData);
        model.addAttribute("DBUser", user);
        userDataService.update(userData);
        return "/user/settings";
    }


}
