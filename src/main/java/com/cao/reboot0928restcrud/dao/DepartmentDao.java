package com.cao.reboot0928restcrud.dao;

import com.cao.reboot0928restcrud.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments  = new HashMap<>();
        departments.put(101,new Department(101,"AA"));
        departments.put(102,new Department(102,"BB"));
        departments.put(103,new Department(103,"CC"));
        departments.put(104,new Department(104,"DD"));
        departments.put(105,new Department(105,"EE"));

    }

    private static Integer initid = 106;


    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartment(Integer id){
        return departments.get(id);
    }

}
