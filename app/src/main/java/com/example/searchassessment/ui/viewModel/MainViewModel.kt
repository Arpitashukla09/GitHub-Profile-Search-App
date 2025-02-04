package com.example.searchassessment.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.GHRepo
import data.NetworkService
import data.Results
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _repos = MutableLiveData<Results<List<GHRepo>>>()
    val repos: LiveData<Results<List<GHRepo>>> = _repos

    fun fetchRepos(username: String) = viewModelScope.launch {
        try {
            val response = NetworkService.api.getRepos(username)
            if (response.isSuccessful) {
                val repoEntities = response.body()?.map {
                    GHRepo(it.id, it.name, it.repoURL)
                } ?: emptyList()


                _repos.postValue(Results.Success(repoEntities))
            } else {
                _repos.postValue(Results.Error(null))
            }
        } catch (e: Exception) {
            _repos.postValue(Results.Error(e.message))
        }
    }
}
