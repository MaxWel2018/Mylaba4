package lesson6.task4.servlet;

import lesson6.task4.domain.Address;
import lesson6.task4.domain.Department;
import lesson6.task4.domain.Student;
import lesson6.task4.domain.University;
import lesson6.task4.repository.StudentRepositoryImpl;
import lesson6.task4.service.StudentService;
import lesson6.task4.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

@WebServlet("/register")
public class RegistrationStudent extends HttpServlet {
    StudentRepositoryImpl studentRepository = StudentRepositoryImpl.getInstance();// TODO Удалить
    University university = University.getInstance();
    StudentService studentService = new StudentServiceImpl(studentRepository);
    StudentRepositoryImpl repository = StudentRepositoryImpl.getInstance();// TODO Удалить

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listDepartment", university.getDepartments());
        req.setAttribute("listGroup", university.getGroupByDepartment());
        req.getRequestDispatcher("/views/registration.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = Student.builder().withName(req.getParameter("name"))
                .withSurname(req.getParameter("secondName"))
                .withAddress(new Address(req.getParameter("nameStreet"),
                        parseInt(req.getParameter("numberApartment"))))
                .withPhoneNumber(req.getParameter("phone"))
                .withBirthday(LocalDate.parse(req.getParameter("birthday")))
                .withDepartment(new Department(Long.parseLong(req.getParameter("id")),req.getParameter("department")))
                .build();
        studentService.register(student);
        Student student2 = repository.findById((long) 1); // TODO Удалить
        System.out.println(student);  // TODO Удалить
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/menu"));
    }
}
