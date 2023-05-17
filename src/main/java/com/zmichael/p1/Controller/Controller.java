package com.zmichael.p1.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zmichael.p1.Entity.Book;
import com.zmichael.p1.Repositiry.JpaRepo;
import com.zmichael.p1.Service.Service;

@RestController
public class Controller {

	
	
	@Autowired
//	Service  service;
	JpaRepo jpaRepo;
	@PostMapping("/api/addbook")
	public ResponseEntity<?> save(@RequestBody Book book ) {
		
		jpaRepo.save(book);
		
		return new ResponseEntity<Object> (book,HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getbook")
	public ResponseEntity<?> getBook(){
				
		return new ResponseEntity<> (jpaRepo.findAll(), HttpStatus.FOUND);
	}
	

	@GetMapping("/api/getbook/{id}") 
	public ResponseEntity<?> getBook(@PathVariable int id ){
				
		return new ResponseEntity<> (jpaRepo.findById(id), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/api/delBook/{id}")
	
	public ResponseEntity<?> DelBook(@PathVariable int id){
		Optional<Book>optional= jpaRepo.findById(id);
		
		if(optional.isPresent()) {
			
			jpaRepo.deleteById(id);
			return new ResponseEntity<String>("Dleted",HttpStatus.NO_CONTENT);
			
		}

		return new ResponseEntity<String>("id is not found",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/api/UpdateBook/{id}")
	
	public Book update(@RequestBody Book book,@PathVariable int id){
Optional<Book>optional= jpaRepo.findById(id);
		
		if(optional.isPresent()) {
			
			Book  book2= optional.get();
			
			book2.setTitel(book.getTitel());
			
			return jpaRepo.save(book2);
		}
		return null;
		
		 
		
	}
	
	
	
	
}
