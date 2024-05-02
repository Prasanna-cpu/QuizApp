package com.QuizApp.QuizApp.Mapper;

import com.QuizApp.QuizApp.DTO.QuestionDTO;
import com.QuizApp.QuizApp.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionMapper {



    public static QuestionDTO mapToQuestionDTO(Question question){
        return new QuestionDTO(
                question.getId(),
                question.getQuestionTitle(),
                question.getOption1(),
                question.getOption2(),
                question.getOption3(),
                question.getOption4(),
                question.getRightAnswer(),
                question.getDifficultyLevel(),
                question.getCategory()
        );
    }

    public static Question mapToQuestion(QuestionDTO question){
        return new Question(
                question.getId(),
                question.getQuestionTitle(),
                question.getOption1(),
                question.getOption2(),
                question.getOption3(),
                question.getOption4(),
                question.getRightAnswer(),
                question.getDifficultyLevel(),
                question.getCategory()
        );
    }


}
