package com.lehman.fittrack.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*
import com.lehman.fittrack.model.*
import com.lehman.fittrack.ui.icon.arrow_circle_left
import com.lehman.fittrack.ui.theme.*

@Composable
fun ExerciseList(
    category: String,
    exerciseSelected: (String) -> Unit,
    onBack: () -> Unit
){
    Scaffold(topBar = {
        ExerciseListTopBar(category = category, onBack = onBack)
    }) { padding ->
        val exercises = exercisesByCategory[category].orEmpty()
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        )
        {
            items(items = exercises, key = Exercise::id) {   exercise ->
                ExerciseCard(exercise = exercise, onSelected = exerciseSelected )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ExerciseListTopBar(category: String, onBack: () -> Unit) {
    TopAppBar(
        title = { Text(category, fontSize = 30.sp) },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = arrow_circle_left, contentDescription = "Back to Dashboard")
            }
        }
    )
}

@Composable
private fun ExerciseCard(exercise: Exercise, onSelected: (String) -> Unit){
    Card(onClick = {onSelected(exercise.id)}, modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(exercise.title, style = MaterialTheme.typography.titleLarge, fontSize = 26.sp)
            DifficultyTag(difficulty = exercise.difficultyTag)
            ExerciseInstructPreview(instruct = exercise.instructPreview)
        }
    }
}

@Composable
private fun DifficultyTag(difficulty: Difficulty){
    val (backgroundColor, textColor) = when (difficulty) {
        Difficulty.Novice -> noviceTagBackground to noviceTagText
        Difficulty.Intermediate -> intermediateTagBackground to intermediateTagText
        Difficulty.Expert -> expertTagBackground to expertTagText
    }
    AssistChip(
        onClick = {},
        label = { Text(difficulty.name, fontSize = 23.sp) },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = backgroundColor,
            labelColor = textColor
        )
    )
}

@Composable
private fun ExerciseInstructPreview(instruct: String) {
    Text(
        text = instruct,
        style = MaterialTheme.typography.bodyMedium,
        fontSize = 20.sp
    )
}