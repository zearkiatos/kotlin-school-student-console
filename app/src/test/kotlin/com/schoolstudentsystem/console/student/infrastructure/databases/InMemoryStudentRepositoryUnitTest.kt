package com.schoolstudentsystem.console.student.infrastructure.databases

import com.schoolstudentsystem.console.student.domain.StudentRepository
import com.schoolstudentsystem.console.student.domain.model.Student
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class InMemoryStudentRepositoryUnitTest { 
    private val repository: InMemoryStudentRepository = InMemoryStudentRepository()

    @Test
    fun `Given a student repository When a student is created Then it should be stored in the repository`() {
        val student = Student(1, "John Doe", 85.5)
        
        repository.create(student)

        val retrievedStudent = repository.getStudentById(1)
        assertEquals(student, retrievedStudent)
    }

    @Test
    fun `Given a student repository When call the get function Then it should return a list of students`() {
        val student = Student(1, "John Doe", 85.5)
        repository.create(student)

        val students = repository.get()

        assertEquals(1, students.size)
        assertEquals(student, students[0])
    }

    @Test
    fun `Given a student repository When search student by name Then it should return a specifict student`() {
        val student = Student(1, "John Doe", 85.5)
        repository.create(student)

        val retrievedStudent = repository.searchInStudents("John")

        assertEquals(student, retrievedStudent)
    }
}