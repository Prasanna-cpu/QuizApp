package com.QuizApp.QuizApp.Service.Implementation;

import com.QuizApp.QuizApp.DTO.QuestionDTO;
import com.QuizApp.QuizApp.Entity.Question;
import com.QuizApp.QuizApp.Exceptions.EmptyDataExceptions;
import com.QuizApp.QuizApp.Mapper.QuestionMapper;
import com.QuizApp.QuizApp.Repository.QuestionRepository;
import com.QuizApp.QuizApp.Service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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


}
