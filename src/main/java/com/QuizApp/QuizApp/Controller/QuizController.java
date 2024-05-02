package com.QuizApp.QuizApp.Controller;


import com.QuizApp.QuizApp.DTO.QuizDTO;
import com.QuizApp.QuizApp.Entity.QuestionWrapper;
import com.QuizApp.QuizApp.Exceptions.ResourceNotFoundException;
import com.QuizApp.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.QuizApp.QuizApp.Entity.Response;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<QuizDTO> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        QuizDTO savedQuiz=quizService.createQuiz(category,numQ,title);
        return new ResponseEntity<>(savedQuiz,HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) throws ResourceNotFoundException {
        List<QuestionWrapper> quizQuestions=quizService.getQuizQuestions(id);
        return new ResponseEntity<>(quizQuestions,HttpStatus.OK);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses) throws ResourceNotFoundException {
        Integer result=quizService.calculateResult(id,responses);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }


}
