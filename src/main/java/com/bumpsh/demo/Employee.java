package com.bumpsh.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Employees are individuals who work for an organization, " +
  "contributing their skills and expertise to achieve the organization's goals." +

  "Roles are the specific functions or positions that employees occupy within the organization, " +
  "defining their duties, responsibilities, and the scope of their work."
)
class Employee {

	private @Id

  @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Unique identifier which should not be shared publicly", example = "1234")
	@GeneratedValue Long id;
	
  @Schema(description = "Employee name", example = "Bilbo Baggins")
  private String name;

  @Schema(description = "Employee role", example = "Software Engineer", deprecated = true)
  @Deprecated
	private String role;

	Employee() {}

	Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getRole() {
		return this.role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// @Override
	// public boolean equals(Object o) {

	// 	if (this == o)
	// 		return true;
	// 	if (!(o instanceof Employee))
	// 		return false;
	// 	Employee employee = (Employee) o;
	// 	return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
	// 			&& Objects.equals(this.role, employee.role);
	// }

	// @Override
	// public int hashCode() {
	// 	return Objects.hash(this.id, this.name, this.role);
	// }

	// @Override
	// public String toString() {
	// 	return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
	// }
}
