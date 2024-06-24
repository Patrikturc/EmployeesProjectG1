# Employee Management System

## Overview
This project aims to manage employee data effectively by integrating functionalities to generate, sanitize, and interact with employee records. It includes the generation of random employee data, conversion into objects, data sanitization, and several search capabilities.

## Requirements

### Adding Factory Class
1. **Add `EmployeeFactory.java`**: Place the provided `EmployeeFactory.java` class into a suitable package within your project. This class is responsible for generating random employee data.

### Adding Sample Data File
2. **Add `employees.csv`**: Place the provided `employees.csv` file into the `src/main/resources` folder of your project. This file contains sample employee data that can be used for testing and demonstration purposes.

### Generating Employee Data
3. **Generate Employee Data**: Use the `EmployeeFactory.getEmployees(n)` method to generate an array of random employee data of size `n` (where `1 <= n <= 1000`).
    - The employee data is provided as an array of Strings, each representing:
        - Emp ID (up to 8 digits)
        - Prefix
        - First Name
        - Middle Initial
        - Last Name
        - Gender (M or F)
        - Email (standard email format)
        - Date of Birth (YYYY-MM-DD)
        - Date of Joining (YYYY-MM-DD)
        - Salary
    - Example of a data string: `"387647,Drs.,Shanika,D,Tejada,F,shanika.tejada@gmail.com,1958-08-16,1995-05-23,81253"`

### Data Conversion and Sanitization
4. **Create DTO Class**: Create a suitable DTO (Data Transfer Object) class named `Employee` to represent an employee. This class should contain fields corresponding to the employee data fields and appropriate constructors, getters, and setters.

5. **Convert Data**: Convert each element in the array of strings into an `Employee` object and store these objects in a `List` using a suitable concrete type (e.g., `ArrayList`).

6. **Sanitize Data**: Ensure that only correct and complete records are added to the list. Implement data validation checks and handle any corrupted data entries appropriately. Inform the user about the number of corrupted records.

### Data Access Object (DAO) Class
7. **Create DAO Class**: Design an interface named `EmployeeDAO` for interacting with the collection of employees. This interface should define the following methods:
    - `Employee searchById(String empId)`: Search for an employee by Emp ID.
    - `List<Employee> searchByLastName(String lastName)`: Search for employees by last name (partial match).
    - `List<Employee> searchByHireDateRange(LocalDate startDate, LocalDate endDate)`: Search for employees hired within a date range.
    - `List<Employee> searchByAgeRange(int minAge, int maxAge)`: Search for employees within a specific age range.

8. **Implement DAO Class**: Create a class named `EmployeeDAOImpl` that implements the `EmployeeDAO` interface. This class should provide concrete implementations for the methods defined in the interface. You may add additional methods as needed for enhanced functionality.

