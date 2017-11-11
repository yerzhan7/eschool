package com.example.eschool.service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eschool.model.Pupil;
import com.example.eschool.repository.PupilRepository;

@Service
public class PupilServiceImpl implements PupilService {
	
	@Autowired
	private PupilRepository pupilRepository;
	
	@Override
	public List<Pupil> findAll() {
		return this.pupilRepository.findAll();
	}

	@Override
	public Pupil create(Pupil pupil) {
		return this.pupilRepository.save(pupil);
	}

	@Override
	public void deleteById(Long id) {
		this.pupilRepository.delete(id);		
	}
	
	
}
