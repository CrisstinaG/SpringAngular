package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;



@Controller
public class ViewController {

    @Autowired
    private UserRepository repository;
    

    @GetMapping("/")
    public String angular() {
        return "index.html";
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting.html";
    }

    @GetMapping("/users")
    public String users(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("myClass", "card-title");
        model.addAttribute("users", repository.findAll());
        return "users.html";
    }

    @GetMapping("/new_user_form")
    public String users(Model model) {
        model.addAttribute("user", new User());
        return "newuserform.html";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
			return "redirect:/new_user_form";
		}
        repository.save(user);
        return "redirect:/users";
    }

}
