package com.QuizApp.QuizApp.Service.Implementation;

import com.QuizApp.QuizApp.DTO.QuizDTO;
import com.QuizApp.QuizApp.Entity.Question;
import com.QuizApp.QuizApp.Entity.QuestionWrapper;
import com.QuizApp.QuizApp.Entity.Quiz;
import com.QuizApp.QuizApp.Entity.Response;
import com.QuizApp.QuizApp.Exceptions.ResourceNotFoundException;
import com.QuizApp.QuizApp.Mapper.QuizMapper;
import com.QuizApp.QuizApp.Repository.QuestionRepository;
import com.QuizApp.QuizApp.Repository.QuizRepository;
import com.QuizApp.QuizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuizServiceImplementation implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public QuizDTO createQuiz(String category, int numQ, String title) {

        List<Question> questions=questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        Quiz savedQuiz=quizRepository.save(quiz);

        return QuizMapper.mapToQuizDTO(savedQuiz);

    }

    @Override
    public List<QuestionWrapper> getQuizQuestions(Integer id) throws ResourceNotFoundException {
        Quiz quiz=quizRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Available"));
        List<Question> questionsFromDB=quiz.getQuestions();
        List<QuestionWrapper> questionsForUsers=new ArrayList<>();

        for(Question q:questionsFromDB){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUsers.add(qw);
        }
        return questionsForUsers;
    }

    @Override
    public Integer calculateResult(Integer id, List<Response> responses) throws ResourceNotFoundException {
        Quiz quiz=quizRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Available"));
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response res:responses){
            if(res.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return right;

    }


}
