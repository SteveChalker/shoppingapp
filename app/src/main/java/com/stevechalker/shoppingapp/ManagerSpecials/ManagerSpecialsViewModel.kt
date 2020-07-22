package com.stevechalker.shoppingapp.ManagerSpecials

import androidx.lifecycle.MutableLiveData
import com.stevechalker.shoppingapp.data.ManagerSpecialsRepository
import com.stevechalker.shoppingapp.data.model.ManagerSpecial
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ManagerSpecialsViewModel @Inject constructor(
    private val repository: ManagerSpecialsRepository
) {
    private var disposable: Disposable? = null
    private val managerSpecialsObservable: MutableLiveData<List<ManagerSpecial>> by lazy {
        MutableLiveData<List<ManagerSpecial>>()
    }

    fun observeManagerSpecials() = managerSpecialsObservable

    fun fetchManagerSpecials() {
        disposable = repository.fetchManagerSpecials()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { managerSpecials ->
                managerSpecialsObservable.value = managerSpecials.managerSpecials
            }
    }
}