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
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal; 
import javax.persistence.TemporalType; 
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@Table(name = "app_roles", uniqueConstraints = {@UniqueConstraint(columnNames = "code")})
public class AppRole implements Serializable {
    
    public AppRole() {
        //this.created_at = new Date(); 
        //sthis.updated_at = new Date(); 
    };

    public AppRole(String code) {
        this(); 
        this.code = code;
    };

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<AppUser> users; 
    
    @Column(name = "created_at")
    private LocalDateTime created_at; 

    @Column(name = "updated_at")
    private LocalDateTime updated_at; 
        
}
