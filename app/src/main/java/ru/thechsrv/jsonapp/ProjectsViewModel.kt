package ru.thechsrv.jsonapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.thechsrv.jsonapp.model.ProjectDtl
import ru.thechsrv.jsonapp.model.Projects

class ProjectsViewModel : ViewModel() {

    private val _text : MutableLiveData<Projects> = MutableLiveData()

    val text: LiveData<Projects> = _text
    var projectssss: Projects? = null

    fun setProjects(projects: Projects) {
        _text.value = projects
        projectssss = projects
    }
}