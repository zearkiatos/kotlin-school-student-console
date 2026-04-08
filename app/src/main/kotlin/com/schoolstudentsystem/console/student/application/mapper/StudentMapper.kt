package com.schoolstudentsystem.console.student.application.mapper

import com.schoolstudentsystem.console.student.application.dto.CreateStudentRequest
import com.schoolstudentsystem.console.student.application.dto.StudentResponse
import com.schoolstudentsystem.console.student.domain.model.Student

fun CreateStudentRequest.toDomain(): Student {
    return Student(
        id = id,
        name = name.trim(),
        grade = grade
    )
}

fun Student.toResponse(): StudentResponse {
    return StudentResponse(
        id = id,
        name = name,
        grade = grade
    )
}