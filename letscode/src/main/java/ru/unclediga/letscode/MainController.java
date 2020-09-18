package ru.unclediga.letscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.unclediga.letscode.domain.User;
import ru.unclediga.letscode.repo.UserRepository;

@Controller
@RequestMapping("/demo")
public class MainController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/add")
    public @ResponseBody String addNewUser(@RequestParam String name,
                             @RequestParam String email) {
        final User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
