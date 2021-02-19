/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.balamut.contactviewer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Balamut
 */

@Entity()
@Table(name="contacts")
public class Contact implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    
    @Column(name="FULL_NAME")
    private String fullName;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    
    public Contact() {super();}
    
    public Contact(Long id, String fullName, String address, String phoneNumber) {
        super();
        if (id != null) {this.id = id;}
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
