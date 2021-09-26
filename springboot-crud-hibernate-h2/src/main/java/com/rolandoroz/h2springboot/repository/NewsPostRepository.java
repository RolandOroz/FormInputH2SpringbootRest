package com.rolandoroz.h2springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolandoroz.h2springboot.model.NewsPost;

public interface NewsPostRepository extends JpaRepository<NewsPost, Long> {

}
