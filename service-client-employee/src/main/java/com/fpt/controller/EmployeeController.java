package com.fpt.controller;

import com.fpt.myservice.Employee;
import com.fpt.myservice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.rmi.RemoteException;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String listEmployee(Model model) throws RemoteException {
        model.addAttribute("list", employeeService.getEmployee());
        return "list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String form(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String create(Employee employee)throws RemoteException {
        employeeService.addEmployees(employee);
        return "redirect:/employee/list";

    }
}
