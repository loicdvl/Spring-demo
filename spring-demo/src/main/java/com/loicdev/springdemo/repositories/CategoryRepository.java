package com.loicdev.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loicdev.springdemo.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);
}
