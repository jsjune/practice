package com.example.itemservice.controller.req;

public record RequestItem(
	String username,
	String title,
	String content,
	int price
) {
}
