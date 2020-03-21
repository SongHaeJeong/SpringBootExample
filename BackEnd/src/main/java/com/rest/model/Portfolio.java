package com.rest.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PORTFOLIO")
@Getter @Setter
public class Portfolio {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="IMGURL")
	private String imgUrl; // 이미지 URL
	
	@Column(name="WRITER")
	private String writer;
	
	@Column(name="READCOUNT")
	private Long readCount;
	
	@CreationTimestamp
	@Column(name ="CREATEDATE")
	private Timestamp createDate;
	
	@UpdateTimestamp
	@Column(name ="UPDATEDATE")
	private Timestamp updateDate;
	
	
	
}
