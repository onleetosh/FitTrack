package com.lehman.fittrack.ui.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.lehman.fittrack.model.*

data class WorkoutUiState(
    val logActivity: List<Workout> = emptyList(),
    val durationInput: String = "",
    val logState: Boolean = false
)

class WorkoutViewModel: ViewModel() {

    var uiState by mutableStateOf(WorkoutUiState())
        private set

    fun updateDuration(input: String) {
        uiState = uiState.copy( durationInput = input )
    }

    fun logWorkout(exercise: Exercise) {
        val duration = uiState.durationInput.toLongOrNull() ?: return
        if(duration <= 0) return

        val work = Workout(
            id = "workout-" + System.nanoTime(),
            title = exercise.title,
            category =  exercise.category,
            date = System.currentTimeMillis(),
            durationMinutes = duration
        )

        uiState = uiState.copy(
            logActivity = listOf(work) + uiState.logActivity,
            durationInput = "",
            logState = true
        )
    }

    fun isLoggedDismiss(){
        uiState = uiState.copy( logState = false )
    }

    fun clearLoggedActivity(){
        uiState = WorkoutUiState()
    }
}