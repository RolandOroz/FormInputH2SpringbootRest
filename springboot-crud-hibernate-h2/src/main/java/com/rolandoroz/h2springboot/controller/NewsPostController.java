package com.rolandoroz.h2springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rolandoroz.h2springboot.model.NewsPost;
import com.rolandoroz.h2springboot.service.NewsPostService;

@RestController
public class NewsPostController {
	
	@Autowired
	private NewsPostService newsPostService;
	
	@GetMapping("/newsposts")
	public ResponseEntity<List<NewsPost>> getAllNewsPost(){
		return ResponseEntity.ok().body(newsPostService.getAllNewsPost());
	}
	
	@GetMapping("/newsposts/{id}")
	public ResponseEntity<NewsPost> getNewsPostById(@PathVariable long id){
		return ResponseEntity.ok().body(newsPostService.getNewsPostById(id));
	}
	
	@PostMapping("/newsposts")
	public ResponseEntity<NewsPost> createNewsPost(@RequestBody NewsPost newsPost){
		return ResponseEntity.ok().body(this.newsPostService.createNewsPost(newsPost));
	}
	
	@PutMapping("/newsposts/{id}")
	public ResponseEntity<NewsPost> updateNewsPost(@PathVariable long id, @RequestBody NewsPost newsPost){
		newsPost.setId(id);
		return ResponseEntity.ok().body(this.newsPostService.updateNewsPost(newsPost));
	}
	
	@DeleteMapping("/newsposts/{id}")
	public HttpStatus deleteNewsPost(@PathVariable long id) {
		this.newsPostService.deleteNewsPost(id);
		return HttpStatus.OK;
		
	}

}
