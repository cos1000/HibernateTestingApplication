/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mensa.hibernatetestingapplication.entity;

import java.io.Serializable;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "app_users", uniqueConstraints = {@UniqueConstraint(columnNames = "code")})
public class AppUser implements Serializable {

    public AppUser() {
        //this.created_at = new Date(); 
        //sthis.updated_at = new Date(); 
    };

    public AppUser(String code) {
        this(); 
        this.code = code;
    };

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "code", length = 10)
    private String code;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AppRole> roles; 
    
    @Column(name = "created_at")
    private LocalDateTime created_at; 
        
    @Column(name = "updated_at")
    private LocalDateTime updated_at; 
        
}