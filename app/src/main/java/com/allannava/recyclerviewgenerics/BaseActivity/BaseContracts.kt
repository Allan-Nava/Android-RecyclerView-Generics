package com.allannava.recyclerviewgenerics.BaseActivity

import android.app.Activity
import android.content.Context
import android.os.Bundle

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */
interface BaseContracts {

    interface View {
        fun getActivityContext(): Context?
        fun showErrorDialog(error: String?)
    }

    interface Presenter {
        fun onCreate(bundle: Bundle? = null) {}
        fun onResume() {}
        fun onPause() {}
        fun onDestroy()
    }

    interface Interactor {
        fun unregister()
    }

    interface InteractorOutput //does nothing for now

    interface Router {
        var activity: Activity?
        fun unregister()
    }
}