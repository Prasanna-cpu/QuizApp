package com.QuizApp.QuizApp.Service.Implementation;

import com.QuizApp.QuizApp.DTO.QuestionDTO;
import com.QuizApp.QuizApp.Entity.Question;
import com.QuizApp.QuizApp.Exceptions.EmptyDataExceptions;
import com.QuizApp.QuizApp.Exceptions.ResourceNotFoundException;
import com.QuizApp.QuizApp.Mapper.QuestionMapper;
import com.QuizApp.QuizApp.Repository.QuestionRepository;
import com.QuizApp.QuizApp.Service.QuestionService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

@AllArgsConstructor
public class QuestionServiceImplementation implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<QuestionDTO> getAllQuestions() throws EmptyDataExceptions {
        List<Question> questions=questionRepository.findAll();

        if(questions.isEmpty()){
            throw new EmptyDataExceptions("Add some questions first, the list is empty");
        }

        return questions.stream().map(QuestionMapper::mapToQuestionDTO).collect(Collectors.toList());
    }

    @Override
    public List<QuestionDTO> getQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    @Override
    public QuestionDTO addQuestion(QuestionDTO questionDto) {
        Question question=QuestionMapper.mapToQuestion(questionDto);
        return QuestionMapper.mapToQuestionDTO(questionRepository.save(question));
    }

    @Override
    public QuestionDTO findQuestionByID(Integer id) throws ResourceNotFoundException {
        Question questionById=questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("The question with the given id does not exist!"));
        return QuestionMapper.mapToQuestionDTO(questionById);
    }

    @Override
    public QuestionDTO updateQuestionByID(Integer id,QuestionDTO updatedQuestion) throws ResourceNotFoundException {
        Question question=questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("The question with the given id does not exist!"));
        question.setQuestionTitle(updatedQuestion.getQuestionTitle());
        question.setOption1(updatedQuestion.getOption1());
        question.setOption2(updatedQuestion.getOption2());
        question.setOption3(updatedQuestion.getOption3());
        question.setOption4(updatedQuestion.getOption4());
        question.setRightAnswer(updatedQuestion.getRightAnswer());
        question.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
        question.setCategory(updatedQuestion.getCategory());
        Question newUpdatedQuestion=questionRepository.save(question);
        return QuestionMapper.mapToQuestionDTO(newUpdatedQuestion);
    }

    @Override
    public void deleteQuestionByID(Integer id) throws ResourceNotFoundException {
//        Question question=questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("The question with the given id does not exist!"));
        questionRepository.deleteById(id);
    }

}
