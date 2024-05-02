package com.QuizApp.QuizApp.DTO;


import com.QuizApp.QuizApp.Entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private Integer id;
    private String title;
    private List<Question> questions;
}
