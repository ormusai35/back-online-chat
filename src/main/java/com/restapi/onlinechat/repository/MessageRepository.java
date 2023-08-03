package com.restapi.onlinechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.onlinechat.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
//	@Query(value="select * from messages ms where contact_id = ?1", nativeQuery = true)
	List<Message> findByContactId(Long contactId);
}
