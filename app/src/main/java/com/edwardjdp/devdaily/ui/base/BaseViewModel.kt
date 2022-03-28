package com.edwardjdp.devdaily.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.edwardjdp.devdaily.domain.model.ArticleUI
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<EV : UiEvent, ST : UiState, EF : UiEffect> : ViewModel() {

    private val initialState: ST by lazy { createInitialState() }
    abstract fun createInitialState(): ST

    private val currentState: ST
        get() = uiState.value

    private val _uiState: MutableStateFlow<ST> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    private var _pagingData: Flow<PagingData<ArticleUI>> = emptyFlow()
    val pagingData by lazy { _pagingData }

    private val _event: MutableSharedFlow<EV> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    private val _effect: Channel<EF> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeEvents()
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    abstract fun handleEvent(event: EV)

    fun setEvent(event: EV) {
        val newEvent = event
        viewModelScope.launch { _event.emit(newEvent) }
    }

    protected fun setState(reduce: ST.() -> ST) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }

    protected fun setPagingData(useCase: suspend () -> Flow<PagingData<ArticleUI>>) {
        viewModelScope.launch {
            _pagingData = useCase.invoke()
        }
    }

    protected fun setEffect(builder: () -> EF) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }
}