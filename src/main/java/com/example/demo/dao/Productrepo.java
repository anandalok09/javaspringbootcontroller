package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;
import jakarta.persistence.Id;
public interface Productrepo extends JpaRepository<Product, Integer> {

}
