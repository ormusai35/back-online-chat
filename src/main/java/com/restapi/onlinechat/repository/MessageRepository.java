package com.restapi.onlinechat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.onlinechat.model.Message;
import com.restapi.onlinechat.model.Msg;

@Repository
public interface MessageRepository extends JpaRepository<Msg, Long>{
	@Query(value="select * from msgs ms where ms.sender_id = ?1 and ms.receiver_id = ?2", nativeQuery = true)
	List<Msg> findBySenderReceiver(Long senderId, Long receiverId);
//	@Query(value="select * from messages ms where contact_id = ?1", nativeQuery = true)
//	List<Message> findByContactId(Long contactId);
}
