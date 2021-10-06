package com.rolandoroz.h2springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rolandoroz.h2springboot.exception.ResourceNotFoundException;
import com.rolandoroz.h2springboot.model.NewsPost;
import com.rolandoroz.h2springboot.repository.NewsPostRepository;

@Service
@Transactional
public class NewsPostServiceImpl implements NewsPostService {
	
	@Autowired
	private NewsPostRepository newsPostRepository;

	@Override
	public NewsPost createNewsPost(NewsPost newspost) {
		return newsPostRepository.save(newspost) ;
	}

	@Override
	public NewsPost updateNewsPost(NewsPost newspost) {
		Optional<NewsPost>	newsPostDb = 	this.newsPostRepository.findById(newspost.getId());
		
		if (newsPostDb.isPresent()) {
			NewsPost newsPostUpdate = newsPostDb.get();
			newsPostUpdate.setId((int) newspost.getId());
			newsPostUpdate.setNewstitle(newspost.getNewstitle());
			newsPostUpdate.setCdate(newspost.getCdate());
			newsPostUpdate.setFpost(newspost.getFpost());
			newsPostRepository.save(newsPostUpdate);
			return newsPostUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + newspost.getId());
		}
	}

	@Override
	public List<NewsPost> getAllNewsPost() {		
		return this.newsPostRepository.findAll() ;
	}

	@Override
	public NewsPost getNewsPostById(long newspostId) {
		
		Optional<NewsPost>	newsPostDb = 	this.newsPostRepository.findById(newspostId);
		
		if (newsPostDb.isPresent()) {
			return newsPostDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + newspostId);			
		}
	}

	@Override
	public void deleteNewsPost(long newspostId) {
		Optional<NewsPost>	newsPostDb = 	this.newsPostRepository.findById(newspostId);
		
		if (newsPostDb.isPresent()) {
			this.newsPostRepository.delete(newsPostDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + newspostId);			
		}
		
	}
	
	

}
