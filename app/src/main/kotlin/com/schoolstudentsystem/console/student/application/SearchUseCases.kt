package com.schoolstudentsystem.console.student.application

import com.schoolstudentsystem.console.student.domain.StudentRepository
import com.schoolstudentsystem.console.student.domain.model.Student

class SearchUseCases(val studentRepository: StudentRepository) {

    fun searchByName(name: String): Student? {
        val student = studentRepository.searchInStudents(name)

        return student
    }

    fun searchById(id: Int): Student? {
        try {
            val student = studentRepository.getStudentById(id)

            return student
        } catch (e: NoSuchElementException) {
            return null
        }
    }
}