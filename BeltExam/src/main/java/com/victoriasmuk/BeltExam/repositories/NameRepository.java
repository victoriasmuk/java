package com.victoriasmuk.BeltExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.victoriasmuk.BeltExam.models.Name;

@Repository
public interface NameRepository extends CrudRepository<Name,Long> {
	List<Name> findAll();
	Name findByBabyName(String babyName);
}