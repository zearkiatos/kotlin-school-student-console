package com.schoolstudentsystem.console.student.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test

class StudentUnitTest {

    @Test
    fun `Given a student class When it is created Then it should show correct properties`() {
        // Given
        val id = 1
        val name = "John Doe"
        val grade = 85.5

        // When
        val student = Student(id, name, grade)

        // Then
        assertEquals(id, student.id)
        assertEquals(name, student.name)
        assertEquals(grade, student.grade, 0.0)
    }
}