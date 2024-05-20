package com.example.itemservice.entity;

import com.example.itemservice.controller.req.RequestItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private int price;
	private String username;

	@Builder
	public Item(String title, String content, int price, String username) {
		this.title = title;
		this.content = content;
		this.price = price;
		this.username = username;
	}

	public void update(RequestItem request) {
		this.title = request.title();
		this.content = request.content();
		this.price = request.price();
		this.username = request.username();
	}
}
