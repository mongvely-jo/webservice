package com.example.demod.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Accessors(chain = true)
public class Freeboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long freeId;

    private String account;

    private String writer;

    private String phoneNumber;

    private String content;

    private String title;
}
