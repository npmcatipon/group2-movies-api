package com.bpi.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bpi.demo.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
