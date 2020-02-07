package com.remindyou.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "reminder")
public class Reminder {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String uuid;

    @Column
    private String message;

    @Column
    private LocalDateTime date;

    @Column
    private String status;  //PENDING, ACCEPTED, DECLINDED

    @ManyToOne
    private User fromUser; //sender

    @ManyToOne
    private User toUser; //receiver


}
