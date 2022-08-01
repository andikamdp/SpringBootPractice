package co.id.practice.practice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class HelloWorldModel {

    @Id
    @Column(name = "id")
    @GeneratedValue
    Long id;

    @Column(name = "message")
    String message;

    @Column(name = "sender")
    String sender;
}
