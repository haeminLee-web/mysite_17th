package com.study.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.mysite.question.Question;
import com.study.mysite.question.QuestionRepository;

@SpringBootTest
class Mysite17thApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	//테스트 코드에서는 생성자를 통한 객체 주입 방식을 지원하지 않아서 @AUtowired를 사용했지만 순환참조 문제 이슈가 발생할 수 있으므로 실제 코드에서는 setter나 생성자 주입방식르 사용하는 것을 권장한다.
	
	@Test
	void testJPA() {
		/*
		 * Question q1 = new Question(); q1.setSubject("JPA가 무엇인가요?");
		 * q1.setContent("알고 싶어요"); q1.setCreateDate(LocalDateTime.now());
		 * this.questionRepository.save(q1);
		 * 
		 * Question q2 = new Question(); q2.setSubject("ORM이 무엇인가요?");
		 * q2.setContent("궁금합니다."); q2.setCreateDate(LocalDateTime.now());
		 * this.questionRepository.save(q2);//두번째 질문 저장
		 */
		/*

		 * Question q3 = new Question();
		q3.setSubject("hibernate란 무엇인가요?");
		q3.setContent("궁금합니다.");
		q3.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q3); //두번째 질문 저장
		 * 
		 * 
		 * List<Question> all = this.questionRepository.findAll(); assertEquals(2,
		 * all.size());
		 * 
		 * Question q = all.get(0); assertEquals("JPA가 무엇인가요", q.getSubject());
		 */
		
		/*
		 * Question q = this.questionRepository.findBySubject("JPA가 무엇인가요?");
		 * assertEquals(1, q.getId());
		 */
		/*
		 * Question q =
		 * this.questionRepository.findBySubjectAndContent("JPA가 무엇인가요?","궁금합니다.");
		 * assertEquals(1, q.getId());
		 */
		
		/*
		 * List<Question> qList = this.questionRepository.findBySibjectLike("%무엇%");
		 * this.questionRepository.findAll();
		 */
		Question q3 = new Question();
		q3.setSubject("hibernate란 무엇인가요?");
		q3.setContent("궁금합니다.");
		q3.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q3); //두번째 질문 저장
		
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("무엇이든 궁금하면 물어보세요.");
		this.questionRepository.save(q);
	}

}
