package kgsu.web.Study_SpringBoot.Controllers;

import kgsu.web.Study_SpringBoot.Models.Message;
import kgsu.web.Study_SpringBoot.Models.User;
import kgsu.web.Study_SpringBoot.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepository messageRepository;



    @GetMapping("/greeting")
    public String greeting(@AuthenticationPrincipal User user,
                           @RequestParam(name="name", required=false, defaultValue="World") String name,
                           Model model)
    {
        //model.addAttribute("name", name);
        model.addAttribute("messages", messageRepository.findAll());
        model.addAttribute("name", user.getUsername());
        
        return "greeting";
    }

    @PostMapping("/addMessage")
    public String addMessage(@AuthenticationPrincipal User user, @RequestParam String text,
                             @RequestParam String tag, Model model)
    {
        Message message = new Message(text, tag, user);

        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "greeting";
    }
}