package com.QuizApp.QuizApp.Mapper;

import com.QuizApp.QuizApp.DTO.QuizDTO;
import com.QuizApp.QuizApp.Entity.Quiz;

public class QuizMapper {
    public static QuizDTO mapToQuizDTO(Quiz quiz){
        return new QuizDTO(
                quiz.getId(),
                quiz.getTitle(),
                quiz.getQuestions()

        );
    }

    public static Quiz mapToQuiz(QuizDTO quiz){
        return new Quiz(
                quiz.getId(),
                quiz.getTitle(),
                quiz.getQuestions()

        );
    }


}
