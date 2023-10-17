package com.example.Main.StatesServices;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Main.DataAccess.StatesRepository;
import com.example.Main.Entities.States;

@Component
public class StatesService {
	@Autowired
	private StatesRepository staterepository;
	
	public void addState(States state) {
		this.staterepository.save(state);
	}
	
	public List<States> findAll(){
		return (List<States>) this.staterepository.findAll();
	}
	
}
