package com.bjpowdernode.dao;

import com.bjpowdernode.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gjd
 * @create 2021/10/13  17:24:03
 */
@Repository
public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
