package com.example.Main.DataAccess;

import org.springframework.data.repository.CrudRepository;

import com.example.Main.Entities.States;

public interface ApiRepository extends CrudRepository<States, Integer> {

}
