package com.personal.portfolio.shivaraj.repository;

import com.personal.portfolio.shivaraj.model.MyContact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<MyContact, String> {

}
