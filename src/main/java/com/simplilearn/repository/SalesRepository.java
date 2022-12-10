package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.SalesRecord;

@Repository
public interface SalesRepository extends CrudRepository<SalesRecord, Integer>{

}

