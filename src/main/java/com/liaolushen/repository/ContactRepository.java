package com.liaolushen.repository;

import com.liaolushen.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by liaolushen on 11/24/15.
 *
 * @author liaolushen
 */
@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
