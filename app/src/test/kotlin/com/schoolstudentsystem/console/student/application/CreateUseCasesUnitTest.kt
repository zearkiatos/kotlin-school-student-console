package com.schoolstudentsystem.console.student.application

import com.schoolstudentsystem.console.student.domain.StudentRepository
import com.schoolstudentsystem.console.student.domain.model.Student
import com.schoolstudentsystem.console.student.infrastructure.mock.MockStudentRepository
import com.schoolstudentsystem.console.student.application.dto.CreateStudentRequest
import org.junit.Assert.assertTrue
import org.junit.Test

class CreateUseCasesUnitTest {

    private val studentRepository: StudentRepository = MockStudentRepository()

    @Test
    fun `Given a student repository When add a student Then the student should be added to the repository`() {
        val studentRepository = MockStudentRepository()
        val createUseCases = CreateUseCases(studentRepository)
        val student = Student(1, "John Doe", 85.5)
        val request = CreateStudentRequest(student.id, student.name, student.grade)

        createUseCases.add(request)

        assertTrue(studentRepository.get().contains(student))
    }
}