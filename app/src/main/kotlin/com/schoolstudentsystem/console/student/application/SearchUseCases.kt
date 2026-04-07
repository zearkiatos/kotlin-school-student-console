package com.schoolstudentsystem.console.student.application

import com.schoolstudentsystem.console.student.application.dto.StudentResponse
import com.schoolstudentsystem.console.student.application.mapper.toResponse
import com.schoolstudentsystem.console.student.application.ports.input.SearchStudentInputPort
import com.schoolstudentsystem.console.student.domain.StudentRepository

class SearchUseCases(val studentRepository: StudentRepository) : SearchStudentInputPort {

    override fun searchByName(name: String): StudentResponse? {
        if (name.isBlank()) return null
        return studentRepository.searchInStudents(name.trim())?.toResponse()
    }

    override fun searchById(id: Int): StudentResponse? {
        try {
            val student = studentRepository.getStudentById(id)
            return student.toResponse()
        } catch (e: NoSuchElementException) {
            return null
        }
    }
}