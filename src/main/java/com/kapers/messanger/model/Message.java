package com.kapers.messanger.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    public Message(String text, User owner, Dialogue dialogue) {
        this.text = text;
        this.owner = owner;
        this.dialogue = dialogue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    private Date date = new Date();

    private String text;

    @ManyToOne
    @JoinColumn(
            name = "usr_id",
            foreignKey = @ForeignKey(
                    name = "usr_fk"
            )
    )
    private User owner;

    @ManyToOne
    @JoinColumn(
            name = "dialogue_id",
            foreignKey = @ForeignKey(
                    name = "dialogue_fk"
            )
    )
    private Dialogue dialogue;

}
