package fr.hadriel.specifications;

import org.springframework.data.jpa.domain.Specification;

import fr.hadriel.model.Employee;

public class EmployeeSpecifications {

    public static Specification<Employee> hasName(String firstName) {
        return (root, query, cb) -> firstName == null ? null : cb.equal(root.get("firstName"), firstName);   
    }

    public static Specification<Employee> hasZipCode(String lastName) {
        return (root, query, cb) -> lastName == null ? null : cb.equal(root.get("lastName"), lastName);
    }

    public static Specification<Employee> inCity(String email) {
        return (root, query, cb) -> email == null ? null : cb.equal(root.get("email"), email);
    }
}
