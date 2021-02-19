/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.balamut.contactviewer.repository;

import org.springframework.data.repository.CrudRepository;
import ru.balamut.contactviewer.entity.Contact;
//import org.springframework.stereotype.Repository;

/**
 *
 * @author Balamut
 */
//@Repository("contactRepository")
public interface ContactRepository extends CrudRepository <Contact, Long> {}
