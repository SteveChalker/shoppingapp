package com.stevechalker.shoppingapp.manager_specials

import androidx.lifecycle.MutableLiveData
import com.stevechalker.shoppingapp.data.ManagerSpecialsRepository
import com.stevechalker.shoppingapp.data.model.ManagersSpecialResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ManagerSpecialsViewModel @Inject constructor(
    private val repository: ManagerSpecialsRepository
) {
    private var disposable: Disposable? = null
    private val managerSpecialsObservable: MutableLiveData<ManagersSpecialResponse> by lazy {
        MutableLiveData<ManagersSpecialResponse>()
    }

    fun observeManagerSpecials() = managerSpecialsObservable

    fun fetchManagerSpecials() {
        disposable = repository.fetchManagerSpecials()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { managerSpecialsResponse ->
                managerSpecialsObservable.value = managerSpecialsResponse
            }
    }

    fun disposeObservable() {
        disposable?.dispose()
    }
}