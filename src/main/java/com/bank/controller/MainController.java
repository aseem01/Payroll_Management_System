package com.bank.controller;

import com.bank.dao.MainDao;
import com.bank.encryptor.Encryptor;
import com.bank.model.EmployeeRecord;
import com.bank.model.SalaryInfo;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Ashim Chakraborty
 */
@Controller
public class MainController {

    @Autowired(required = true)
    private RestTemplate template;

    @RequestMapping(value = "/")
    public String index() {
//        System.out.println("RECIEVED DATA : ");
//        String data = template.exchange("http://localhost:8084/dbblapi/", HttpMethod.GET, null, String.class).getBody();
//        System.out.println("RECIEVED DATA : " + data);
//        System.out.println("nglkdfngkl");
        return "index";
    }

    //INDEX PAGE Task Done
    //LOGIN Start Here
    MainDao defMod = new MainDao();

    @RequestMapping(value = "UserLogin", method = RequestMethod.POST)
    public String userLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest req, Model m) {
        String encryptedPassword = Encryptor.Encrypt(password);
        System.out.println("Email :" + username);
        System.out.println("Pass " + encryptedPassword);
        boolean login = defMod.checkLoginCredential(username, encryptedPassword);
        System.out.println("val " + login);

        if (login) {
            UserRecord user = defMod.loadUserInfo(username, encryptedPassword);
            if (user.getType().equals("Admin") && user.getStatus().equals("Active")) {
                System.out.println("true man");
                AdminController.craeteLoginSession(user, req);
                return "Admin/dashboard";
            } else if (user.getType().equals("HR") && user.getStatus().equals("Active")) {
                System.out.println("Def cont login ");
                return "HR/dashboard";
            } else if (user.getType().equals("HR") && user.getStatus().equals("Inactive")) {
                m.addAttribute("controllerReply", "You are not active.Access denied");
                return "index";
            } else if (user.getType().equals("Admin") && user.getStatus().equals("Inactive")) {
                m.addAttribute("controllerReply", "Access denied ! You are not active.");
                return "index";
            } else {
                m.addAttribute("controllerReply", "Wrong email or password");
            }
            return "index";
        } else {

            m.addAttribute("controllerReply", "Wrong email or password");
            return "index";
        }

    }

    //LOGIN PAGE Task Done
    //ADMIN Task Start Here
    @RequestMapping(value = "dasboard", method = RequestMethod.GET)
    public String DashBoard() {
        System.out.println("Admin Controller call");
        return "Admin/dashboard";
    }

    @RequestMapping(value = "EmployeeSalarySearch", method = RequestMethod.GET)
    public String EmployeeSalarySearchMethod() {
        System.out.println("kjfjgldfjlgjdflgjdflgjlkdfjglkdfjglkdfjlgkj");
        return "Admin/SearchEmployeeSalary";
    }

    @RequestMapping(value = "ViewEmployeeSalary", method = RequestMethod.POST)
    public String VIewEmployeeSalary(@RequestParam(value = "viewsearch") String viewsearch,
            @RequestParam(value = "DesignationEmployee") String DesignationEmployee, @RequestParam(value = "Employeeid") String Employeeid, HttpServletRequest request, Model m) {
        System.out.println("yes..........");
        System.out.println("viewsearch : " + viewsearch);
        System.out.println("DesignationEmployee : " + DesignationEmployee);
        System.out.println("Employeeid : " + Employeeid);
        if (!Employeeid.isEmpty()) {
            System.out.println("inside");
            try {
                EmployeeRecord emp = template.exchange("http://localhost:9090/dbblapi/employeeSalaryById?id=" + Employeeid, HttpMethod.GET, null, EmployeeRecord.class).getBody();
                System.out.println("EMP FRONT :" + emp.getName());
                m.addAttribute("emp", emp);
            } catch (Exception e) {
                m.addAttribute("error", "Something is wrong");
                return "Admin/SearchEmployeeSalary";
            }
            return "Admin/ViewEmployeeList";
        } else {
            try {
                List<EmployeeRecord> empList = template.exchange("http://localhost:9090/dbblapi/employeeSalaryByDesignation?id=" + DesignationEmployee, HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeRecord>>() {
                }).getBody();
                m.addAttribute("list", empList);
                for (int i = 0; i < empList.size(); i++) {
                    System.out.println("emplist : " + empList.get(i));
                }
                return "Admin/ViewListDesignation";
            } catch (Exception e) {
                m.addAttribute("error", "Something is wrong");
                return "Admin/SearchEmployeeSalary";
            }
        }
    }

    @RequestMapping(value = "TopTenSalaryEmployee", method = RequestMethod.GET)
    public String TopTenSalary(Model m) throws Exception {
        System.out.println("=========================");
        try {
            List<EmployeeRecord> empList = template.exchange("http://localhost:9090/dbblapi/getToptensalary", HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeRecord>>() {
            }).getBody();
            for (EmployeeRecord emp : empList) {
                System.out.println("payroll " + emp.getName() + " Designation :" + emp.getDesignation() + "salary : " + emp.getTotal());
            }
            m.addAttribute("emp", empList);
            return "Admin/TopTenSalary";
        } catch (Exception e) {
            m.addAttribute("error", "Something is wrong");
            return "Admin/dasboard";
        }

//        HttpHeaders head = new HttpHeaders();
//        head.setContentType(MediaType.APPLICATION_JSON);
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(empList);
//        HttpEntity<String> req = new HttpEntity(jsonString, head);
//        //template.exchange("", HttpMethod.GET, HttpEntity.EMPTY, responseType)
//        Boolean send = template.exchange("http://localhost:8084/dbblapi/addEmpList", HttpMethod.POST, req, Boolean.class).getBody();
//
//        System.out.println("DATA SENT : " + send);
    }
    //ADMIN PAGE Task Done
    //HR PAGE Task Start

    @RequestMapping(value = "dasboardHR", method = RequestMethod.GET)
    public String DashBoardHR() {
        System.out.println("HR");
        return "HR/dashboard";
    }

    @RequestMapping(value = "EndUserAdd", method = RequestMethod.GET)
    public String endUserGetSalaryInfo(Model m) {
        System.out.println("=========================");
        try {
            List<SalaryInfo> empList = template.exchange("http://localhost:9090/dbblapi/getSalaryInfo", HttpMethod.GET, null, new ParameterizedTypeReference<List<SalaryInfo>>() {
            }).getBody();
            for (SalaryInfo emp : empList) {
                System.out.println("Salary Id " + emp.getSalaryId() + " Designation :" + emp.getDesignation() + "salary : " + emp.getBasicSalary());
            }
            m.addAttribute("emp", empList);

            return "HR/EndUserAdd";
        } catch (Exception e) {
            m.addAttribute("error", "Something is wrong");
            return "HR/dashboard";
        }

    }

    @RequestMapping(value = "AddEmployeeForm", method = RequestMethod.POST)
    public String endUserAdd(@ModelAttribute(value = "EmployeeRecord") EmployeeRecord employee, Model m, @RequestParam(value = "designation") String salId) {
        System.out.println("=========================Form Submit");
        Boolean send = false;
        SalaryInfo sal = new SalaryInfo();
        sal.setSalaryId(Long.parseLong(salId));
        employee.setSalary(sal);

        try {
            HttpHeaders head = new HttpHeaders();
            head.setContentType(MediaType.APPLICATION_JSON);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(employee);
            HttpEntity<String> req = new HttpEntity(jsonString, head);
            System.out.println("employee :" + jsonString);
            //template.exchange("", HttpMethod.GET, HttpEntity.EMPTY, responseType)
            send = template.exchange("http://localhost:9090/dbblapi/addEmpList", HttpMethod.POST, req, Boolean.class).getBody();

        } catch (Exception e) {

        }
        if (send) {
            m.addAttribute("error", "You Successfully Added");

            return "HR/dashboard";
        } else {
            m.addAttribute("error", "Something is wrong");
            return "HR/dashboard";
        }

    }

    @RequestMapping(value = "EndUserView", method = RequestMethod.GET)
    public String endUserView(Model m) {
        try {
            List<EmployeeRecord> empList = template.exchange("http://localhost:9090/dbblapi/viewAllEmpList", HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeRecord>>() {
            }).getBody();
            for (EmployeeRecord emp : empList) {
                System.out.println("Acc " + emp.getAccNo() + " Designation :" + emp.getDesignation() + "salary : " + emp.getBasicSalary());
            }
            m.addAttribute("emp", empList);

            return "HR/EndUserView";
        } catch (Exception e) {
            m.addAttribute("error", "Something is wrong");
            System.out.println("error : " + e.toString());
            return "HR/dashboard";
        }

    }

    @RequestMapping(value = "EndUserEmployeeInfo", method = RequestMethod.GET)
    public String endUserEmployeeAllInfoView(Model m) {
        try {
            List<EmployeeRecord> empList = template.exchange("http://localhost:9090/dbblapi/viewAllEmpList", HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeRecord>>() {
            }).getBody();
            for (EmployeeRecord emp : empList) {
                System.out.println("Acc " + emp.getAccNo() + " Designation :" + emp.getDesignation() + "salary : " + emp.getBasicSalary());
            }
            m.addAttribute("emp", empList);

            return "HR/EndUserViewAllEmployee";
        } catch (Exception e) {
            m.addAttribute("error", "Something is wrong");
            System.out.println("error : " + e.toString());
            return "HR/dashboard";
        }

    }
