package com.schoolstudentsystem.console.student.application

import com.schoolstudentsystem.console.student.domain.StudentRepository
import com.schoolstudentsystem.console.student.domain.model.Student
import com.schoolstudentsystem.console.student.infrastructure.mock.MockStudentRepository
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SearchUseCasesUnitTest {

    @Test
    fun `Given a student repository When search for a student Then the student should be found`() {
        val studentRepository = MockStudentRepository()
        val searchUseCases = SearchUseCases(studentRepository)
        val student = Student(1, "John Doe", 85.5)

        studentRepository.create(student)

        val foundStudent = searchUseCases.searchByName("John Doe")

        assertEquals(student, foundStudent)
    }

    @Test
    fun `Given a student repository When search for a student and it doesn't exist Then the student should not be found`() {
        val studentRepository = MockStudentRepository()
        val searchUseCases = SearchUseCases(studentRepository)

        val foundStudent = searchUseCases.searchByName("John Doe")

        assertNull(foundStudent)
    }

    @Test
    fun `Given a student repository When search for a student by id Then the student should be found`() {
        val studentRepository = MockStudentRepository()
        val searchUseCases = SearchUseCases(studentRepository)
        val student = Student(2, "John Doe", 85.5)

        studentRepository.create(student)

        val foundStudent = searchUseCases.searchById(2)

        assertEquals(student, foundStudent)
    }

    @Test
    fun `Given a student repository When search for a student by id and it doesn't exist Then the student should not be found`() {
        val studentRepository = MockStudentRepository()
        val searchUseCases = SearchUseCases(studentRepository)

        val foundStudent = searchUseCases.searchById(999)

        assertNull(foundStudent)
    }
}