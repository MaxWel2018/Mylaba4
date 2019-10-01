package lesson6.task4.servlet;

import lesson6.task4.domain.Address;
import lesson6.task4.domain.Student;
import lesson6.task4.repository.DepartmentRepository;
import lesson6.task4.repository.GroupRepository;
import lesson6.task4.service.StudentServiceImpl;
import lesson6.task4.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;
import static lesson6.task4.utility.RegexTemplate.*;
@WebServlet("/register")
public class RegistrationStudent extends AbstractServlet {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentServiceImpl studentService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departments", departmentRepository.getIdToDepartment());
        req.setAttribute("groups", groupRepository.getIdToGroup());
        req.setAttribute("REGEX_FOR_NAME",REGEX_FOR_NAME);
        req.setAttribute("REGEX_FOR_NUMBER",REGEX_FOR_NUMBER);
        req.setAttribute("REGEX_FOR_PHONE_NUMBER",REGEX_FOR_PHONE_NUMBER);
        req.getRequestDispatcher("/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidateService.userValidate(req.getParameterMap());

        Student student = Student.builder().withName(req.getParameter("name"))
                .withSurname(req.getParameter("secondName"))
                .withAddress(new Address(req.getParameter("nameStreet"), parseInt( req.getParameter("numberApartment"))))
                .withPhoneNumber(req.getParameter("phone"))
                .withBirthday(LocalDate.parse(req.getParameter("birthday")))
                .withGroup(studentService.findGroupById(Long.valueOf(req.getParameter("group"))))
                .withDepartment(studentService.findDepartmentByGroupId(Long.valueOf(req.getParameter("group"))))
                .build();
        studentService.register(student);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/menu"));
    }
}
