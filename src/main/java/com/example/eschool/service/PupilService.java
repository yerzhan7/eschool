package com.example.eschool.service;

import java.util.List;

import com.example.eschool.model.Pupil;

public interface PupilService {
	List<Pupil> findAll();
	void create(Pupil pupil);
	void deleteById(Long id);
}
