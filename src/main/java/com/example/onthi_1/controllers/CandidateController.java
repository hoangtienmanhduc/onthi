package com.example.onthi_1.controllers;

import com.example.onthi_1.models.Candidate;
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
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/")
    public ModelAndView viewHomePage(Model model) {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("/listcandidate")
    public String viewHomePageCandidate(Model model) {
        List<Candidate> candidates = candidateService.findAll();
        model.addAttribute("listCandidates", candidates);
        return "list_candidate";
    }

    @RequestMapping("/new")
    public String showNewCandidateForm(Model model) {
        Candidate candidate = new Candidate();
        model.addAttribute("candidate", candidate);
        return "new_candidate";
    }

    @PostMapping(value = "/save")
    public String saveCandidate(@ModelAttribute("candidate") Candidate candidate) {
        candidateService.save(candidate);
        return "redirect:/listcandidate";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCandidateForm(@PathVariable(name = "id") Long id) {
        ModelAndView mv = new ModelAndView("edit_candidate");
        Candidate candidate = candidateService.findById(id);
        mv.addObject("candidate", candidate);
        return mv;
    }
    @RequestMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable(name = "id") Long id) {
        candidateService.delete(id);
        return "redirect:/listcandidate";
    }



}
