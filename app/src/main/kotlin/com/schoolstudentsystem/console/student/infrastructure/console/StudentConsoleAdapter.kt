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
        val exit = false
        while (exit == false) {
           
            val line = readlnOrNull()?.trim().orEmpty()
            if (line.equals("exit", ignoreCase = true)) break
            if (line.isEmpty()) continue

            val parts = line.split(" ")
            when (parts.firstOrNull()?.lowercase()) {
                "create" -> handleCreate(parts)
                "search-id" -> handleSearchById(parts)
                "search-name" -> handleSearchByName(parts)
                else -> println("Unknown command")
            }
        }
    }

    private fun handleCreate(parts: List<String>) {
        if (parts.size < 4) {
            println("Usage: create <id> <name> <grade>")
            return
        }

        val id = parts[1].toIntOrNull()
        val grade = parts.last().toDoubleOrNull()
        val name = parts.subList(2, parts.size - 1).joinToString(" ")

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

    private fun handleSearchById(parts: List<String>) {
        val id = parts.getOrNull(1)?.toIntOrNull()
        if (id == null) {
            println("Usage: search-id <id>")
            return
        }

        val student = searchPort.searchById(id)
        println(student ?: "Student not found")
    }

    private fun handleSearchByName(parts: List<String>) {
        val name = parts.drop(1).joinToString(" ").trim()
        if (name.isEmpty()) {
            println("Usage: search-name <name>")
            return
        }

        val student = searchPort.searchByName(name)
        println(student ?: "Student not found")
    }
}