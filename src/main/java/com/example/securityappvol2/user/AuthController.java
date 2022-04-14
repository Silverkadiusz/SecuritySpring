package com.example.securityappvol2.user;

import com.example.securityappvol2.mail.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private UserService userService;


    public AuthController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/logowanie")
    public String loginForm(@RequestParam(required = false) String error,
                            Model model) {
        boolean showErrorMessage = false;

        if (error != null) {
            showErrorMessage = true;
        }
        model.addAttribute("showErrorMessage", showErrorMessage);

        return "login";
    }

    @PostMapping("/rejestracja")
    public String register(User user) {

        String username = user.getEmail();
        String rawPassword = user.getPassword();
        userService.registerUser(username, rawPassword);

        return "redirect:/";
    }


    @GetMapping("/reset")
    public String resetForm() {
        return "resetForm";
    }

    @PostMapping("/reset")
    public String resetPasswordLinkSend(@RequestParam String email) {
        userService.sendPasswordResetLink(email);
        return "resetFormSend";
    }

    @GetMapping("/resetHasla")
    public String resetPassword(@RequestParam("klucz") String key, Model model) {
        model.addAttribute("key", key);
        return "resetFormWithKey";
    }

    @PostMapping("/resetEnding")
    public String resetPasswordLinkSend(@RequestParam String key, @RequestParam String password) {
        userService.updateUserPassword(key, password);
        return "redirect:/logowanie";
    }



}
