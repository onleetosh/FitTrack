package com.lehman.fittrack.ui.view

sealed class View(val path: String) {
    data object Dashboard: View("dashboard")
    data object ExerciseList: View("exercise_list")
    data object WorkoutDetail: View("workout_detail")

    companion object {
        const val CATEGORY = "category"
        const val WORKOUT_ID = "workoutId"
        val exerciseListPath = "${ExerciseList.path}/{$CATEGORY}"
        val workoutDetailPath = "${WorkoutDetail.path}/{$WORKOUT_ID}"
    }
}