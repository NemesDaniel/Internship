package com.example.demo.repository;

import com.example.demo.entity.Bag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BagRepository extends JpaRepository<Bag, String> {

}
