package com.kapers.messanger.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "dialogues")
public class Dialogue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    @JoinColumn(
            name = "usr_id",
            foreignKey = @ForeignKey(
                    name = "usr_fk"
            )
    )
    private List<User> users;

    @OneToMany
    private List<Message> messages;

}
