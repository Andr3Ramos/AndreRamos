package com.example.JpaExercise.Repo;

import com.example.JpaExercise.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
