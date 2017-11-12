package com.example.eschool.web;

import com.example.eschool.model.Pupil;
import com.example.eschool.model.User;
import com.example.eschool.service.PupilService;
import com.example.eschool.service.SecurityService;
import com.example.eschool.service.UserService;
import com.example.eschool.validator.UserValidator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

	@Autowired
	private PupilService pupilService;
	
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
            model.addAttribute("error", "Неверный логин или пароль.");

        if (logout != null)
            model.addAttribute("message", "Вы успешно вышли из системы.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	Pupil dummyPupil = new Pupil(1L, "Смиронов","Юрий");
    	Pupil dummyPupil2 = new Pupil(2L, "Антон","uche124nik");
    	pupilService.create(dummyPupil);
    	pupilService.create(dummyPupil2);
    	
    	List<Pupil> pupils = pupilService.findAll(); 	
    	// testing pupils TODO: delete

    	model.addAttribute("pupils", pupils);
        return "welcome";
    }
}
