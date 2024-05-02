package com.QuizApp.QuizApp.Controller;


import com.QuizApp.QuizApp.DTO.QuestionDTO;
import com.QuizApp.QuizApp.Entity.Question;
import com.QuizApp.QuizApp.Exceptions.EmptyDataExceptions;
import com.QuizApp.QuizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping()
    public List<QuestionDTO> getAllQuestions() throws EmptyDataExceptions {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<QuestionDTO> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionDTO questionDto){
        QuestionDTO savedQuestion=questionService.addQuestion(questionDto);
        return new ResponseEntity<QuestionDTO>(savedQuestion, HttpStatus.CREATED);
    }
}
