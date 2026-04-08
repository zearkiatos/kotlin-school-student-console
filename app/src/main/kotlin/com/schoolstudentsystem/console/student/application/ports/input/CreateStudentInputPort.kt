package com.schoolstudentsystem.console.student.application.ports.input

import com.schoolstudentsystem.console.student.application.dto.CreateStudentRequest
import com.schoolstudentsystem.console.student.application.dto.StudentResponse

interface CreateStudentInputPort {
    fun add(request: CreateStudentRequest): StudentResponse
}