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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal; 
import javax.persistence.TemporalType; 

@Entity
@Data
@Table(name = "app_users")
public class AppUser implements Serializable {

	public AppUser() {

	};

	public AppUser(String login) {
		this.login = login;

	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
        
        @Column(name = "login")
	private String login;
        
        @Column(name = "created_at")
        private Date created_at; 
        
}