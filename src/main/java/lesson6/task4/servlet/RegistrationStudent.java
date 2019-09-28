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

    private StudentServiceImpl studentService = new StudentServiceImpl(studentRepository,groupRepository,departmentRepository);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departments", DepartmentRepositoryImpl.getIdToDepartment());
        req.setAttribute("groups", GroupRepositoryImpl.getIdToGroup());
        req.getRequestDispatcher("/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name, surName, nameStreet, phone, birthday, numApartment;
        if (studentService.checkWithRegExp(req.getParameter("name"), REGEX_FOR_NAME))
            name = req.getParameter("name");
        else throw new IllegalArgumentException();
        if (studentService.checkWithRegExp(req.getParameter("secondName"), REGEX_FOR_NAME))
            surName = req.getParameter("secondName");
        else throw new IllegalArgumentException();
        if (studentService.checkWithRegExp(req.getParameter("nameStreet"), REGEX_FOR_NAME))
            nameStreet = req.getParameter("nameStreet");
        else throw new IllegalArgumentException();
        if (studentService.checkWithRegExp(req.getParameter("numberApartment"), REGEX_FOR_NUMBER))
            numApartment = req.getParameter("numberApartment");
        else throw new IllegalArgumentException();
        if (studentService.checkWithRegExp(req.getParameter("phone"), REGEX_FOR_PHONE_NUMBER))
            surName = req.getParameter("phone");
        else throw new IllegalArgumentException();
        if (studentService.checkWithRegExp(req.getParameter("birthday"), REGEX_FOR_BIRTHDAY))
            birthday = req.getParameter("birthday");
        else throw new IllegalArgumentException();

        Student student = Student.builder().withName(name)
                .withSurname(surName)
                .withAddress(new Address(nameStreet, parseInt(numApartment)))
                .withPhoneNumber(numApartment)
                .withBirthday(LocalDate.parse(birthday))
                .withGroup(studentService.findGroupById(Long.valueOf(req.getParameter("group"))))
                .withDepartment(studentService.findDepartmentByGroupId(Long.valueOf(req.getParameter("group"))))
                .build();
        studentService.register(student);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/menu"));
    }
}
