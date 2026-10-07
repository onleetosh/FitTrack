package com.onleetosh.fittrack.ui.viewModel

import android.health.connect.datatypes.units.Length
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.onleetosh.fittrack.model.Exercise
import com.onleetosh.fittrack.model.Workout

/**
 * ViewModel for managing the state of the workout logging feature.
 * It holds the current UI state and provides methods to update it.
 */
data class WorkoutUiState (
    val logActive: List<Workout> = emptyList(),
    val durationInput: String = "",
    val isLogged: Boolean = false
)

/**
 * ViewModel class for managing workout logging state.
 * Acts as the connection between the UI and the workout data.
 * Provides methods to update the duration input, log workouts, and manage the logged state.
 */
class WorkoutViewModel: ViewModel() {

    // sets the uiState to be private, so it can only be modified within this ViewModel
    var uiState by mutableStateOf(WorkoutUiState())
        private set

    /**
     * Updates the duration input in the UI state.
     * @param input The new duration input as a string.
     */
    fun updateDuration(input: String) {
        uiState = uiState.copy( durationInput = input)
    }

    /**
     * Logs a workout based on the provided exercise and the current duration input.
     * @param drill The exercise to log.
     */
    fun loggedWorkout(drill: Exercise) {

        // Validate the duration input and convert it to a Long.
        val length = uiState.durationInput.toLongOrNull() ?: return

        // If the length is less than or equal to zero, Do not log the workout
        if (length <= 0) return


        // Create a new Workout object
        val work = Workout(
            id ="workout-${System.nanoTime()}",
            name = drill.name,
            category = drill.category,
            date = System.currentTimeMillis(),
            duration = length
        )
        // Update the UI state after logging the workout
        uiState = uiState.copy(
            logActive = listOf(work) + uiState.logActive,
            durationInput = "",
            isLogged = true
        )
    }

    /**
     * Dismisses the logged state by setting isLogged to false
     * hiding the workout confirmation dialog.
     */
    fun isLoggedDismiss(){
        uiState = uiState.copy( isLogged = false )
    }

    /**
     * Removes all logged workouts and resets the UI state back to its default values.
     */
    fun clearLoggedWorkout(){
        uiState = WorkoutUiState()
    }

}