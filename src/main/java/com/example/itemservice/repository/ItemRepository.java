package com.example.itemservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itemservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findAllByOrderByIdDesc();
}
