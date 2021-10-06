package com.rolandoroz.h2springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.rolandoroz.h2springboot.model.NewsPost;
import com.rolandoroz.h2springboot.service.NewsPostService;

@CrossOrigin( origins = "http://localhost:1841")
@RestController
public class NewsPostController {
	
	@Autowired
	private NewsPostService newsPostService;
	
	@CrossOrigin( origins = "http://localhost:1841")
	@GetMapping("/newsposts")
	public ResponseEntity<List<NewsPost>> getAllNewsPost(){
		return ResponseEntity.ok().body(newsPostService.getAllNewsPost());
	}
	
	@CrossOrigin( origins = "http://localhost:1841")
	@GetMapping("/newsposts/{id}")	
	public ResponseEntity<NewsPost> getNewsPostById(@PathVariable long id){
		return ResponseEntity.ok().body(newsPostService.getNewsPostById(id));
	}
	
	@CrossOrigin( origins = "http://localhost:1841")
	@PostMapping(value = "/newsposts", consumes = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<NewsPost> createNewsPost(@RequestBody NewsPost newsPost){
		return ResponseEntity.ok().body(this.newsPostService.createNewsPost(newsPost));
	}
	
	@CrossOrigin( origins = "http://localhost:1841")
	@PutMapping(value ="/newsposts/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<NewsPost> updateNewsPost(@PathVariable long id, @RequestBody NewsPost newsPost){
		newsPost.setId(id);
		return ResponseEntity.ok().body(this.newsPostService.updateNewsPost(newsPost));
		
	}
	
	
	@CrossOrigin( origins = "http://localhost:1841")
	@DeleteMapping("/newsposts/{id}")
	public HttpStatus deleteNewsPost(@PathVariable long id) {
		this.newsPostService.deleteNewsPost(id);
		return HttpStatus.OK;
		
	}

}
