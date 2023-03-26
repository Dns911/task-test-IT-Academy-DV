package com.itacademy.tasktest.controller;

import com.itacademy.tasktest.entity.User;
import com.itacademy.tasktest.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class UsersController {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/new")
    public String newUser(Model model) {
        return "/users/new";
    }

    @GetMapping("/users/list")
    public String list(@RequestParam(value = "index", defaultValue = "0") Integer index, Model model) {
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(userList::add);
        userList.sort(Comparator.comparing(User::getEmail));
        int size = userList.size();
        int page = size / 10;
        int startIndex = 0;
        int finishIndex;
        if (page != 0) {
            if (index <= page) {
                startIndex += 10 * index;
                finishIndex = startIndex + 9;
                if (finishIndex >= size) {
                    finishIndex = size - 1;
                } else {
                    index++;
                    model.addAttribute("index", index);
                }
                userList = userList.subList(startIndex, finishIndex);
                model.addAttribute("users", userList);
            }
        } else {
            model.addAttribute("users", userList);
        }
        return "/users/list";
    }

    @PostMapping("/users/new")
    public String addUser(
            @RequestParam String userName,
            @RequestParam String userLastname,
            @RequestParam String userFatherName,
            @RequestParam String userEmail,
            @RequestParam String userRole,
            Model model) {
        User.Role role = User.Role.find(userRole);
        User user = new User(userName, userLastname, userFatherName, userEmail, role);
        model.addAttribute("title", "User was added success!");
        userRepository.save(user);
        return new RedirectView("home").getUrl();
    }
}
