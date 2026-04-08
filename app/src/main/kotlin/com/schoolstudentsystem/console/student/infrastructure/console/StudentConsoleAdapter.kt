package com.schoolstudentsystem.console.student.infrastructure.console

import com.schoolstudentsystem.console.student.application.dto.CreateStudentRequest
import com.schoolstudentsystem.console.student.application.ports.input.CreateStudentInputPort
import com.schoolstudentsystem.console.student.application.ports.input.SearchStudentInputPort
import kotlin.io.readlnOrNull

class StudentConsoleAdapter(
        private val createPort: CreateStudentInputPort,
        private val searchPort: SearchStudentInputPort
) {

    fun run() {
        while (true) {
            println(
                    """
            What option do you want to select:
            1) create a student
            2) search student by id
            3) search student by name
            0) exit
            """.trimIndent()
            )

            val line = readlnOrNull()?.trim()
            if (line == "0") {
                break
            }

            when (line) {
                "1" -> handleCreate()
                "2" -> handleSearchById()
                "3" -> handleSearchByName()
                else -> println("Unknown command")
            }
        }
    }

    private fun handleCreate() {
        println("Enter student details (id name grade):")
        println("Type the user id:")
        val idInput = readlnOrNull()?.trim()
        println("Type the user name:")
        val nameInput = readlnOrNull()?.trim()
        println("Type the user grade:")
        val gradeInput = readlnOrNull()?.trim()

        if (idInput == null || nameInput == null || gradeInput == null) {
            println("All fields are required")
            return
        }

        val id = idInput.toIntOrNull()
        val grade = gradeInput.toDoubleOrNull()
        val name = nameInput

        if (id == null || grade == null) {
            println("Invalid id or grade")
            return
        }

        try {
            val created = createPort.add(CreateStudentRequest(id, name, grade))
            println("Created: $created")
        } catch (e: IllegalArgumentException) {
            println("Validation error: ${e.message}")
        }
    }

    private fun handleSearchById() {
        println("“Please, Enter the ID of the student")

        val id = readlnOrNull()?.trim()?.toIntOrNull()
        if (id == null) {
            println("Invalid ID")
            return
        }

        val student = searchPort.searchById(id)
        println(student ?: "Student not found")
    }

    private fun handleSearchByName() {
        println("Please, Enter the student's name")
        val name = readlnOrNull()?.trim()
        if (name.isNullOrEmpty()) {
            println("Usage: search-name <name>")
            return
        }

        val student = searchPort.searchByName(name)
        println(student ?: "Student not found")
    }
}
