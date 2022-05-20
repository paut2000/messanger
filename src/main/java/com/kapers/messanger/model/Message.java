package com.kapers.messanger.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    private Date date;

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
