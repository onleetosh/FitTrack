package com.onleetosh.fittrack.model

/**
 * Represents an exercise and its associated training information.
 *
 * @property id Unique identifier for the exercise.
 * @property category Category of the exercise (e.g., strength, cardio).
 * @property name Display name of the exercise.
 * @property difficulty Difficulty level of the exercise.
 * @property description Brief summary of the exercise .
 * @property steps Ordered list of detailed steps for performing the exercise.
 * @property recommendedDuration Recommended duration of the exercise in seconds.
 */
data class Exercise(
    val id: String,
    val category: String,
    val name: String,
    val difficulty: Difficulty,
    val description: String,
    val steps: List<String>,
    val recommendedDuration: Int
)

/**
 * Defines the available difficulty tags for an exercise.
 */
enum class Difficulty {
    Novice,
    Intermediate,
    Expert
}

/**
 * Exercise information organized by category with each category containing a list of exercises with their respective details.
 */
val exercisesByCategory = mapOf(

    /* Cardio Exercises */
    "Cardio" to listOf(
        Exercise(
            "marching-in-place",
            "Cardio",
            "Marching in Place",
            Difficulty.Novice,
            "A low-impact exercise that increases heart rate and improves cardiovascular fitness.",
            listOf("Stand upright with your feet hip-width apart.",
                "Lift your right knee to hip level while swinging your left arm forward.",
                "Lower your right leg and repeat with the left leg."),
            5
        ),
        Exercise(
            "arm-circles",
            "Cardio",
            "Arm Circles",
            Difficulty.Novice,
            "A simple exercise that warms up the shoulders and increases blood flow.",
            listOf("Stand upright with your feet shoulder-width apart.",
                "Extend your arms straight out to the sides at shoulder height.",
                "Make small circles with your arms, gradually increasing the size of the circles."),
            5
        ), 
        Exercise(
            "jumping-jacks",
            "Cardio",
            "Jumping Jacks",
            Difficulty.Intermediate,
            "A full-body exercise that increases heart rate and improves cardiovascular fitness.",
            listOf("Stand upright with your legs together and arms at your sides.",
                "Jump up, spreading your legs shoulder-width apart while raising your arms above your head.",
                "Jump again to return to the starting position."),
            10),
        Exercise(
            "burpees",
            "Cardio",
            "Burpees",
            Difficulty.Expert,
            "A full-body exercise that improves cardiovascular fitness, strength, and endurance.",
            listOf("Start in a standing position.",
                "Drop into a squat position with your hands on the ground.",
                "Kick your feet back into a plank position.",
                "Perform a push-up.",
                "Jump your feet back to the squat position.",
                "Explosively jump into the air, reaching your arms overhead."),
            15),
        Exercise(
            "squat-jumps",
            "Cardio",
            "Squat Jumps",
            Difficulty.Expert,
            "Combine a squat with a jump to increase power and explosiveness.",
            listOf("Start in a squat position.",
                "Jump up explosively.",
                "Land softly and immediately go into the next squat."),
            20)
    ),

    /* Strength Exercises */
    "Strength" to listOf(
        Exercise("squats",
            "Strength",
            "Squats",
            Difficulty.Novice,
            "Works your quads, hamstrings, and glutes.",
            listOf("Stand with feet shoulder-width apart.",
                "Lower your hips with a straight back.",
                "Drive through your feet to stand."),
            15),
        Exercise("push-ups",
            "Strength",
            "Classic Push-ups",
            Difficulty.Novice,
            "Works your chest, shoulders, triceps, and core. ",
            listOf("Start in a high plank.",
                "Lower your chest toward the floor.",
                "Push back up without dropping your hips."),
            10),
        Exercise("pike-push-ups",
            "Strength",
            "Pike Push-ups",
            Difficulty.Intermediate,
            "A variation of the push-up that targets the shoulders and upper chest.",
            listOf("Start in a downward dog position forming an inverted V shape with your body.",
                "Engage your core and shift your weight forward so your head is aligned with your hands forming a triangle shape.",
                "Lower your head toward the floor by bending your elbows.",
                "Push back up to the starting position."),
            10),
        Exercise("handstand-push-ups",
            "Strength",
            "Handstand Push-ups",
            Difficulty.Expert,
            "A challenging exercise that builds upper body strength and improves balance.",
            listOf("Start with hands and feet on the ground, facing a wall in inverted v position.",
                "Raise your feet onto a bench or box to shift your weight forward and engage your shoulders.",
                "Kick up into a handstand position against the wall.",
                "Lower your head toward the ground by bending your elbows.",
                "Push back up to the starting position."),
            10)
    ),

    /* Flexibility Exercises */
    "Flexibility" to listOf(
        Exercise("cat-cow-stretch",
            "Flexibility",
            "Cat-Cow Stretch",
            Difficulty.Novice,
            "A gentle, flowing yoga and rehabilitation exercise that improves spinal mobility, eases back stiffness, and supports better posture",
            listOf("Start on your hands and knees in a tabletop position.",
                "Inhale as you arch your back, lifting your head and tailbone toward the ceiling and looking straight ahead",
                "Exhale as you round your spine, tucking your chin to your chest and drawing your belly button toward your spine."),
            5),
        Exercise("tree-pose",
            "Flexibility",
            "Tree Pose",
            Difficulty.Novice,
            "A standing yoga posture that improves balance and strengthens the legs",
            listOf("Stand tall with feet together.",
                "Shift weight onto one leg and place the sole of the other foot on the inner thigh or calf.",
                "Bring hands to prayer position at the chest or extend overhead."),
            2),
        Exercise("90-90-strentch",
            "Flexibility",
            "90/90 Stretch",
            Difficulty.Intermediate,
            "A stretching exercise that targets the hip flexors and improves hip mobility.",
            listOf("Sit on the floor with your legs extended in front of you.",
                "Bring your right leg up and place your right foot on the outside of your left thigh.",
                "Gently lean forward and reach for your right foot."),
            10),
        Exercise("camel-pose",
            "Flexibility",
            "Camel Pose",
            Difficulty.Expert,
            "A backbend that opens the chest and stretches the front of the body.",
            listOf("Start on your hands and knees in a tabletop position.",
                "Inhale and arch your back, lifting your head and tailbone toward the ceiling.",
                "Exhale and round your spine, tucking your chin to your chest."),
            10)
    ),

    /* Balance Exercises */
    "Balance" to listOf(
        Exercise("warrior-1-pose",
            "Balance",
            "Warrior I",
            Difficulty.Novice,
            "A foundational standing yoga posture that builds lower-body strength, stability, and focus",
            listOf("Start standing at the front of your mat with your feet together and arms at your sides.",
                "Step your left foot back about 3 to 4 feet and spin your back heel down to the mat at a 45-degree angle.",
                "Bend your front knees to a 90-degree angle, keeping your knee directly over your ankle.",
                "Square your hips toward the front of the mat and engage your core.",
                "Lift your arms overhead, keeping your shoulders relaxed and away from your ears."),
            3),
        Exercise("warrior-2-pose",
            "Balance",
            "Warrior II",
            Difficulty.Intermediate,
            "A standing yoga posture that strengthens the legs and improves focus and stability",
            listOf(
                "Start in a standing position with your feet together and arms at your sides.",
                "Step your left foot back about 3 to 4 feet and turn your back foot out to a 90-degree angle.",
                "Bend your front knee to a 90-degree angle, keeping your knee directly over your ankle.",
                "Extend your arms out to the sides at shoulder height, palms facing down.",
                "Gaze over your front hand and hold the pose for several breaths before switching sides."),
            3),
        Exercise("eagle-pose",
            "Balance",
            "Eagle Pose",
            Difficulty.Intermediate,
            "A standing balancing posture that strengthens the legs and stretches the upper back, shoulders, and hips",
            listOf("Find a stable standing position.",
                "Cross one leg over the other and hook the foot behind the calf.",
                "Wrap the arms and bring the palms together in front of the face.",
                "Lift the elbows and keep the shoulders down.",
                "Hold the pose for 5 to 10 breaths, then switch sides."),
            2),
        Exercise(
            "warrior-3-pose",
            "Balance",
            "Warrior III",
            Difficulty.Expert,
            "A standing yoga posture that improves balance and strengthens the legs and core",
            listOf("Hinge forward from the hips and lift one leg straight back",
                "Shift your weight onto your right foot and lift your left foot off the ground.",
                "Bring upper body and lifted leg parallel to the floor, forming a straight line from head to heel.",
                "Extend your arms out to the sides at shoulder height, palms facing down.",
                "Gaze forward and hold the pose for several breaths before switching sides."),
            3),
        Exercise(
            "king-pigeon-pose",
            "Balance",
            "King Pigeon Pose",
            Difficulty.Expert,
            "A challenging backbend that opens the hips and stretches the shoulders.",
            listOf(
                "Start in downward-facing dog by pressing into your hands and lift hips up and back.",
                "Bring your right knee forward and place it behind your right wrist, with the shin angled slightly to the left.",
                "Slide your left leg back, keeping the hips square and the back leg extended.",
                "Bend your right knee and reach back with your right hand to grasp the foot or ankle.",
                "Lift the chest and arch the back, keeping the shoulders relaxed and away from the ears.",
                "Reach left arm or both arms back to catch outside edge or toes of left foot, if possible.",
                "Roll shoulders back and gently press back foot into hand while lifting chest and arching back.",
                "Hold for 5 to 10 breaths, then carefully release and step back into downward-facing dog before switching sides."),
            5)
    )
)

/**
 * Retrieves an exercise by its unique identifier.
 *
 * @param id The unique identifier of the exercise to retrieve.
 * @return The exercise with the specified ID, or null if not found.
 */
fun exerciseById(id: String) {
    exercisesByCategory.values.flatten().firstOrNull { it.id == id}
}