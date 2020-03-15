package com.ghevi.pma.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// @Repository We dont need it anymore after refactoring to Services (lesson after AWS)
// @Primary // If we have two bean, this says which one to inject or we use @Qualifier("staffRepositoryImpl1") in the EmployeeService Constructor, first letter has to be smaller case
public class StaffRepositoryImpl1 implements IStaffRepository {
}
