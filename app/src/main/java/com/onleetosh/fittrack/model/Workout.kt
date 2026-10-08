package com.onleetosh.fittrack.model

/**
 * Represents a workout session with its details.
 *
 * @property id Unique identifier for the workout.
 * @property name Display title of the workout.
 * @property category Category of the workout (e.g., strength, cardio).
 * @property date Timestamp representing when the workout took place.
 * @property duration Recommended duration of the workout in milliseconds.
 */
 
data class Workout(
    val id: String,
    val name: String,
    val category: String,
    val date: Long,
    val duration: Long,
)
