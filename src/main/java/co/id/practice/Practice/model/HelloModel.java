package co.id.practice.practice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class HelloModel {
    @Id
    @Column(name = "id")
    @GeneratedValue
    Long id;

    @Column(name = "message")
    String message;
}
