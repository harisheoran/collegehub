package com.example.collegehub.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CollegeHubViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(CollegeHubUiState())
    val uistate: StateFlow<CollegeHubUiState> = _uiState.asStateFlow()

    fun updateDepartmentId(deptId: Int){
        _uiState.update{currentState ->
            currentState.copy(
                departmentId = deptId
            )
        }
    }

    fun updateSemesterNum(semesterNum: Int){
        _uiState.update {
            it.copy(
                semesterNum = semesterNum
            )
        }
    }
}