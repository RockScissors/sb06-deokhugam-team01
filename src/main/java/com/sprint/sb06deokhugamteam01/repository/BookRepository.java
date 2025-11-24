package com.sprint.sb06deokhugamteam01.repository;

import com.sprint.sb06deokhugamteam01.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
