package com.study.mysite.question;

import java.time.LocalDateTime;
import java.util.List;

import com.study.mysite.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100) //글자의 갯수를 100개(염문, 한글 동일)
	private String subject;
	
	@Column(columnDefinition = "TEXT") //글자의 갯수를 무한대
	private String content;
	
	private LocalDateTime createDate; //db에서는 create_date
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) //질문이 삭제되면 관련 답변도 전부 삭제하겠다
	private List<Answer> answerList;
}