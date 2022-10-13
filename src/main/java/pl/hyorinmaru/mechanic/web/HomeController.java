package pl.hyorinmaru.mechanic.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hyorinmaru.mechanic.domain.User;
import pl.hyorinmaru.mechanic.domain.UserData;
import pl.hyorinmaru.mechanic.service.UserDataService;
import pl.hyorinmaru.mechanic.service.UserService;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final UserService userService;

    private final UserDataService userDataService;

    public HomeController(UserService userService
            , UserDataService userDataService
    ) {
        this.userService = userService;
        this.userDataService = userDataService;
    }


    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/registry")
    public String registryForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registry";
    }

    @PostMapping("/registry")
    public String registry(@Valid User user, BindingResult bindingResult, Model model) {
        if (userService.findByUserName(user.getUsername()) != null) {
            bindingResult.rejectValue("username", "error.user",
                    "User with that username already exists.");
        }
        if (userService.checkPassword(user.getPassword())) {
            bindingResult.rejectValue("password", "error.password",
                    "Password has to be between 8 and 20 characters with lowercase and uppercase letter, and digit, and special character");
        }
        if (bindingResult.hasErrors()) {
            return "registry";
        }

        UserData userData = new UserData();
        userDataService.create(userData);
        user.setUserData(userData);

        userService.saveUser(user);
        model.addAttribute("registered", true);
        return "redirect:loginForm";
    }
}
