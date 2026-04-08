package com.schoolstudentsystem.console.student.application.ports.input

import com.schoolstudentsystem.console.student.application.dto.StudentResponse

interface SearchStudentInputPort {
    fun searchByName(name: String): StudentResponse?
    fun searchById(id: Int): StudentResponse?
}