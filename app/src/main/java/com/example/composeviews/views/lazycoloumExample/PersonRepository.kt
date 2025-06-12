package com.example.composeviews.views.lazycoloumExample

class PersonRepository {
    fun getAllData(): List<DataPerson> {
        return listOf(
            DataPerson(
                id = 0,
                firstName = "John",
                lastName = "Doe",
                age = 20
            ),
            DataPerson(
                id = 1,
                firstName = "Maria",
                lastName = "Garcia",
                age = 21
            ),
            DataPerson(
                id = 2,
                firstName = "James",
                lastName = "Johnson",
                age = 22
            ),
            DataPerson(
                id = 3,
                firstName = "Michael",
                lastName = "Brown",
                age = 23
            ),
            DataPerson(
                id = 4,
                firstName = "Robert",
                lastName = "Davis",
                age = 24
            ),
            DataPerson(
                id = 5,
                firstName = "Jenifer",
                lastName = "Miller",
                age = 25
            ),
            DataPerson(
                id = 6,
                firstName = "Sarah",
                lastName = "Lopez",
                age = 26
            ),
            DataPerson(
                id = 7,
                firstName = "Charles",
                lastName = "Wilson",
                age = 27
            ),
            DataPerson(
                id = 8,
                firstName = "Daniel",
                lastName = "Taylor",
                age = 28
            ),
            DataPerson(
                id = 9,
                firstName = "Mark",
                lastName = "Lee",
                age = 29
            ),
        )
    }
}