package com.mmunoz.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends CrudRepository<ObjectClass, Integer> {

}