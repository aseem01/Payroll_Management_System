/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.controller;

import com.bank.model.UserRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ashim Chakraborty
 */
@Controller
@RequestMapping("/Admin/")
public class AdminController {

//    @Autowired(required = true)
//    private RestTemplate template;
    private static HttpSession session;

    @Autowired(required = true)
    private RestTemplate template;

    public static void craeteLoginSession(UserRecord user, HttpServletRequest req) {
        System.out.println("Session Created");
        System.out.println("name : " + user.getName());
        System.out.println("email : " + user.getEmail());
        user.setPassword("null");
        session = req.getSession();
        session.setAttribute("user", user);

    }

    public static boolean checkSession() {
        boolean login = false;
        UserRecord user;
        try {
            System.out.println("Checking session...");
            user = (UserRecord) session.getAttribute("user");
            if (user.getType().equals("Admin") && user.getStatus().equals("Active")) {
                login = true;
            } else {
                login = false;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            login = false;
        }

        return login;
    }

//    @RequestMapping(value = "EmployeeSalarySearch", method = RequestMethod.GET)
//    public String EmployeeSalarySearchMethod() {
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        return "Admin/SearchEmployeeSalary";
//    }
//
//    @RequestMapping(value = "dasboard", method = RequestMethod.GET)
//    public String DashBoard() {
//        System.out.println("Admin Controller call");
//        return "Admin/dashboard";
//    }
//
//    @RequestMapping(value = "TopTenSalaryEmployee", method = RequestMethod.GET)
//    public String TopTenSalary(Model m) throws Exception {
//        System.out.println("=========================");
//        try {
//            List<EmployeeRecordDto> empList = template.exchange("http://localhost:8084/dbblapi/getToptensalary", HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeRecordDto>>() {
//            }).getBody();
////            for (EmployeeRecordDto emp : empList) {
////                System.out.println("payroll " + emp.getName() + " Designation :" + emp.getDesignation() + "salary : " + emp.getTotal());
////            }
//            m.addAttribute("emp", empList);
//            return "Admin/TopTenSalary";
//        } catch (Exception e) {
//            m.addAttribute("error", "Something is wrong");
//            return "Admin/SearchEmployeeSalary";
//        }
//
////        HttpHeaders head = new HttpHeaders();
////        head.setContentType(MediaType.APPLICATION_JSON);
////        ObjectMapper mapper = new ObjectMapper();
////        String jsonString = mapper.writeValueAsString(empList);
////        HttpEntity<String> req = new HttpEntity(jsonString, head);
////        //template.exchange("", HttpMethod.GET, HttpEntity.EMPTY, responseType)
////        Boolean send = template.exchange("http://localhost:8084/dbblapi/addEmpList", HttpMethod.POST, req, Boolean.class).getBody();
////
////        System.out.println("DATA SENT : " + send);
//    }
//
//    @RequestMapping(value = "/ViewEmployeeSalary", method = RequestMethod.POST)
//    public String VIewEmployeeSalary(@RequestParam(value = "viewsearch") String viewsearch,
//            @RequestParam(value = "DesignationEmployee") String DesignationEmployee, @RequestParam(value = "Employeeid") String Employeeid, HttpServletRequest request, Model m) {
//
//        System.out.println("yes..........");
//        System.out.println("viewsearch : " + viewsearch);
//        System.out.println("DesignationEmployee : " + DesignationEmployee);
//        System.out.println("Employeeid : " + Employeeid);
//
//        if (!Employeeid.isEmpty()) {
//            System.out.println("inside");
//            try {
//                EmployeeRecordDto emp = template.exchange("http://localhost:9090/dbblapi/employeeSalaryById?id=" + Employeeid, HttpMethod.GET, null, EmployeeRecordDto.class).getBody();
//                System.out.println("EMP FRONT :" + emp.getName());
//                m.addAttribute("emp", emp);
//            } catch (Exception e) {
//                m.addAttribute("error", "Something is wrong");
//                return "Admin/SearchEmployeeSalary";
//            }
//
//            return "Admin/ViewEmployeeList";
//        } else {
//            try {
//                List<EmployeeRecordDto> empList = template.exchange("http://localhost:9090/dbblapi/employeeSalaryByDesignation?id=" + DesignationEmployee, HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeRecordDto>>() {
//                }).getBody();
//                m.addAttribute("list", empList);
//                for (int i = 0; i < empList.size(); i++) {
//                    System.out.println("emplist : " + empList.get(i));
//                }
//                return "Admin/ViewListDesignation";
//            } catch (Exception e) {
//                m.addAttribute("error", "Something is wrong");
//                return "Admin/SearchEmployeeSalary";
//            }
//        }
//
//        //return "Admin/ViewEmployeeList";
//    }

}
