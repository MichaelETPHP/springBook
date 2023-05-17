package com.zmichael.p1.Repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zmichael.p1.Entity.Book;

public interface JpaRepo extends JpaRepository<Book, Integer>{

//	Object update(Book book, int id);

	
	
}
