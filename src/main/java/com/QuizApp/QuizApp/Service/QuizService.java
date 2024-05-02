package com.QuizApp.QuizApp.Service;

import com.QuizApp.QuizApp.DTO.QuizDTO;
import com.QuizApp.QuizApp.Entity.QuestionWrapper;
import com.QuizApp.QuizApp.Entity.Response;
import com.QuizApp.QuizApp.Exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    QuizDTO createQuiz(String category,int numQ,String title);

    List<QuestionWrapper> getQuizQuestions(Integer id) throws ResourceNotFoundException;


    Integer calculateResult(Integer id, List<Response> responses) throws ResourceNotFoundException;
}
