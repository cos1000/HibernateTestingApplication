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
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Temporal; 
import javax.persistence.TemporalType; 
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
@Data
@Table(name = "app_users", uniqueConstraints = {@UniqueConstraint(columnNames = "code")})
public class AppUser implements Serializable {

    public AppUser() {

    };

    public AppUser(String code) {
            this.code = code;

    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 10)
    private String code;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AppRole> roles; 
    
    @Column(name = "created_at")
    private Date created_at; 
        
    @Column(name = "updated_at")
    private Date updated_at; 
        
}