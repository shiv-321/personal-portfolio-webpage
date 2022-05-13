package com.personal.portfolio.shivaraj.repository;

import com.personal.portfolio.shivaraj.model.MyService;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<MyService, String> {

}
