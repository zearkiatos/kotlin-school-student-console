package com.schoolstudentsystem.console.student.application.dto

data class CreateStudentRequest(
    val id: Int,
    val name: String,
    val grade: Double
)