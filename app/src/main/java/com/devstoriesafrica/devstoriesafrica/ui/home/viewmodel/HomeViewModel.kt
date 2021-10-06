package com.devstoriesafrica.devstoriesafrica.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import com.devstoriesafrica.devstoriesafrica.repositories.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {
}