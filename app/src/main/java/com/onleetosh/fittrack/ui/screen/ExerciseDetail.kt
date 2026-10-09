package com.onleetosh.fittrack.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.onleetosh.fittrack.model.Exercise

@Composable
fun ExerciseDetailForm(
    drill: Exercise,
    durationInput: String,
    showLogConfirmed: Boolean,
    onDurationUpdate: (String) -> Unit,
    onLogActivity: () -> Unit,
    onBack: () -> Unit
){
    //TODO: display exercise information
}

@Composable
private fun ExerciseDetailTopBar(title: String, onBack: () -> Unit)  {
    //TODO: create top bar with back button and title

}

@Composable
private fun ExerciseInformation(drill: Exercise) {
    Text("Recommended duration: ${drill.recommendedDuration} minutes")
    Text("Instructions", style = MaterialTheme.typography.titleMedium)
    drill.steps.forEachIndexed { index, string ->
        Text("${index + 1}.$string")
    }
}

@Composable
private fun DurationInput(value: String, isInvalid: Boolean, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Duration (minutes)") },
        isError = isInvalid,
        supportingText = {
            Text("Enter a number greater than zero.",
            color = if (isInvalid) {
                MaterialTheme.colorScheme.error
            }
            else {
                Color.Transparent
            }
            )
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}

@Composable
private fun LogActivityButton(enabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.fillMaxWidth()
    ){
        Text("Log Completed Workout")
    }
}

@Composable
private fun ActivityLogDialog(drillName: String, onDismiss: () -> Unit) {
    AlertDialog (
        onDismissRequest = onDismiss,
        title = {
            Text("Workout Logged")
        },
        text = {
            Text("$drillName was added to activity history")
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Done")
            }
        }
    )
}


