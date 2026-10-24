package com.lehman.fittrack.model
data class Exercise(
    val id: String,
    val category: String,
    val title: String,
    val difficultyTag: Difficulty,
    val instructPreview: String,
    val instructions: List<String>,
    val recommendedDuration: Int
)
enum class Difficulty { Novice, Intermediate, Expert }

val exercisesByCategory = mapOf(
    "Cardio" to listOf(
        Exercise(
            "",
            "",
            "",
            Difficulty.Novice,
            "",
            listOf(
                "",
                ),
            5
        ),
        Exercise(
            "",
            "",
            "",
            Difficulty.Intermediate,
            "",
            listOf(),
            5
        ),
        Exercise(
            "",
            "",
            "",
            Difficulty.Expert,
            "",
            listOf(),
            5
        )
    ),

    "Strength" to listOf(
        Exercise(
            "",
            "",
            "",
            Difficulty.Novice,
            "",
            listOf(
                "",
            ),
            5
        ),
        Exercise(
            "",
            "",
            "",
            Difficulty.Intermediate,
            "",
            listOf(),
            5
        ),
        Exercise(
            "",
            "",
            "",
            Difficulty.Expert,
            "",
            listOf(),
            5
        )
    ),

    "Balance" to listOf(
        Exercise(
            "",
            "",
            "",
            Difficulty.Novice,
            "",
            listOf(
                "",
            ),
            5
        ),
        Exercise(
            "",
            "",
            "",
            Difficulty.Intermediate,
            "",
            listOf(),
            5
        ),
        Exercise(
            "",
            "",
            "",
            Difficulty.Expert,
            "",
            listOf(),
            5
        )
    ),

    "Flexibility" to listOf(
        Exercise(
            "",
            "",
            "",
            Difficulty.Novice,
            "",
            listOf(
                "",
                ""
            ),
            5
        ),
        Exercise(
            "",
            "",
            "",
            Difficulty.Intermediate,
            "",
            listOf(),
            5
        ),
        Exercise(
            "",
            "",
            "",
            Difficulty.Expert,
            "",
            listOf(),
            5
        )
    )
)
