package com.cao.reboot0928restcrud.controller;

import com.cao.reboot0928restcrud.dao.DepartmentDao;
import com.cao.reboot0928restcrud.dao.EmployeeDao;
import com.cao.reboot0928restcrud.entity.Department;
import com.cao.reboot0928restcrud.entity.Employee;
import com.cao.reboot0928restcrud.exception.UserNotExitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class EmployeeDaoController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("emps")
    public String list(Model model){

        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("all",all);

        return "emp/list";
    }

    @GetMapping("emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        model.addAttribute("emp",employee);
        return "emp/add";
    }

    @PutMapping("emp")
    public String EditEmp(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("emp/{id}")
    public String DelEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping("hello")
    public String helo(@RequestParam("username") String username){
        if("aaa".equals(username)){
            throw  new UserNotExitException();
        }
        return "login";
    }
}
