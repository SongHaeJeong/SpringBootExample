package com.rest.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USER")
@Getter @Setter
@ToString
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name ="EMAIL")
	private String email;
	
	@NotBlank
	@Column(name ="PASSWORD")
	private String password;
	
	@NotBlank
	@Column(name ="NAME")
	private String name;
	
	@NotBlank
	@Column(name ="NICKNAME")
	private String	nickName;
	
	//자동으로 회원정보 생성한 시간 입력
	@CreationTimestamp
	@Column(name ="CREATEDATE")
	private Timestamp createDate;
	
	//자동으로 회원정보 수정한 시간 입력 -> 나중에 몇일이상 수정을 안했을 시 회원 수정 기능 추가 할 예정
	@UpdateTimestamp
	@Column(name ="UPDATEDATE")
	private Timestamp updateDate;
	
	@OneToMany(fetch = FetchType.LAZY ) // 지연 로딩
	@JoinColumn(name="PORTFOLIO_ID")
	private List<Portfolio> portfolio;
	
	
	
}
