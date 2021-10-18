package com.bjpowdernode.service.impl;

import com.bjpowdernode.dao.StudentDao;
import com.bjpowdernode.domain.Student;
import com.bjpowdernode.service.StudentService;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gjd
 * @create 2021/10/13  17:41:09
 */
@Service
public class StudentServiceImpl implements StudentService {
    //引用类型自动注入，可使用@Autowired @Resource

    @Autowired
    private StudentDao studentDao;

    @Override
    public int insertStudent(Student student) {

        int rows = studentDao.insertStudent(student);

        return rows ;
    }

    @Override
    public List<Student> findStudents() {

        List<Student> students = studentDao.selectStudents();

        return students;
    }
}
