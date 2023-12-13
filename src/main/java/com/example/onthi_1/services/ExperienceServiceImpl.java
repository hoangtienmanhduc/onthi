package com.example.onthi_1.services;

import com.example.onthi_1.models.Experience;
import com.example.onthi_1.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService{

    @Autowired
    private ExperienceRepository experienceRepository;
    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public void save(Experience candidate) {
        experienceRepository.save(candidate);
    }

    @Override
    public Experience findById(Long id) {
        return experienceRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }
}
