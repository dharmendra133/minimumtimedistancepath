package com.example.Main.DataAccess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.Main.Entities.States;

@Component
public interface StatesRepository extends CrudRepository<States, Integer>{
	public States findByid(int id);
}
