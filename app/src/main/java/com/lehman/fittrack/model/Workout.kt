package com.lehman.fittrack.model

data class Workout(
    val id: String,
    val title: String,
    val category: String,
    val data: Long,
    val durationMinutes: Long
)