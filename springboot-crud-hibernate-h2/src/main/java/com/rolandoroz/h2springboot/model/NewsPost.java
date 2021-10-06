package com.rolandoroz.h2springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "newspost")
public class NewsPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "id")
	private long id;

	@Column(name = "newstitle")
	private String newstitle;

	@DateTimeFormat
	@Column(name = "cdate")
	private Date cdate;

	@Column(name = "fpost")
	private String fpost;

		
	@Column(name = "published")
	private boolean published;



	// Constructor
	public NewsPost(String newstitle, Date cdate, String fpost, boolean published) {
		// super();		
		this.newstitle = newstitle;
		this.cdate = cdate;
		this.fpost = fpost;		
		this.published = published;
	}



	/*public NewsPost(String newstitle, String fpost, boolean b) {
		// TODO Auto-generated constructor stub
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getFpost() {
		return fpost;
	}

	public void setFpost(String fpost) {
		this.fpost = fpost;
	}

		
	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}

	//Generate to String
	@Override
	public String toString() {
		return "[" +
				"success: true," +
				"data: {" +
				"id:" + id +
				", newstitle:" + newstitle +
				", cdate:" + cdate +
				", fpost:" + fpost +
				", published:" + published	+
				"}" + "]";
	}

	
	

	
	
}
