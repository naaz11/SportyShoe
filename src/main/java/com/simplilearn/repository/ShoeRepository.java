package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Shoe;


@Repository
public interface ShoeRepository extends CrudRepository<Shoe, Integer>{

}

