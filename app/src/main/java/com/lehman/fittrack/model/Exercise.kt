package com.lehman.fittrack.model
data class Exercise(
    val id: String,
    val category: String,
    val title: String,
    val difficultyTag: Difficulty,
    val instructPreview: String,
    val instructions: List<String>,
    val recommendedDuration: Int
)
enum class Difficulty { Novice, Intermediate, Expert }

val exercisesByCategory = mapOf(
    "Cardio" to listOf(
        Exercise(
            "cardio-1",
            "Cardio",
            "Marching in Place",
            Difficulty.Novice,
            "Stand upright with feet hip-width apart.",
            listOf( "Stand upright with feet hip-width apart",
                "Lift right knee to hip level while swinging left arm forward",
                "Lift right knee to hip level while swinging left arm forward.",
                "Lower right leg and repeat with the left leg."),
            10
        ),
        Exercise(
            "cardio-2",
            "Cardio",
            "Arm Circles",
            Difficulty.Novice,
            "Stand upright with feet shoulder-width apart",
            listOf("Stand upright with feet shoulder-width apart",
                "Extend arms straight out to the sides at shoulder height",
                "Make small circles with arms, gradually increasing the size of the circles"),
            4
        ),
        Exercise(
            "cardio-3",
            "Cardio",
            "Jumping Jacks",
            Difficulty.Intermediate,
            "Stand upright with legs toward and arms at sides",
            listOf("Stand upright with legs toward and arms at sides",
                "Jump up, spreading legs shoulder-width apart while raising arms above head.",
                "Jump again to return to the starting position"),
            8
        ),
        Exercise(
            "cardio-4",
            "Cardio",
            "Burpees",
            Difficulty.Expert,
            "Start in a standing position",
            listOf("Start in a standing position",
                "Drop into a squat position with hands on the ground.",
                "Kick feet back into a plank position",
                "Return to a squat position.",
                "Explosively jump into the air, reaching rams overhead"),
            5
        )
    ),

    "Strength" to listOf(
        Exercise(
            "strength-1",
            "Strength",
            "Squats",
            Difficulty.Novice,
            "Stand with feed shoulder-width apart.",
            listOf(
                "Stand with feed shoulder-width apart.",
                "Lower your hips with a straight back",
                "Drive through feet to stand"
            ),
            5
        ),
        Exercise(
            "strength-2",
            "Strength",
            "Classic Push-ups",
            Difficulty.Novice,
            "Start in a high plank position",
            listOf("Start in a high plank position",
                "Lower chest toward the floor",
                "Push back up without dropping hips"),
            5
        ),
        Exercise(
            "strength-3",
            "Strength",
            "Pike Push-ups",
            Difficulty.Intermediate,
            "Start in a downward dog position",
            listOf("Start in a downward dog position",
                "Engage core and shift weight forward so head is aligned with hands",
                "Lower head toward the ground by bending elbows",
                "Push back up to the starting position"),
            5
        ),
        Exercise(
            "strength-4",
            "Strength",
            "Handstand Push-ups",
            Difficulty.Expert,
            "Start with hands and feet on the ground, facing wall",
            listOf("Start with hands and feet on the ground, facing wall",
                "Raise feet onto a bench or box to shift weight forward and engage shoulders.",
                "Kick up into a handstand position again the wall.",
                "Lower head toward the ground by bending elbows",
                "Push back up to the starting position"),
            5
        )
    ),

    "Flexibility" to listOf(
        Exercise(
            "flexibility-1",
            "Flexibility",
            "Tree Pose",
            Difficulty.Novice,
            "Stand tall with feet together",
            listOf(
                "Stand tall with feet together",
                "Shift weight onto one leg",
                "Place the sole of the other foot on the inner thigh or calf",
                "Bring hands to prayer position at the chest",
            ),
            5
        ),
        Exercise(
            "flexibility-2",
            "Flexibility",
            "Cat-Cow Stretch",
            Difficulty.Novice,
            "Start on hands and knees in a tabletop position.",
            listOf("Start on hands and knees in a tabletop position.",
                "Inhale as you arch your back",
                "Looking straight ahead, Lift head and tailbone toward the ceiling",
                "Exhale as you round your spine",
                "Tucking chin to chest and drawing belly button toward spine"),
            3
        ),
        Exercise(
            "flexibility-3",
            "Flexibility",
            "90/90",
            Difficulty.Intermediate,
            "Sit on the floor with legs extended in front.",
            listOf("it on the floor with legs extended in front.",
                "Bring right leg up and place right foot on the outside of left thigh",
                "Gently lean forward and reach for right foot"),
            4
        ),
        Exercise(
            "flexibility-4",
            "Flexibility",
            "Camel Pose",
            Difficulty.Expert,
            "Start on hands and knees in a tabletop position",
            listOf("Start on hands and knees in a tabletop position",
                "Inhale and arch back",
                "Lift head and tailbone toward the ceiling","",),
            4
        ),
    ),

    "Balance" to listOf(
        Exercise(
            "balance-1",
            "Balance",
            "Warrior I",
            Difficulty.Novice,
            "Start standing at the front of mat, feet together and arms at sides",
            listOf("Start standing at the front of mat, feet together and arms at sides",
                "Step left foot back about 3 to 4 feet",
                "Spin back heel down to the mat at a 45-degree angle",
                "Bend front knees to 90-degree angle, keeping knee directly over ankle",
                "Square hips toward the front of the mate and engage cor",
                "Lift arms overhead, keeping shoulders relaxed and away from ears",
            ),
            3
        ),
        Exercise(
            "balance-2",
            "Balance",
            "Warrior II",
            Difficulty.Intermediate,
            "Start standing at the front of mat, feet together and arms at sides",
            listOf("Start standing at the front of mat, feet together and arms at sides",
                "Step left foot back about 3 to 4 feet",
                "Turn back foot out to a 90-degree angle and bend front knee at a 90-degree angle",
                "Keeping knee directly over ankle, extend arms out to the side at should height",
                "With palms facing down gaze over front hand",
                "Hold pose for several breathe before switching sides"),
            3
        ),
        Exercise(
            "balance-3",
            "Balance",
            "Eagle Pose",
            Difficulty.Expert,
            "Find a stable standing position",
            listOf("Find a stable standing position",
                "Cross one leg over the other and hook the foot behind the calf",
                "Wrap the arms and bring the palms together in front of the face",
                "Lift elbows and keep shoulders down",
                "Hold pose for 5 to 10 breaths then switch sides"),
            3
        ),
        Exercise(
            "balance-4",
            "Balance",
            "Warrior III",
            Difficulty.Expert,
            "Hinge forward from the hips and lift one leg straight back",
            listOf("Hinge forward from the hips and lift one leg straight back",
                "Shift weight onto right foot and lift left foot off the ground",
                "Bring upper body and lift leg parallel to the floor",
                "Form a straight line from head to heel",
                "Extend arms out to the side at shoulder height",
                "With palms facing down gaze forward",
                "Hold pose for several breaths before switching sides"),
            3
        )
    )
)

private val exercises = exercisesByCategory.values.flatten()
fun exerciseById(id: String): Exercise? = exercises.firstOrNull() { it.id == id }