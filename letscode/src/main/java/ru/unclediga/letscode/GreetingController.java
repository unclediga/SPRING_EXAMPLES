package ru.unclediga.letscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.unclediga.letscode.domain.Message;
import ru.unclediga.letscode.repo.MessageRepo;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting2(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                            Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/letscode")
    public String main(Map<String, Object> model) {
        final Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/letscode")
    public String add(@RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> model) {

        final Message message = new Message(text, tag);
        messageRepo.save(message);
        final Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        final Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "main";
    }
}
