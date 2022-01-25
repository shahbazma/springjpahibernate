package com.sbz.learnings.springjpahibernate;

import com.sbz.learnings.springjpahibernate.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
