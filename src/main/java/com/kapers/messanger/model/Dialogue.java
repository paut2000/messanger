package com.kapers.messanger.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dialogues")
public class Dialogue {

    public Dialogue(String name, User owner, List<User> users) {
        this.name = name;
        this.owner = owner;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(
            name = "owner_id",
            foreignKey = @ForeignKey(
                    name = "owner_fk"
            )
    )
    private User owner;

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
