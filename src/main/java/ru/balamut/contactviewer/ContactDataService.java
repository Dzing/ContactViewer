/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.balamut.contactviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.balamut.contactviewer.entity.Contact;
import ru.balamut.contactviewer.repository.ContactRepository;

/**
 *
 * @author Balamut
 */

@Service("contactDataService")
public class ContactDataService {
    
    @Autowired
    private ContactRepository contactRepository;
    
    public Iterable<Contact> getAll() {
        return contactRepository.findAll();
    }
    
    public Contact getOne(long id) {
        return contactRepository.findById(id).get();
    }
    
    public void delOne(long id) {
        contactRepository.deleteById(id);
    }
    
    public void newOne(Contact data) {
        contactRepository.save(data);
    }
    
    public void updOne(Contact data) {
        contactRepository.save(data);
    }
    
}
