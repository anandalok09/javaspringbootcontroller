package com.example.demo.configrationp;

import org.springframework.batch.item.ItemProcessor;

import com.example.demo.entity.Product;

public class CustomerItem implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product item) throws Exception {
		// TODO Auto-generated method stub
		item.setTitle(item.getTitle().toUpperCase());
		return item;
	}

}
