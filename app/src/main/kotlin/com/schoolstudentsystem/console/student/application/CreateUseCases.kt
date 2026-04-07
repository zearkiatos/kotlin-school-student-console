package com.schoolstudentsystem.console.student.application

import com.schoolstudentsystem.console.student.application.dto.CreateStudentRequest
import com.schoolstudentsystem.console.student.application.dto.StudentResponse
import com.schoolstudentsystem.console.student.application.mapper.toDomain
import com.schoolstudentsystem.console.student.application.mapper.toResponse
import com.schoolstudentsystem.console.student.application.ports.input.CreateStudentInputPort
import com.schoolstudentsystem.console.student.domain.StudentRepository

class CreateUseCases(private val studentRepository: StudentRepository) : CreateStudentInputPort {
    override fun add(request: CreateStudentRequest): StudentResponse {
        require(request.name.isNotBlank()) { "Name cannot be empty" }
        require(request.grade in 0.0..100.0) { "Grade must be between 0 and 100" }

        val student = request.toDomain()
        studentRepository.create(student)
        return student.toResponse()
    }
}