package ru.unclediga.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller  // This means that this class is a Controller
@RequestMapping(path = "/demo")  // This means URL's start with /demo (after Application path)
public class MainController {
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}