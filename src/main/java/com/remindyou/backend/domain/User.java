package com.remindyou.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data   //i krijon geterat dhe seterat
@AllArgsConstructor //per konstruktore me parametra
@NoArgsConstructor //per konstruktore pa parametra
@Builder
@Entity
@Table (name = "users") //nuk lejon "user" fjale e rezervuar - raste tjera ben njejes
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String uuid; // gjenerohet random dhe i dergohet front-endit - per arsye sigurie

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;
}
