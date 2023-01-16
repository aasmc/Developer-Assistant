package ru.aasmc.assistant.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {
    QuestionEntity findFirstByText(String text);

    @Modifying
    @Query("update QuestionEntity q set q.answer = ?1 where q.id = ?2")
    void setAnswerFor(AnswerEntity answer, Long id);
}
