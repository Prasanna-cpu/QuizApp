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
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() throws EmptyDataExceptions {
        List<QuestionDTO> savedQuestions=questionService.getAllQuestions();
        return ResponseEntity.ok(savedQuestions);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionDTO>> getQuestionByCategory(@PathVariable String category){
        List<QuestionDTO> questionsByCategory=questionService.getQuestionByCategory(category);
        return ResponseEntity.ok(questionsByCategory);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<QuestionDTO> addQuestion(@RequestBody QuestionDTO questionDto){
        QuestionDTO savedQuestion=questionService.addQuestion(questionDto);
        return new ResponseEntity<QuestionDTO>(savedQuestion, HttpStatus.CREATED);
    }
}
