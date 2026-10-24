package com.lehman.fittrack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.*
import com.lehman.fittrack.ui.viewModel.*
import com.lehman.fittrack.ui.view.*
import com.lehman.fittrack.model.*

@Composable
fun FitTrackNavigation(viewModel: WorkoutViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost( navController = navController, startDestination = View.Dashboard.path)
    {
        navigateDashboard(navController, viewModel)
        navigateExerciseList(navController)
        navigateWorkoutDetail(navController, viewModel)
    }
}

private fun NavGraphBuilder.navigateDashboard(navCtrl: NavHostController, viewMod: WorkoutViewModel)
{
    composable(View.Dashboard.path) {
        Dashboard(
            workouts = viewMod.uiState.logActivity,
            onCategorySelected =  { category ->
                navCtrl.navigate("${View.ExerciseList.path}/$category")
            },
            onClear = viewMod::clearLoggedActivity
        )
    }
}

private fun NavGraphBuilder.navigateExerciseList(navCtrl: NavHostController)
{
    composable(
        route = View.exerciseListPath,
        arguments = listOf(
            navArgument(View.CATEGORY) { type = NavType.StringType }
        )
    ) { entry ->
        ExerciseListPath(entry = entry, navCtrl = navCtrl)
    }
}

private fun NavGraphBuilder.navigateWorkoutDetail(
    navCtrl: NavHostController,
    viewMod: WorkoutViewModel)
{
    composable(
        route = View.workoutDetailPath,
        arguments = listOf(
            navArgument(View.WORKOUT_ID) {
                type = NavType.StringType
            }
        )
    ) { entry ->
        WorkoutDetailPath( entry = entry, navCtrl = navCtrl, viewMod = viewMod)
    }
}

@Composable
private fun ExerciseListPath(entry: NavBackStackEntry, navCtrl: NavHostController )
{
    ExerciseList(
        category = entry.arguments?.getString(View.CATEGORY).orEmpty(),
        exerciseSelected = { exerciseId ->
            navCtrl.navigate("${View.ExerciseList.path}/$exerciseId")
        },
        onBack = {
            navCtrl.popBackStack(View.Dashboard.path, inclusive = false)
        }
    )
}

@Composable
private fun WorkoutDetailPath(
    entry: NavBackStackEntry,
    navCtrl: NavHostController,
    viewMod: WorkoutViewModel)
{
    exerciseById(entry.arguments?.getString(View.WORKOUT_ID).orEmpty())?.let {
            exercise ->
        WorkoutDetail(
            exercise = exercise,
            durationInput = viewMod.uiState.durationInput,
            isLogging = viewMod.uiState.logState,
            onDurationChange = viewMod::updateDuration,
            onLogActivity = { viewMod.logWorkout(exercise)},
            onDismissConfirmation = viewMod::isLoggedDismiss,
            onBack = { navCtrl.popBackStack() }
        )
    }
}
