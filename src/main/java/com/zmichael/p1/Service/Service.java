package com.zmichael.p1.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.zmichael.p1.Entity.Book;
import com.zmichael.p1.Repositiry.JpaRepo;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	JpaRepo jpaRepo;
	
	public Book update(Book book,int id) {
		
Optional<Book>optional= jpaRepo.findById(id);
		
		if(optional.isPresent()) {
			
			Book  book2= optional.get();
			
			book2.setTitel(book.getTitel());
			
			return jpaRepo.save(book2);
		}
		return null;
		
	}
	
}
