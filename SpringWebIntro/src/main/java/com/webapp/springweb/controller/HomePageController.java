package com.webapp.springweb.controller;

import com.webapp.springweb.model.Employee;
import com.webapp.springweb.repo.EmployeeRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomePageController {

    @Autowired
    EmployeeRepo repo;

    @RequestMapping("/")
    public String getHomePage() {
        return "index";
    }

    @RequestMapping("/v1/getData")
    public String getEmployeeData( HttpServletRequest request , HttpSession session) {
        System.out.println("In getEmployeeData() ");
        // considering empId will be given from input and it will be a number.
        int id = Integer.parseInt( request.getParameter("empId") );
        System.out.println("Data : "+id);

        Employee employee = repo.getEmployeeData(id);
        session.setAttribute("Data",employee);
        return "employeeView";
    }
    @RequestMapping("/v2/getData")
    public String getEmployeeDataV2(@RequestParam String empId , Model model) {
        int id = Integer.parseInt( empId );
        System.out.println("Data : "+id);

        Employee employee = repo.getEmployeeData(id);
        model.addAttribute("Data",employee);
        return "employeeView";
    }

    @RequestMapping("/v3/getData")
    public ModelAndView getEmployeeDataV3(@RequestParam String empId , ModelAndView mv) {
        int id = Integer.parseInt( empId );
        System.out.println("Data : "+id);

        Employee employee = repo.getEmployeeData(id);
        mv.addObject("Data" , employee);

        mv.setViewName("employeeView");
        return mv;
    }
    /*
     * We can specify ModelAttribute If needed / Else spring will automatically inject the annotation to Employee Object
     */
    @RequestMapping("/v4/addData")
    public ModelAndView addEmployeeData(@ModelAttribute Employee employee, ModelAndView mv) {

//  public ModelAndView addEmployeeData(@RequestParam String empId , @RequestParam String name , ModelAndView mv ) {

//        int id = Integer.parseInt( empId );
//        Employee employee = new Employee(id,name);

        repo.addEmployeeData(employee);

        mv.addObject("Data","Result added successfully !");
        mv.setViewName("employeeView");

        return mv;
    }
}
