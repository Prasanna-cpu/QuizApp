package com.QuizApp.QuizApp.Service;

import com.QuizApp.QuizApp.DTO.QuestionDTO;
import com.QuizApp.QuizApp.Entity.Question;
import com.QuizApp.QuizApp.Exceptions.EmptyDataExceptions;
import com.QuizApp.QuizApp.Exceptions.ResourceNotFoundException;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getAllQuestions() throws EmptyDataExceptions;

    List<QuestionDTO> getQuestionByCategory(String category);

    QuestionDTO addQuestion(QuestionDTO questionDto);

    QuestionDTO findQuestionByID(Integer id) throws ResourceNotFoundException;

    QuestionDTO updateQuestionByID(Integer id,QuestionDTO updatedQuestion) throws ResourceNotFoundException;

    void deleteQuestionByID(Integer id) throws ResourceNotFoundException;
}
