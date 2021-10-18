package com.bjpowdernode.service;

import com.bjpowdernode.domain.Student;

import java.util.List;

/**
 * @author gjd
 * @create 2021/10/13  17:32:22
 */
public interface StudentService {

    int insertStudent(Student student);

    List<Student> findStudents();
}
