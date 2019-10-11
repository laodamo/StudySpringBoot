package com.cao.reboot0928restcrud.dao;

import com.cao.reboot0928restcrud.entity.Department;
import com.cao.reboot0928restcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private  DepartmentDao departmentDao;

//    private Integer id;
//    private String lastName;
//    private  String email;
//    private Integer gender;
//    private Department department;
//    private Date birth;
    static {
        employees = new HashMap<>();
        employees.put(101,new Employee(101,"E-AA","aa@qq.com",1,new Department(101,"D-AA"),new Date()));
        employees.put(102,new Employee(102,"E-BB","bb@qq.com",0,new Department(102,"D-BB"),new Date()));
        employees.put(103,new Employee(103,"E-CC","cc@qq.com",1,new Department(103,"D-CC"),new Date()));
        employees.put(104,new Employee(104,"E-DD","dd@qq.com",0,new Department(104,"D-DD"),new Date()));
        employees.put(105,new Employee(105,"E-EE","ee@qq.com",1,new Department(105,"D-EE"),new Date()));
    }

    private static Integer initid = 106;

    public void  save(Employee employee){

        if(employee.getId() == null){
            employee.setId(initid++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee get(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}
