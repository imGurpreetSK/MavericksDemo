package com.example.mavericksdemo.namomemes

import com.example.mavericksdemo.base.BaseViewRenderer

class MemesViewRenderer(
    private val view: MemesView
) : BaseViewRenderer<MemesState> {

    override fun render(state: MemesState) {
        when (state.status) {
            FetchStatus.IN_FLIGHT -> {
                view.hideMemes()
                view.hideError()
                view.showLoading()
            }

            FetchStatus.SUCCESSFUL -> {
                view.hideLoading()
                view.hideError()
                view.showMemes(state.data)
            }

            FetchStatus.FAILED -> {
                view.hideLoading()
                view.hideMemes()
                view.showError(state.error!!)
            }
        }
    }
}
