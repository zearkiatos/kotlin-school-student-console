package com.schoolstudentsystem.console.student.infrastructure.databases

import com.schoolstudentsystem.console.student.domain.StudentRepository
import com.schoolstudentsystem.console.student.domain.model.Student

class InMemoryStudentRepository: StudentRepository {
    private val students = HashMap<Int, Student>()

    override fun create(student: Student) {
        students[student.id] = student
    }

    override fun get(): List<Student> {
        return students.values.toList()
    }

    override fun getStudentById(id: Int): Student {
        return students[id] ?: throw NoSuchElementException("Student with id $id not found")
    }

    override fun searchInStudents(name: String): Student? {
        return students.values.find { it.name.contains(name, ignoreCase = true) }
    }

}