//    
//     @RequestMapping(value = "UpdateEmployeeInformation", method = RequestMethod.GET)
//    public String endUserUpdateEmployeeView(@RequestParam(value = "empId") String empId,Model m) {
//         try {
//               EmployeeRecord empRecord = template.exchange("http://localhost:9090/dbblapi/getEmployeeRecord?empId= "+empId, HttpMethod.GET, null, EmployeeRecord.class).getBody();
//                m.addAttribute("empRecord", empRecord);
//                
//                return "HR/EndUserViewAllEmployee";
//            } catch (Exception e) {
//                m.addAttribute("error", "Something is wrong");
//                return "HR/dasboard";
//            }
//
//    }

    @RequestMapping(value = "UpdateEmployeeInformation", method = RequestMethod.GET)
    public String endUserUpdateEmployeeView(@RequestParam(value = "empId") String empId, Model m) {
        try {
            System.out.println("HI : "+empId);
            EmployeeRecord empRecord = template.exchange("http://localhost:9090/dbblapi/getEmployeeRecord?empId=" + empId, HttpMethod.GET, null, EmployeeRecord.class).getBody();
            m.addAttribute("empRecord", empRecord);

            System.out.println("name : " + empRecord.toString());
            System.out.println("Acc : " + empRecord.getAccNo());
            System.out.println("Designation : " + empRecord.getDesignation());
            System.out.println("Education : " + empRecord.getEducation());

            //for Designation FROM Salary Table Data
            List<SalaryInfo> empList = template.exchange("http://localhost:9090/dbblapi/getSalaryInfo", HttpMethod.GET, null, new ParameterizedTypeReference<List<SalaryInfo>>() {
            }).getBody();
            for (SalaryInfo emp : empList) {
                System.out.println("Salary Id " + emp.getSalaryId() + " Designation :" + emp.getDesignation() + "salary : " + emp.getBasicSalary());
            }
            m.addAttribute("emp", empList);

            return "HR/EndUserUpdate";
        } catch (Exception e) {
            m.addAttribute("error", "Something is wrong");
            return "HR/dasboard";
        }

    }
    
    @RequestMapping(value = "UpdateEmployeeInformation", method = RequestMethod.POST)
    public String endUserUpdate(@ModelAttribute(value = "EmployeeRecord") EmployeeRecord employee, Model m, @RequestParam(value = "designation") String salId) {
        System.out.println("=========================Form Submit");
        Boolean send = false;
        SalaryInfo sal = new SalaryInfo();
        sal.setSalaryId(Long.parseLong(salId));
        employee.setSalary(sal);

        try {
            HttpHeaders head = new HttpHeaders();
            head.setContentType(MediaType.APPLICATION_JSON);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(employee);
            HttpEntity<String> req = new HttpEntity(jsonString, head);
            System.out.println("updateEmp :" + jsonString);
            //template.exchange("", HttpMethod.GET, HttpEntity.EMPTY, responseType)
            send = template.exchange("http://localhost:9090/dbblapi/updateEmployee", HttpMethod.POST, req, Boolean.class).getBody();

        } catch (Exception e) {

        }
        if (send) {
            m.addAttribute("error", "You Successfully Added");

            return "redirect:/EndUserView";
        } else {
            m.addAttribute("error", "Something is wrong");
            return "HR/dashboard";
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();

        return "index";
    }

//    @RequestMapping(value = "TopTenSalaryEmployee", method = RequestMethod.GET)
//    public String TopTenSalaryEmp() {
//        System.out.println("RECIEVED DATA>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> : ");
//        return "Admin/TopTenSalary";
//    }
    //HR PAGE Task Done
    //GHOST CODE Start here
    @RequestMapping(value = "SalarEmployee", method = RequestMethod.GET)
    public String TopTen() {
        System.out.println("RECIEVED DATA : ");
        // SalaryInfo sal = template.exchange("http://localhost:8084/dbblapi/getSal", HttpMethod.GET, null, SalaryInfo.class).getBody();//Single object
        List<SalaryInfo> listSal = template.exchange("http://localhost:9090/dbblapi/getToptensalary", HttpMethod.GET, null, new ParameterizedTypeReference<List<SalaryInfo>>() {
        }).getBody();//List of object
        //System.out.println("RECIEVED DATA : " + sal.getBasicSalary() + sal.getSalaryId() + sal.getDesignation());
        for (int i = 0; i < listSal.size(); i++) {
            System.out.println("salary");
            System.out.println(listSal.get(i));
        }
        return "Admin/TopTenSalary";
    }

    @RequestMapping("/send")
    public String sendData() {
        System.out.println("RECIEVED DATA : ");
        SalaryInfo sal = template.exchange("http://localhost:9090/dbblapi/getSal", HttpMethod.GET, null, SalaryInfo.class).getBody();//Single object
        List<SalaryInfo> listSal = template.exchange("http://localhost:9090/dbblapi/getSal", HttpMethod.GET, null, new ParameterizedTypeReference<List<SalaryInfo>>() {
        }).getBody();//List of object
        System.out.println("RECIEVED DATA : " + sal.getBasicSalary() + sal.getSalaryId() + sal.getDesignation());
        return "index";
    }

}
