package Controller;

import Model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import service.StudentServiceImpl;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                updateStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                response.sendRedirect("/student");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewStudent(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double score = Double.parseDouble(request.getParameter("score"));
        int id = (int) (Math.random() * 10000);

        Student student = new Student(id, name, score);
        studentService.save(student);
        request.setAttribute("message", "New student was created");

        RequestDispatcher dispatcher = request.getRequestDispatcher("src/main/webapp/student/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double score = Double.parseDouble(request.getParameter("score"));

        Student student = studentService.findById(id);
        if (student == null) {
            response.sendRedirect("error-404.jsp");
        } else {
            student.setName(name);
            student.setScore(score);
            studentService.update(id, student);

            request.setAttribute("student", student);
            request.setAttribute("message", "Student information was updated");

            RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);

        if (student == null) {
            response.sendRedirect("error-404.jsp");
        } else {
            studentService.remove(id);
            try {
                response.sendRedirect("/student");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);

        if (student == null) {
            response.sendRedirect("error-404.jsp");
        } else {
            request.setAttribute("student", student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student/view.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);

        if (student == null) {
            response.sendRedirect("error-404.jsp");
        } else {
            request.setAttribute("student", student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);

        if (student == null) {
            response.sendRedirect("error-404.jsp");
        } else {
            request.setAttribute("student", student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student/delete.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.findAll();
        request.setAttribute("student", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(request, response);
    }
}
