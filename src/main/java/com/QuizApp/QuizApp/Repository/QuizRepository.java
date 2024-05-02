package com.QuizApp.QuizApp.Repository;
import com.QuizApp.QuizApp.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}
