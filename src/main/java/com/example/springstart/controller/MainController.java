package com.example.springstart.controller;

import com.example.springstart.domain.Message;
import com.example.springstart.repositories.MessageRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MessageRepositories messageRepositories;


    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String greet(Map<String, Object> model) {
        return "greet";
    }

    //@GetMapping("/main")
    //public String main(Map<String, Object> model){
    //    model.put("some","Hello, letsCode!");
    //    return "main";
    //}
    //main
    @GetMapping("/messages")
    public String messages(Map<String, Object> model) {
        Iterable<Message> messages = messageRepositories.findAll();
        model.put("messages", messages);
        return "messages";
    }

    @PostMapping("messages")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepositories.save(message);
        Iterable<Message> messages = messageRepositories.findAll();
        model.put("messages", messages);
        return "messages";
    }
    
    @PostMapping("filter")
    public String add(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepositories.findByTag(filter);
        } else {
            messages = messageRepositories.findAll();
        }
        model.put("messages", messages);
        return "messages";
    }
}
