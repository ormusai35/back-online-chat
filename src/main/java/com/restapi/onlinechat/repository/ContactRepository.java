package com.restapi.onlinechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.restapi.onlinechat.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	@Query(value = "select * from contacts where user_id = ?1", nativeQuery = true)
	List<Contact> getContactsByUserId(long userId);

}
