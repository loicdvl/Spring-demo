package com.loicdev.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loicdev.springdemo.domain.Category;
import org.springframework.data.repository.history.RevisionRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer>, RevisionRepository<Category, Integer, Integer> {

	Category findByName(String name);
}
