package com.schoolstudentsystem.console.student.infrastructure.mock

import com.schoolstudentsystem.console.student.domain.StudentRepository
import com.schoolstudentsystem.console.student.domain.model.Student

class MockStudentRepository: StudentRepository {
    private val students = mutableListOf<Student>()

    override fun create(student: Student) {
        students.add(student)
    }

    override fun get(): List<Student> {
        return students
    }

    override fun getStudentById(id: Int): Student {
        if (!students.any { it.id == id }) {
            throw NoSuchElementException("Student with id $id not found")
        }
        return students.first { it.id == id }
    }

    override fun searchInStudents(name: String): Student? {
        return students.firstOrNull { it.name == name }
    }
}