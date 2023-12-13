package com.example.onthi_1.services;

import com.example.onthi_1.models.Candidate;
import com.example.onthi_1.models.Experience;

import java.util.List;

public interface ExperienceService {
    public List<Experience> findAll();
    public void save(Experience candidate);
    public Experience findById(Long id);
    public void delete(Long id);
}
