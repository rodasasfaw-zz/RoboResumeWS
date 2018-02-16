package com.roboresumews.project.Controller;

import com.roboresumews.project.Model.*;
import com.roboresumews.project.Repository.*;
import com.roboresumews.project.Security.UserRepository;
import com.roboresumews.project.Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ContactInformationRepository contactInformationRepository;
    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    ReferencesRepository referencesRepository;

    @RequestMapping("/")
    public String showindex() {
        return "index";
    }

    @RequestMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }


    @GetMapping("/addeducation")
    public String educationForm(Model model) {
        model.addAttribute("education", new Education());
        return "educationform";
    }

    @PostMapping("/processeduction")
    public String processeducationForm(@Valid @ModelAttribute("education") Education educations, BindingResult result) {
        if (result.hasErrors()) {
            return "educationform";
        }
        educationRepository.save(educations);
        return "redirect:/";

    }

    @GetMapping("/addcontactinfo")
    public String contactinfoForm(Model model) {
        model.addAttribute("contactinfo", new ContactInformation());
        return "contactinformationform";
    }

    @PostMapping("/processcontactinfo")
    public String processcontactinfoForm(@Valid @ModelAttribute("contactinfo") ContactInformation contactinfos, BindingResult result){
        if (result.hasErrors()){
            return "contactinformationform";
        }
        contactInformationRepository.save(contactinfos);
        return "redirect:/";

    }
    @GetMapping("/addexperience")
    public String experienceForm(Model model) {
        model.addAttribute("experience", new Experience());
        return "experienceform";
    }

    @PostMapping("/processexperience")
    public String processExperience(@Valid @ModelAttribute("experience") Experience experiences, BindingResult result){
        if (result.hasErrors()){
            return "experienceform";
        }
        experienceRepository.save(experiences);
        return "redirect:/";

    }
    @GetMapping("/addskills")
    public String skillsForm(Model model) {
        model.addAttribute("skills", new Skills());
        return "skillsform";
    }

    @PostMapping("/processskills")
    public String processskills(@Valid @ModelAttribute("skills") Skills skillss, BindingResult result){
        if (result.hasErrors()){
            return "skillsform";
        }
        skillsRepository.save(skillss);
        return "redirect:/";

    }
    @GetMapping("/addskills")
    public String referenceForm(Model model) {
        model.addAttribute("reference", new References());
        return "skillsform";
    }

    @PostMapping("/processskills")
    public String processsReferences(@Valid @ModelAttribute("reference") References references, BindingResult result){
        if (result.hasErrors()){
            return "referenceform";
        }
        referencesRepository.save(references);
        return "redirect:/";

    }
}

