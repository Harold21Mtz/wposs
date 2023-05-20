package com.wposs.scrum_back.employe.repository;

import com.wposs.scrum_back.employe.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    @Query(value = ("SELECT * FROM wposs.employee employee WHERE employee.employee_id IN (SELECT employee_area.employee_id FROM wposs.employee_area employee_area WHERE employee_area.area_id = :areaId"),nativeQuery = true)
    List<Employee> getAllByAreaId(UUID areaId);
    Boolean existsByEmployeeName(String employeeName);

    @Query(value = "SELECT * FROM wposs.employee em INNER JOIN wposs.team_employee te ON em.employee_id = te.employee_id WHERE te.team_id=?1",nativeQuery = true)
    List<Employee> getEmployeToTeam(UUID idTeam);
}
