package com.example.Java.Stream.Practice.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private boolean active;


}
