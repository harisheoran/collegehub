package com.example.collegehub.viewmodel

import androidx.lifecycle.*
import com.example.collegehub.data.SubjectData
import com.example.collegehub.localdata.UserData
import com.example.collegehub.localdata.UserDataDao
import com.example.collegehub.model.Department
import com.example.collegehub.model.Semester
import com.example.collegehub.model.Subject
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class CollegeHubViewModel(private val userDataDao: UserDataDao) : ViewModel() {

    val userLoggedInData: LiveData<UserData> = userDataDao.readUserData().asLiveData()

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _department = MutableLiveData<Department>()
    val department: LiveData<Department> = _department

    private val _semester = MutableLiveData<Semester>()
    val semester: LiveData<Semester> = _semester

    private val _subjectList = MutableLiveData<List<Subject>>()
    val subjectList: LiveData<List<Subject>> = _subjectList

    fun setUserName(userName: String) {
        _userName.value = userName
    }

    fun setDepartment(selectedDeparment: Department) {
        _department.value = selectedDeparment
    }

    fun setSemester(selectedSemester: Semester) {
        _semester.value = selectedSemester
    }

    fun saveSelectedUserData() {
        val selectedDeparment = _department.value
        val selectedSemester = _semester.value
        val selectedUserName = _userName.value
        val department = selectedDeparment?.name
        val semester = selectedSemester?.name
        val departmentId = selectedDeparment?.id
        val semesterId = selectedSemester?.id

        if (selectedDeparment != null && selectedSemester != null && selectedUserName != null) {
            addNewUserData(
                selectedUserName,
                department,
                semester,
                departmentId,
                semesterId
            )
        }
    }

    fun updateUserData(id: Int) {
        val selectedDeparment = _department.value
        val selectedSemester = _semester.value
        val selectedUserName = _userName.value
        val department = selectedDeparment?.name
        val semester = selectedSemester?.name
        val departmentId = selectedDeparment?.id
        val semesterId = selectedSemester?.id

        val updatedUserData = selectedUserName?.let {
            getUpdatedUserDataEntry(
                id = id,
                userName = it,
                userDepartment = department,
                userSemester = semester,
                departmentId = departmentId,
                semesterId = semesterId
            )
        }
        if (updatedUserData != null) {
            updateUserData(updatedUserData)
        }
    }

    fun readUserData(): LiveData<UserData> {
        return userDataDao.readUserData().asLiveData()
    }

    fun loadSubjects(userData: UserData) {
        val departmentId = userData.departmentId
        val semesterId = userData.semesterId

        if (departmentId != null && semesterId != null) {
            _subjectList.value =
                SubjectData.getSubjectsForChoosenDepartmentAndSemester(departmentId, semesterId)
        }

    }

    // save user data
    private fun insertUserData(userData: UserData) {
        viewModelScope.launch {
            userDataDao.saveUserData(userData)
        }
    }

    private fun updateUserData(userData: UserData) {
        viewModelScope.launch {
            userDataDao.updateUserData(userData)
        }
    }

    fun readLoggedInUserData(id: Int): LiveData<UserData> {
        return userDataDao.readLoggedInUserData(id).asLiveData()
    }

    private fun getNewUserDataEntry(
        userName: String,
        department: String?,
        semester: String?,
        departmentId: Int?,
        semesterId: Int?
    ): UserData {
        return UserData(
            userName = userName,
            department = department,
            semester = semester,
            departmentId = departmentId,
            semesterId = semesterId
        )
    }

    private fun getUpdatedUserDataEntry(
        id: Int,
        userName: String,
        userDepartment: String?,
        userSemester: String?,
        departmentId: Int?,
        semesterId: Int?
    ): UserData {
        return UserData(
            id = id,
            userName = userName,
            department = userDepartment,
            semester = userSemester,
            departmentId = departmentId,
            semesterId = semesterId
        )
    }

    private fun addNewUserData(
        userName: String,
        department: String?,
        semester: String?,
        departmentId: Int?,
        semesterId: Int?
    ) {
        val newUserData =
            getNewUserDataEntry(userName, department, semester, departmentId, semesterId)
        insertUserData(newUserData)
    }


}


// factory class for viewModel
class CollegeHubViewModelFactory(private val userDataDao: UserDataDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CollegeHubViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CollegeHubViewModel(userDataDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}