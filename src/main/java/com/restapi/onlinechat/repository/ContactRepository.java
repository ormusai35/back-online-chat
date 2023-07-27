package com.restapi.onlinechat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.restapi.onlinechat.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
