package com.portal.auto.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.portal.auto.bean.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}