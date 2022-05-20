package com.kapers.messanger.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usrs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
