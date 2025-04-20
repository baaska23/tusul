package com.example.mdbspringboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mdbspringboot.model.Report;

public interface ReportRepository extends MongoRepository<Report, String> {
	
	@Query("{name:'?0'}")
    Report findItemByName(String name);
	
	@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<Report> findAll(String category);
	
	public long count();

}
