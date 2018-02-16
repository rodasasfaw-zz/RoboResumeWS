package com.roboresumews.project.Controller;

import com.roboresumews.project.Model.*;
import com.roboresumews.project.Repository.*;
import com.roboresumews.project.Security.UserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String processExperience(@Valid @ModelAttribute("experience") Experience experiences, Model model,BindingResult result){
        if (result.hasErrors()){
            return "experienceform";
        }
        experienceRepository.save(experiences);
        model.addAttribute("experience", experienceRepository.findAll());
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
    @GetMapping("/addreference")
    public String referenceForm(Model model) {
        model.addAttribute("reference", new References());
        return "referenceform";
    }

    @PostMapping("/processsreference")
    public String processsReferences(@Valid @ModelAttribute("reference") References references, BindingResult result){
        if (result.hasErrors()){
            return "referenceform";
        }
        referencesRepository.save(references);
        return "redirect:/";

    }
    @RequestMapping("/completeresume")
    public String showComplete(Model model){
        model.addAttribute("contactinfos", contactInformationRepository.findAll());
        model.addAttribute("educations", educationRepository.findAll());
        model.addAttribute("experiences",experienceRepository.findAll());
        model.addAttribute("skillss",skillsRepository.findAll());
        model.addAttribute("references",referencesRepository.findAll());

        return "completeresume";
    }
    @RequestMapping("/showcover")
    public String showCover(){

        return "coverletter";
    }
    @RequestMapping("/updatecontact/{id}")
    public String updatecontact(@PathVariable("id") long id, Model model){
        model.addAttribute("contactinfos", contactInformationRepository.findOne(id));
        return "redirect:/addcontactinfo";

    }
    @RequestMapping("/updateeducation/{id}")
    public String updateeducation(@PathVariable("id") long id, Model model){
        model.addAttribute("educations", educationRepository.findOne(id));
        return "redirect:/addeducation";

    }
    @RequestMapping("/updateexperience/{id}")
    public String updateExperience(@PathVariable("id") long id, Model model){
        model.addAttribute("experiences", experienceRepository.findOne(id));
        return "redirect:/addexperience";

    }
    @RequestMapping("/updateskill/{id}")
    public String updateskill(@PathVariable("id") long id, Model model){
        model.addAttribute("skillss", skillsRepository.findOne(id));
        return "redirect:/addskills";

    }
    @RequestMapping("/updatereference/{id}")
    public String update(@PathVariable("id") long id, Model model){
        model.addAttribute("references", referencesRepository.findOne(id));
        return "redirect:/addreference";

    }
//    @GetMapping("/register")
//    public String showRegistrationPage(Model model){
//        model.addAttribute("user",new User());
//        return "registration";
//    }
//
//    @PostMapping("/register")
//    public String processregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){
//
//        model.addAttribute("user",user);
//        if(result.hasErrors()){
//            return "registration";
//        }else{
//            userService.saveUser(user);
//            model.addAttribute("message","User Account Successfully Created");
//        }
//        return "index";
//    }
//    @RequestMapping("/delete/{id}")
//    public String delBook(@PathVariable("id") long id){
//        bookRepository.delete(id);
//        return"redirect:/showbooklist";
//    }

}

