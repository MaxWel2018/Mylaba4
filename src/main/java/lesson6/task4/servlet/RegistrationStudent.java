package lesson6.task4.servlet;

import lesson6.task4.domain.Address;
import lesson6.task4.domain.Student;
import lesson6.task4.repository.DepartmentRepositoryImpl;
import lesson6.task4.repository.GroupRepositoryImpl;
import lesson6.task4.repository.Repository;
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

@WebServlet("/register")
public class RegistrationStudent extends HttpServlet {
    private DepartmentRepositoryImpl departmentRepository = DepartmentRepositoryImpl.DEPARTMENT_REPOSITORY;
    private GroupRepositoryImpl groupRepository = GroupRepositoryImpl.GROUP_REPOSITORY;
    private StudentServiceImpl studentService = new StudentServiceImpl(StudentRepositoryImpl.STUDENT_REPOSITORY);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departments", DepartmentRepositoryImpl.getIdToDepartment());
        req.setAttribute("groups", GroupRepositoryImpl.getGROUPS());
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
                .withDepartment(departmentRepository.findById(Long.valueOf(req.getParameter("department"))).get())
                .withGroup(groupRepository.findById(Long.valueOf(req.getParameter("group"))).get())
                .build();
        studentService.register(student);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/menu"));
    }
}
