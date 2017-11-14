package com.example.eschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eschool.mapper.PupilsMapper;
import com.example.eschool.model.Pupil;

@Service
public class PupilServiceImpl implements PupilService {
	
	@Autowired
	private PupilsMapper pupilsMapper;
	
	@Override
	public List<Pupil> findAll() {
		return this.pupilsMapper.findAll();
	}

	@Override
	public void create(Pupil pupil) {
		this.pupilsMapper.insert(pupil);
	}

	@Override
	public void deleteById(Long id) {
		//this.pupilsMapper.delete(id);		
	}
	
}
