package com.QuizApp.QuizApp.Repository;


import com.QuizApp.QuizApp.DTO.QuestionDTO;
import com.QuizApp.QuizApp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<QuestionDTO> findByCategory(String category);
}
