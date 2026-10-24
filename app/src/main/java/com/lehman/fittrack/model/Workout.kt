package com.lehman.fittrack.model

import java.sql.Date

data class Workout(
    val id: String,
    val title: String,
    val category: String,
    val date: Long,
    val durationMinutes: Long
)