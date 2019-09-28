package lesson6.task4.servlet;

import lesson6.task4.domain.Address;
import lesson6.task4.domain.Student;
import lesson6.task4.repository.DepartmentRepositoryImpl;
import lesson6.task4.repository.GroupRepositoryImpl;
import lesson6.task4.repository.StudentRepository;
import lesson6.task4.repository.StudentRepositoryImpl;
import lesson6.task4.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;
import static lesson6.task4.utility.RegexTemplate.*;

@WebServlet("/register")
public class RegistrationStudent extends HttpServlet {
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private GroupRepositoryImpl groupRepository = new GroupRepositoryImpl();
    private DepartmentRepositoryImpl departmentRepository = new DepartmentRepositoryImpl();

    private StudentServiceImpl studentService = new StudentServiceImpl(studentRepository, groupRepository, departmentRepository);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departments", DepartmentRepositoryImpl.getIdToDepartment());
        req.setAttribute("groups", GroupRepositoryImpl.getIdToGroup());
        req.setAttribute("REGEX_FOR_NAME",REGEX_FOR_NAME);
        req.setAttribute("REGEX_FOR_NUMBER",REGEX_FOR_NUMBER);
        req.setAttribute("REGEX_FOR_PHONE_NUMBER",REGEX_FOR_PHONE_NUMBER);
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentService.userValidate(req.getParameterMap());

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
