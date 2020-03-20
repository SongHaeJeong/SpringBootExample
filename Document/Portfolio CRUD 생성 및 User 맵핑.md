## Portfolio CRUD 생성 및 User 맵핑

__JPA 맵핑에 관련 개념은 Tech-Repository에 존재__[https://github.com/SongHaeJeong/Tech-Repository/tree/master/JPA%20%EA%B0%9C%EB%85%90](https://github.com/SongHaeJeong/Tech-Repository/tree/master/JPA 개념)



```java
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

```

```java
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

```



__User : Portfolio 1 : N 관계를 설정해줬고__ Front-End 개발해서 실제 파일 등록할 예정.

또한, 테스트 DB인 H2를 구축한 후 testcode도 작성할 예정임.