package com.example.demo.dao;

import com.example.demo.model.OneLineJoke;
import com.example.demo.model.TwoLineJoke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OneLineJokeDao extends JpaRepository<OneLineJoke, Integer> {

}
