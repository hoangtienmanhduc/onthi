package com.example.onthi_1.services;

import com.example.onthi_1.models.Candidate;

import java.util.List;

public interface CandidateService {
    public List<Candidate> findAll();
    public void save(Candidate candidate);
    public Candidate findById(Long id);
    public void delete(Long id);

}
