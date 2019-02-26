/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeDao;

import CompanyEntity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mehtab
 */
@Stateless
public class EmployeeDao {
    @PersistenceContext(name="CompanyPU")
    EntityManager em;
    
    public Employee registerEmployee(Employee employee){
        em.persist(employee);
        return employee;
    }
    
    public void deleteEmployee(Integer id){
        em.remove(em.find(Employee.class, id));
    }
    
    public Employee updateEmployee(Employee employee){
        em.merge(employee);
        return employee;
    }
    
    public Employee findEmployeeById(Integer id){
       return em.find(Employee.class, id);
        
    }
    
    public List<Employee> findAllEmployees(){
       return em.createQuery("Select e From Employee e", Employee.class).getResultList();
    }
    
}
