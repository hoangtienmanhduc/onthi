package com.example.onthi_1.services;

import com.example.onthi_1.models.Candidate;
import com.example.onthi_1.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository candidateRepository;
    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public Candidate findById(Long id) {
        return candidateRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        candidateRepository.deleteById(id);
    }
}
