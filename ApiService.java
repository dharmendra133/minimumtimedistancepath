package com.example.Main.StatesServices;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Main.DataAccess.ApiRepository;
import com.example.Main.Entities.States;

public class ApiService {
	@Autowired
	private ApiRepository apirepository;
	
	public List<States> findAll(){
		return (List<States>) this.apirepository.findAll();
	}
	
	public void addstate(States data) {
		this.apirepository.save(data);
	}

}
