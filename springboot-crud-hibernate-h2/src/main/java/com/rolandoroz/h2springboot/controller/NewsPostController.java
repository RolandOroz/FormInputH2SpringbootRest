package com.rolandoroz.h2springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rolandoroz.h2springboot.model.NewsPost;
import com.rolandoroz.h2springboot.repository.NewsPostRepository;


@CrossOrigin(origins = "http://localhost:1841") // 1841
@RestController
//@RequestMapping("data")
public class NewsPostController {

	@Autowired
	private NewsPostRepository newsPostRepository;

	@GetMapping("/newsposts")
	public ResponseEntity<List<NewsPost>> getAllNewsPost(@RequestParam(required = false) String newstitle ) {
		//return ResponseEntity.ok().body(newsPostService.getAllNewsPost());
		
		try {
				List<NewsPost> newsPosts = new ArrayList<NewsPost>();
				
				if(newstitle == null)
					
					newsPostRepository.findAll().forEach(newsPosts::add);
				
				else
					
		newsPostRepository.findByNewstitleContaining(newstitle).forEach(newsPosts::add);
				
				if(newsPosts.isEmpty()) {
					
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				
				return new ResponseEntity<>(newsPosts, HttpStatus.OK);
				
		} catch (Exception e) {
		
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

	
	@GetMapping("/newsposts/{id}")
	public ResponseEntity<NewsPost> getNewsPostById(@PathVariable("id") long id) {
		//return ResponseEntity.ok().body(newsPostService.getNewsPostById(id));
		
		Optional<NewsPost> newsPostData = newsPostRepository.findById(id);
		
		if(newsPostData.isPresent()) {
				
				return new ResponseEntity<>(newsPostData.get(), HttpStatus.OK);
		
		} else {
			
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/newsposts")
	public ResponseEntity<NewsPost> createNewsPost(@RequestBody NewsPost newsPost) {
		//return ResponseEntity.ok().body(this.newsPostService.createNewsPost(newsPost));
		
		try {
			
				NewsPost _newsPost = newsPostRepository.save(new NewsPost(newsPost.getNewstitle(), null, newsPost.getFpost(), false));
				
					return new ResponseEntity<>(_newsPost, HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping(value = "/newsposts/{id}")
	public ResponseEntity<NewsPost> updateNewsPost(@PathVariable("id") long id, @RequestBody NewsPost newsPost) {
//		newsPost.setId(id);
//		return ResponseEntity.ok().body(this.newsPostService.updateNewsPost(newsPost));
		
		Optional<NewsPost> newsPostData = newsPostRepository.findById(id);
		
		if(newsPostData.isPresent()) {
			
			NewsPost _newsPost = newsPostData.get();
			_newsPost.setNewstitle(newsPost.getNewstitle());
			_newsPost.setFpost(newsPost.getFpost());
			_newsPost.setCdate(newsPost.getCdate());
			//_newsPost.setPublished(newsPost.isPublished());
			
			return new ResponseEntity<>(newsPostRepository.save(_newsPost), HttpStatus.OK);		
			
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/newsposts/{id}")
	/*public HttpStatus deleteNewsPost(@PathVariable long id) {
		this.newsPostService.deleteNewsPost(id);
		return HttpStatus.OK; */
	public ResponseEntity<HttpStatus> deleteNewsPost(@PathVariable("id") long id) {
		
		try {
				newsPostRepository.deleteById(id);
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@GetMapping("/newsposts/published")
	/* @RequestMapping("newsposts")
	public List<NewsPost> getAllNewsPosts() {
		return newsPostService.getAllNewsPost();
	} */
	public ResponseEntity<List<NewsPost>> findByPublished() {
		
		try {
			
				List<NewsPost> newsPosts = newsPostRepository.findByPublished(true);
				
				if(newsPosts.isEmpty()) {
					
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					
				}
				
				return new ResponseEntity<>(newsPosts, HttpStatus.OK); 
					
				
				} catch (Exception e) {
						
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
		
		}
	}
