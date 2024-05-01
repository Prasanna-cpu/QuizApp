package com.QuizApp.QuizApp.Controller;


import com.QuizApp.QuizApp.Entity.Question;
import com.QuizApp.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping()
    public List<Question> getAllQuestions(){
        return new LinkedList<>();
    }
}
