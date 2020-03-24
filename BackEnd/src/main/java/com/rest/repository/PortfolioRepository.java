package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.domain.Portfolio;



@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long>{
	//비어 있어도 기본적인 CRUD 사용 가능
}
