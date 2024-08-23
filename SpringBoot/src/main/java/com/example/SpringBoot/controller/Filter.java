package com.example.SpringBoot.controller;
import com.example.SpringBoot.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
public class Filter {
    private List<User> users = new ArrayList<>();
    public Filter() {
        users.add(new User("Alice", 25, "NewYork"));
        users.add(new User("Bob", 30, "LosAngeles"));
        users.add(new User("Charlie", 25, "NewYork"));
        users.add(new User("David", 35, "Chicago"));
        users.add(new User("Eve", 25, "SanFrancisco"));
    }

    @GetMapping("/filter")
    public List<User> filterUsers (@RequestParam Integer age,
                                  @RequestParam(required = false) String city) {
        return users.stream()
                .filter(user -> (age == null || user.getAge() == age) &&
                        (city == null || user.getCity().equalsIgnoreCase(city)))
                .collect(Collectors.toList());
    }
}