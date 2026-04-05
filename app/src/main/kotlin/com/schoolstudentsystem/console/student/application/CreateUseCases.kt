package com.schoolstudentsystem.console.student.application

import com.schoolstudentsystem.console.student.domain.StudentRepository
import com.schoolstudentsystem.console.student.domain.model.Student

class CreateUseCases(val studentRepository: StudentRepository) {
    fun add(student: Student) {
        studentRepository.create(student)
    }
}