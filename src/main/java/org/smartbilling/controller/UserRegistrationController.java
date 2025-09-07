package org.smartbilling.controller;

import jakarta.validation.Valid;
import org.smartbilling.web.UserRegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/userform")
public class UserRegistrationController {


    @GetMapping("/register")
    String showForm(Model model) {
        model.addAttribute("form", new UserRegistrationForm());
        return "register"; // renders templates/register.html
    }

    @PostMapping("/register")
    String submit(@Valid @ModelAttribute("form") UserRegistrationForm form,
                  BindingResult result,
                  RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "register"; // redisplay with errors
        }

        // TODO: persist or call service
        ra.addFlashAttribute("msg", "Registered: " + form.getName());
        return "redirect:/success"; // Post/Redirect/Get
    }

    @GetMapping("/success")
    String success() {
        return "success"; // renders templates/success.html
    }


}
