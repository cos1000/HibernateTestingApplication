/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mensa.hibernatetestingapplication.entity;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;
import java.sql.Timestamp; 
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal; 
import javax.persistence.TemporalType; 

@Entity
@Data
@Table(name = "app_roles")
public class AppRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToMany
    private List<AppUser> users; 
    
    @Column(name = "created_at")
    private Date created_at; 

    @Column(name = "updated_at")
    private Date updated_at; 
        
}