package com.repurva.ems_backend.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDAO
{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
