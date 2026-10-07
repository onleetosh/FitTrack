package com.onleetosh.fittrack.model

/**
 * Represents an exercise and its associated training information.
 *
 * @property id Unique identifier for the exercise.
 * @property category Category of the exercise (e.g., strength, cardio).
 * @property name Display name of the exercise.
 * @property difficulty Difficulty level of the exercise.
 * @property instructPreview Brief summary of the exercise instructions.
 * @property instruct Ordered list of detailed steps for performing the exercise.
 * @property trainingLength Estimated training duration in minutes.
 */
data class Exercise(
    val id: String,
    val category: String,
    val name: String,
    val difficulty: Difficulty,
    val instructPreview: String,
    val instruct: List<String>,
    val trainingLength: Int
)

/**
 * Defines the available difficulty levels for an exercise.
 */
enum class Difficulty {
    Novice,
    Intermediate,
    Expert
}

