package com.example.demo.repository;

import com.example.demo.entity.StringT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StringRepository extends JpaRepository<StringT, String> {

}
