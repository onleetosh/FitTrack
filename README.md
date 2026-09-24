# FitTrack
a 3-screen, state-driven Android application engineered using 100% Kotlin, Jetpack Compose declarative UI, Material Design 3, and the Model-View-ViewModel (MVVM) architecture pattern.

FitTrack Functional Specifications (3 Screens)

Screen 1: Dashboard, Categories & Activity History Log (Main Screen)

Summary Stats Card: Displays a high-level summary of logged metrics:
Total workouts completed (count).
Total cumulative workout time (in minutes).

Category Picker: Displays at least 4 workout categories (e.g., Strength, Cardio, Flexibility, HIIT). Tapping a category navigates to Screen 2 (Exercise List), passing the selected category name as a route parameter.

Recent Activity History Log: A scrollable LazyColumn at the bottom displaying all logged workouts in chronological order. If no workouts have been logged, display placeholder text (e.g., "No workouts logged yet. Select a category above to get started!").

Clear Logs Button: A prominent button that resets all logged statistics and history entries in the ViewModel back to zero.

Screen 2: Exercise List Screen

Category Title: Reads and displays the category name parameter from the navigation route.

Exercise Collection: Renders a LazyColumn showing at least 3 distinct exercises belonging to that category.

Exercise Card Items: Each item card must show:
Exercise Name (e.g., "Classic Push-ups").
Difficulty Tag (e.g., Beginner, Intermediate, Advanced) styled with a colored badge.
One-sentence instructions preview.

Navigation: Tapping an exercise card navigates to Screen 3 (Exercise Details), passing the unique Exercise ID as a route argument.

Back Navigation: Includes a top bar Back arrow returning to the Dashboard.

Screen 3: Exercise Detail & Logger Screen

Exercise Information: Displays complete exercise details (Title, Step-by-step instructions, Recommended duration).

Interactive Logging Form:
An OutlinedTextField accepting numeric input for Duration (Minutes).
A "Log Completed Workout" action button.

Validation Rules:
If the input field is empty, contains non-numeric text, or is ≤ 0, display a red error message below the text field and disable the "Log Completed Workout" button.

Logging Action: Clicking "Log Completed Workout" must:
Update the global state in the ViewModel (incrementing total workouts, adding duration minutes, and prepending a new entry to the history log).
Display an AlertDialog confirming the successful log.
Automatically clear the input text field.

Back Navigation: Includes a Back navigation button returning to the Exercise List Screen.

Technical & Architectural Constraints:

MVVM Architecture: Exactly ONE central ViewModel (inheriting from androidx.lifecycle.ViewModel) shared across destinations. Do NOT instantiate separate ViewModels on each screen.

State Representation: Model state as a unified Kotlin data class (e.g., WorkoutUiState) exposed via Compose mutableStateOf() with a private set.

Pre-Coroutines Scope: Do NOT use Kotlin Coroutines (viewModelScope.launch), Flows (StateFlow, collectAsState), or Side Effects (LaunchedEffect) as these are covered in Modules 08+. State should be driven synchronously through Compose state.

Navigation: Use androidx.navigation.compose (NavHost, rememberNavController, and dynamic route arguments).

Material Design 3: Build layouts with Material 3 components (Scaffold, Card, Button, OutlinedTextField, TopAppBar).
