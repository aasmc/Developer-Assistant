package ru.aasmc.assistant.persistence;

import org.springframework.data.repository.CrudRepository;

public interface AnswersRepository extends CrudRepository<AnswerEntity, Long> {
}
