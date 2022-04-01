package com.example.mavericksdemo.namomemes

import com.example.mavericksdemo.base.BaseView

interface MemesView : BaseView {
    fun showLoading()
    fun showMemes(memes: List<Meme>)
    fun showError(error: ApplicationError)

    fun hideLoading()
    fun hideMemes()
    fun hideError()
}
