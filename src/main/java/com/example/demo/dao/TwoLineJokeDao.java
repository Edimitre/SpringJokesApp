package com.example.demo.dao;

import com.example.demo.model.TwoLineJoke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwoLineJokeDao extends JpaRepository<TwoLineJoke, Integer> {

    @Query(value = "select * from two_liners_table where category = :category", nativeQuery = true)
    List<TwoLineJoke> findTwoLineJokesByCategory(@Param("category") String category);

}
