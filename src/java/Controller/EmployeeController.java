package Controller;

import CompanyEntity.Employee;
import EmployeeDao.EmployeeDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mehtab
 */
@Named (value="employeeController")
@RequestScoped
public class EmployeeController {
    
    @Inject
    private EmployeeDao eDao;
    
    private String name;
    private Integer age;
    private Integer salary;
    private String department;
    private List<Employee> listEmployees;
    
    public void register(Employee e){
        e = new Employee(name,age,salary,department);
        eDao.registerEmployee(e);
    }
    
    @PostConstruct
    public void listAllEmployees(){
        this.listEmployees = eDao.findAllEmployees();
    }

    public EmployeeDao geteDao() {
        return eDao;
    }

    public void seteDao(EmployeeDao eDao) {
        this.eDao = eDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    
    
}
