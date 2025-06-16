package com.bumpsh.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@Tag(name = "Employee Management", description = "Operations related to employee management")
class EmployeeController {

	private final EmployeeRepository repository;

	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	@GetMapping("/employees")
  @Operation(summary = "Get all employees", description = "Returns a list of all employees")
	List<Employee> all() {
		return repository.findAll();
	}

	@PostMapping("/employees")
  @Operation(summary = "Create a new employee", description = "Adds a new employee to the system")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}
	
	@GetMapping("/employees/{id}")
  @Operation(summary = "Get an employee by ID", description = "Returns the details of an employee based on the provided ID")
  @ApiResponse(
    responseCode = "200", 
    description = "Successful operation", 
    content = @Content(mediaType = "application/json", 
    schema = @Schema(implementation = Employee.class))
  )
	public Employee one(
      @Parameter(in = ParameterIn.PATH, description = "ID of the employee to retrieve", required = true, schema = @Schema(type = "integer")) 
      @PathVariable Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

	@PutMapping("/employees/{id}")
  @Operation(summary = "Update an existing employee", description = "Updates the details of an employee based on the provided ID")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return repository.findById(id)
			.map(employee -> {
				employee.setName(newEmployee.getName());
				employee.setRole(newEmployee.getRole());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				return repository.save(newEmployee);
			});
	}

	@DeleteMapping("/employees/{id}")
  @Operation(summary = "Delete an employee", description = "Removes an employee from the system based on the provided ID")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
