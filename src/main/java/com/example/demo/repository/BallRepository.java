package com.example.demo.repository;

import com.example.demo.entity.Ball;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BallRepository extends JpaRepository<Ball, String> {

}
