package com.WanderHub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plases")
public class Plase {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
    @Column(name = "plases",nullable = false)
     private String plases;
    @Column(name = "contend",nullable = false)
     private String contend;

    @ManyToOne
    @JoinColumn(name = "cityname", referencedColumnName = "cityname")
    private City city;
}
