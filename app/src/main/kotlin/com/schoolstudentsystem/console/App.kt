package com.schoolstudentsystem.console

import com.schoolstudentsystem.console.student.application.CreateUseCases
import com.schoolstudentsystem.console.student.application.SearchUseCases
import com.schoolstudentsystem.console.student.infrastructure.console.StudentConsoleAdapter
import com.schoolstudentsystem.console.student.infrastructure.databases.InMemoryStudentRepository

fun main() {
    val repository = InMemoryStudentRepository()
    val createUseCases = CreateUseCases(repository)
    val searchUseCases = SearchUseCases(repository)

    val console = StudentConsoleAdapter(
        createPort = createUseCases,
        searchPort = searchUseCases
    )

    console.run()
}
