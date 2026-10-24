package com.lehman.fittrack.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.*
import com.lehman.fittrack.R
import com.lehman.fittrack.model.Exercise
import com.lehman.fittrack.ui.icon.arrow_circle_left

@Composable
fun WorkoutDetail(
    exercise: Exercise,
    durationInput: String,
    isLogging: Boolean,
    onDurationChange: (String) -> Unit,
    onLogActivity: () -> Unit,
    onDismissConfirmation: () -> Unit,
    onBack: () -> Unit
){
    val duration = durationInput.toLongOrNull()
    val durationValid = duration != null && duration > 0
    val durationInvalid = durationInput.isNotEmpty() && !durationValid

    Scaffold(topBar = {WorkoutDetailTopBar(title = exercise.title, onBack = onBack)})
    { padding ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            WorkoutInformation(exercise = exercise)
            DurationInput(
                value = durationInput,
                isInvalid = durationInvalid,
                onValueChange = onDurationChange
            )
            LogActivityButton(isEnabled = durationValid, onClick = onLogActivity)
        }
    }
    if(isLogging) {
        ActivityLogDialog(
            activity = exercise.title,
            onDismiss = onDismissConfirmation
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WorkoutDetailTopBar(title: String, onBack: () -> Unit) {
    TopAppBar(
        title = {Text(title, fontSize = 30.sp)},
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = arrow_circle_left,
                    contentDescription = stringResource(R.string.back_dash_2)
                )
            }
        }
    )
}

@Composable
private fun WorkoutInformation(exercise: Exercise) {
    Text("${stringResource(R.string.recommended)} ${exercise.recommendedDuration} ${stringResource(R.string.min)}",
        fontSize = 22.sp)
    Text(stringResource(R.string.instructs), style = MaterialTheme.typography.titleMedium, fontSize = 24.sp)
    exercise.instructions.forEachIndexed { index, string ->
        Text("${index + 1}.$string", fontSize = 20.sp)
    }
}

@Composable
private fun DurationInput(value: String, isInvalid: Boolean, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.durationMin), fontSize = 20.sp) },
        isError = isInvalid,
        singleLine = true,
        supportingText = {
            if(isInvalid) {
                Text(stringResource(R.string.prompt_input),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.error)
            }
        },
        modifier = Modifier.fillMaxWidth()
        )
}

@Composable
private fun LogActivityButton(isEnabled: Boolean, onClick:() -> Unit) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(stringResource(R.string.log_complete), fontSize = 22.sp)
    }
}

@Composable
private fun ActivityLogDialog(activity: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.log_work), fontSize = 26.sp) },
        text = { Text ("$activity ${stringResource(R.string.log_dialog)}", fontSize = 22.sp )},
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Done", fontSize = 22.sp)
            }
        }
    )
}
