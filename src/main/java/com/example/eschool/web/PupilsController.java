package com.example.eschool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.eschool.model.Pupil;
import com.example.eschool.service.PupilService;
import com.example.eschool.validator.PupilValidator;

@Controller
public class PupilsController {
	
    @Autowired
    private PupilValidator pupilValidator;

	@Autowired
	private PupilService pupilService;

	@RequestMapping(value = {"/", "/pupils"}, method = RequestMethod.GET)
    public String main_page(Model model) {    	
    	List<Pupil> pupils = pupilService.findAll(); 
    	
    	model.addAttribute("pupil_list", pupils);
    	model.addAttribute("pupilForm", new Pupil());
    	
        return "pupils";
    }
    
    @RequestMapping(value = "/pupils", method = RequestMethod.POST)
    public String addPupil(@ModelAttribute("pupilForm") Pupil pupilForm, BindingResult bindingResult, Model model) {
    	pupilValidator.validate(pupilForm, bindingResult);

        if (bindingResult.hasErrors()) {
        	model.addAttribute("error", true);
            return "pupils";
        }

        pupilService.create(pupilForm);

        return "redirect:/pupils";
    }
    
    @RequestMapping(value = "/pupils/{id}", method = RequestMethod.DELETE)
    public String deletePupil(@PathVariable Long id , Model model) {
        pupilService.deleteById(id);

        return "redirect:/pupils";
    }
}
