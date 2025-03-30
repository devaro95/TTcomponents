package com.list

import com.model.ComponentCategory
import com.model.ComponentType
import com.list.ListEvents.Detail
import com.list.ListNavigator.ListDestinations
import com.list.ListNavigator.ListDestinations.DetailDestination
import com.vro.compose.VROComposableViewModel
import com.vro.navstarter.VRONavStarter
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ListViewModel : VROComposableViewModel<ListState, ListDestinations, ListEvents>() {

    override val initialState = ListState.INITIAL

    override fun onStarter(starter: VRONavStarter?) {
        when (starter) {
            is ListStarter.Initialize -> onInitialize(starter.componentCategory)
        }
    }

    private fun onInitialize(category: ComponentCategory) {
        updateScreen {
            copy(category = category)
        }
    }

    override fun onEvent(event: ListEvents) {
        when (event) {
            is Detail -> onDetailClick(event.componentType)
        }
    }

    private fun onDetailClick(componentType: ComponentType) {
        navigate(DetailDestination(componentType))
    }
}
