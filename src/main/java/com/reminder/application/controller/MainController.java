package com.reminder.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reminder.application.model.Employee;
import com.reminder.application.model.User;
import com.reminder.application.service.EmployeeService;
import com.reminder.application.service.SecurityService;
import com.reminder.application.service.UserService;
import com.reminder.application.validator.EmployeeValidator;
import com.reminder.application.validator.UserValidator;

@Controller
public class MainController {
	
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private EmployeeValidator employeeValidator;

    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
   
    
    /* Employee controller */
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String employee(@ModelAttribute("employeeForm") Employee employeeForm, BindingResult bindingResult, Model model) {
    	
    	employeeValidator.validate(employeeForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "welcome";
        }

        employeeService.save(employeeForm);
        return "redirect:/welcome";
    }
}
