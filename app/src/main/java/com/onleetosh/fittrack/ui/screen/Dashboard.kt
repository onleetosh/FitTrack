package com.onleetosh.fittrack.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*

import androidx.compose.ui.unit.dp
import com.onleetosh.fittrack.model.Workout

/**
 * Categories available for starting a new workout log.
 */
private val categories = listOf("Cardio", "Strength", "Flexibility", "Balance")

@Composable
fun Dashboard(drills: List<Workout>, categorySelected: String, onClear: () -> Unit) {

}

@Composable
private fun SummaryCard(count: Int, inMinutes: Long) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SummaryField("Total workouts completed", count.toString())
            SummaryField("Total cumulative workout time", inMinutes.toString())
        }
    }
}

@Composable
private fun SummaryField(field: String, value: String) {
    Column() {
        Text(value, style = MaterialTheme.typography.headlineMedium)
        Text(field, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun CategoryHead() {
    Text("Category Header", style = MaterialTheme.typography.titleLarge)
}

@Composable
private fun CategoryCard(title: String, onSelect: (String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onSelect(title) }
    ) {
        Text(title, modifier = Modifier.padding(16.dp))
    }
}

@Composable
private fun ActivityHistoryHead(isLogged: Boolean, onClear: () -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Activity History", style = MaterialTheme.typography.titleLarge)
        Button(onClick = onClear, enabled = isLogged) {
            Text("Clear")
        }
    }
}

@Composable
private fun ActivityHistoryCard(drill: Workout){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(drill.name, style = MaterialTheme.typography.titleMedium)
            Text(drill.category, style = MaterialTheme.typography.bodyMedium)
            Text("{${drill.duration} minutes", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
private fun EmptyActivityAlert(){
    Text(
        "No workouts logged yet. Select a category above to get started!",
        style = MaterialTheme.typography.bodyMedium
    )
}
