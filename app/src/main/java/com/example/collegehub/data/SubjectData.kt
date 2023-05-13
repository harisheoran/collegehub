package com.example.collegehub.data

import com.example.collegehub.R
import com.example.collegehub.model.Subject


object SubjectData {
    fun getSubjectsForChoosenDepartmentAndSemester(
        departmentId: Int,
        semesterId: Int
    ): List<Subject> {
        val mainScreenData = arrayOf(
            // Department Id 0 - Civil Engineering
            arrayOf(
                // 1st semContextCompat.getDrawable(context, R.drawable.my_image)
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("PPS", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
                arrayOf(
                    Subject("Will be available soon...", "soon", R.drawable.homeinfo_img)
                )
            ),
            // Department Id 1 - CSE
            arrayOf(

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
            // Department Id 2 - CSE A.I.
            arrayOf(
                // 1st sem

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
            // Department Id 3 - Electronics
            arrayOf(

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
            // Department Id 4 - Electrical Engineering
            arrayOf(

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
            // Department Id 5 - Food Technology
            arrayOf(

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
            // Department Id 6 - Mechanical Engineering
            arrayOf(

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
            // Department Id 7 - Information Technology
            arrayOf(

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
            // Department Id 8 - Packaging Technology
            arrayOf(

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
            // Department Id 9 - Printing Technology
            arrayOf(

                // 1st sem
                arrayOf(
                    Subject("Mathematics", "math", R.drawable.homeinfo_img),
                    Subject("Chemistry", "chemistry", R.drawable.engi),
                    Subject("English", "english", R.drawable.pdf_icon),
                    Subject("Programming for Problem Solving", "pps", R.drawable.pdf_icon),
                    Subject("EVS", "evs", R.drawable.engi),
                ),
                // 2nd sem
                arrayOf(
                    Subject("Physics", "physics", R.drawable.homeinfo_img),
                    Subject("BEE", "bee", R.drawable.homeinfo_img),
                    Subject("Workshop", "workshop",  R.drawable.homeinfo_img),
                    Subject("Mathematics", "math",  R.drawable.homeinfo_img),
                    Subject("Indian Constitution", "ic",  R.drawable.homeinfo_img)
                ),
            ),
        )
        return mainScreenData[departmentId][semesterId].toList()
    }
}