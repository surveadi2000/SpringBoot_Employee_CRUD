package com.example.em_project.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    private long id;
    private String name;
    private String email;
    private String Phone_no;
}
