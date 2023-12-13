package com.example.onthi_1.controllers;

import com.example.onthi_1.models.Candidate;
import com.example.onthi_1.models.Experience;
import com.example.onthi_1.services.CandidateService;
import com.example.onthi_1.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExperienceController {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private ExperienceService experienceService;

    @RequestMapping("/listexperience")
    public String viewHomePageExperience(Model model) {
        List<Experience> experiences = experienceService.findAll();
        List<Candidate> candidates = candidateService.findAll();
        model.addAttribute("listExperiences", experiences);
        model.addAttribute("listCandidates", candidates);
        return "list_experience";
    }

    @RequestMapping("/newExperience")
    public String showNewExperienceForm(Model model) {
        Experience experience = new Experience();
        List<Candidate> candidates = candidateService.findAll();
        model.addAttribute("experience", experience);
        model.addAttribute("listCandidates", candidates);
        return "new_experience";
    }

    @PostMapping(value = "/saveExperience")
    public String saveExperience(@ModelAttribute("experience") Experience experience) {
        experienceService.save(experience);
        return "redirect:/listexperience";
    }

    @RequestMapping("/editExperience/{id}")
    public ModelAndView showEditExperienceForm(@PathVariable(name = "id") Long id) {
        ModelAndView mv = new ModelAndView("edit_experience");
        Experience experience = experienceService.findById(id);
        mv.addObject("experience", experience);
        return mv;
    }
    @RequestMapping("/deleteExperience/{id}")
    public String deleteExperience(@PathVariable(name = "id") Long id) {
        experienceService.delete(id);
        return "redirect:/listexperience";
    }

}
