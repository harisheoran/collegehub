package com.sparrowbit.collegehub.data


import com.sparrowbit.collegehub.R
import com.sparrowbit.collegehub.model.Subject


object SubjectData {
    fun getSubjectsForChoosenDepartmentAndSemester(
        departmentId: Int,
        semesterId: Int
    ): List<Subject> {
        val mainScreenData = arrayOf(
            // Department Id 0 - Civil Engineering
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("AutoCAD", "autocad", R.drawable.autocad),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("EGD", "egd", R.drawable.egd),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "math2", R.drawable.math2),
                    Subject("English", "english", R.drawable.book),
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
            // Department Id 1 - CSE
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Mathematics", "mathcse", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("EGD", "egd", R.drawable.egd),

                    ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "mathcse2", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic),
                    Subject("English", "english", R.drawable.book),
                    ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
            // Department Id 2 - CSE A.I.
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Mathematics", "mathcse", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("English", "english", R.drawable.book),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("Environmental studies", "evs", R.drawable.evs),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "mathcse2", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic)
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
            // Department Id 3 - Electronics
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("English", "english", R.drawable.book),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("Environmental studies", "evs", R.drawable.evs),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "math2", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic)
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
            // Department Id 4 - Electrical Engineering
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("English", "english", R.drawable.book),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("Environmental studies", "evs", R.drawable.evs),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "math2", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic)
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )

            ),
            // Department Id 5 - Food Technology
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("English", "english", R.drawable.book),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("Environmental studies", "evs", R.drawable.evs),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "math2", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic)
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
            // Department Id 6 - Mechanical Engineering
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("English", "english", R.drawable.book),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("Environmental studies", "evs", R.drawable.evs),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "math2", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic)
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
            // Department Id 7 - Information Technology
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Mathematics", "mathcse", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("English", "english", R.drawable.book),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("Environmental studies", "evs", R.drawable.evs),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "mathcse2", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic)
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
            // Department Id 8 - Packaging Technology
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "math", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic)
                ),
                // 2nd sem
                arrayOf(
                    Subject("Mathematics", "math2", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("English", "english", R.drawable.book),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("Environmental studies", "evs", R.drawable.evs),
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
            // Department Id 9 - Printing Technology
            arrayOf(
                // 1st sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.physics2),
                    Subject("Basic Electrical Engineering", "bee", R.drawable.bee),
                    Subject("Workshop", "workshop", R.drawable.workshop),
                    Subject("Mathematics", "math", R.drawable.math2),
                    Subject("Indian Constitution", "ic", R.drawable.ic)
                ),
                // 2nd sem
                arrayOf(
                    Subject("Mathematics", "math2", R.drawable.math2),
                    Subject("Chemistry", "chemistry", R.drawable.chemistry11),
                    Subject("English", "english", R.drawable.book),
                    Subject("Programming for Problem solving ", "pps", R.drawable.code),
                    Subject("Environmental studies", "evs", R.drawable.evs),
                ),
                // 3rd sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 4th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 5th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 6th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 7th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                ),
                // 8th sem
                arrayOf(
                    Subject("Available soon... Check out 1st & 2nd Sem", "soon", R.drawable.coming_soon)
                )
            ),
        )
        return mainScreenData[departmentId][semesterId].toList()
    }
}