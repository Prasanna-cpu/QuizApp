package com.QuizApp.QuizApp.Service;

import com.QuizApp.QuizApp.DTO.QuestionDTO;
import com.QuizApp.QuizApp.Entity.Question;
import com.QuizApp.QuizApp.Exceptions.EmptyDataExceptions;

import java.util.List;

public interface QuestionService {

    List<QuestionDTO> getAllQuestions() throws EmptyDataExceptions;

    List<QuestionDTO> getQuestionByCategory(String category);

    QuestionDTO addQuestion(QuestionDTO questionDto);
}
