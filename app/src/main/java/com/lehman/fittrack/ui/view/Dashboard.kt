package com.lehman.fittrack.ui.view

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import com.lehman.fittrack.R
import com.lehman.fittrack.model.Workout
import java.util.*



private val categories = listOf("Cardio", "Strength", "Flexibility", "Balance")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(workouts: List<Workout>,
              onCategorySelected: (String) -> Unit,
              onClear: () -> Unit)
{
   Scaffold(topBar = {
           TopAppBar(
               title = {Text(stringResource(R.string.app_name), fontSize = 36.sp)},
               colors = TopAppBarDefaults.topAppBarColors(
                   containerColor = MaterialTheme.colorScheme.primaryContainer,
                   titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
               )
           )
       }) { padding ->
            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(padding).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                item { SummaryCardHeader() }
                item { SummaryCard(count = workouts.size, inMinutes = workouts.sumOf {it.durationMinutes})}
                item { CategoryHeader() }
                items(categories, key = {it} ) { category ->
                    CategoryCard(title = category, onSelected = onCategorySelected)
                }
                item { RecentActivityLogHeader(logStatus = workouts.isNotEmpty(), onClear = onClear) }
                if (workouts.isEmpty()) {
                    item{EmptyActivityActivity()}
                } else {
                    items(workouts, key = { it.id }) { workout ->
                        RecentActivityLogCard(workout = workout)
                    }
                }
            }
   }
}

@Composable
private fun SummaryCardHeader() {
    Text(stringResource(R.string.metrics),
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary,
        fontSize = 30.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun SummaryCard(count: Int, inMinutes: Long){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SummaryField(stringResource(R.string.work_1), count.toString())
            SummaryField(stringResource(R.string.mins), inMinutes.toString())
        }
    }
}
@Composable
private fun SummaryField(field: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, style = MaterialTheme.typography.bodyMedium, fontSize = 30.sp)
        Text(field, style = MaterialTheme.typography.bodyMedium, fontSize = 25.sp)
    }
}

@Composable
private fun CategoryHeader() {
    Text(stringResource(R.string.categories),
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 30.sp)
}


@Composable
private fun CategoryCard(title: String, onSelected: (String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        onClick = {onSelected(title)}
    ) {
        Text(title, modifier = Modifier.padding(16.dp), fontSize = 26.sp)
    }
}

@Composable
private fun RecentActivityLogHeader(logStatus: Boolean, onClear: () -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            stringResource(R.string.activity_log),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 30.sp
        )
        Button(onClick = onClear, enabled = !logStatus) {
            Text(stringResource(R.string.clear), fontSize = 22.sp)

        }
    }
}

@Composable
private fun RecentActivityLogCard(workout: Workout){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    workout.title,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 24.sp
                )
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ) {
                    Text(
                        "${workout.durationMinutes} ${stringResource(R.string.min)}",
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp
                    )
                }
            }
            Text(workout.category, style = MaterialTheme.typography.bodyMedium, fontSize = 24.sp)
            Text(
                "${stringResource(R.string.completed)} ${
                    SimpleDateFormat(stringResource(R.string.date_ftm), Locale.getDefault())
                        .format(Date(workout.date))
                }",
                style = MaterialTheme.typography.bodySmall, fontSize = 20.sp

            )
        }
    }
}

@Composable
private fun EmptyActivityActivity(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Text(
            stringResource(R.string.empty_msg),
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}