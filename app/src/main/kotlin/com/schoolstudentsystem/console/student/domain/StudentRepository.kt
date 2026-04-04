package com.schoolstudentsystem.console.student.domain

import com.schoolstudentsystem.console.student.domain.model.Student

interface StudentRepository {
    fun create(student: Student)
    fun get(): List<Student>
    fun getStudentById(id: Int): Student
    fun searchInStudents(name: String): Student?
}