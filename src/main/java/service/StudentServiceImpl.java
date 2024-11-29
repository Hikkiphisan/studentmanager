package service;


import Model.Student;

import java.util.*;

public class StudentServiceImpl implements StudentService {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<>();
        students.put(1, new Student(1, "Trần Minh Trí", 85.5));
        students.put(2, new Student(2, "Lê Tuấn Dũng", 92.0));
        students.put(3, new Student(3, "Nguyễn Đức Thắng", 78.0));
        students.put(4, new Student(4, "Đào Văn Huy Hưng", 88.5));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(id, student);
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }
}
