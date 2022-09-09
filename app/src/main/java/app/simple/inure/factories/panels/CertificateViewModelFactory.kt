package app.simple.inure.factories.panels

import android.content.pm.PackageInfo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import app.simple.inure.viewmodels.viewers.CertificatesViewModel
import java.io.File

class CertificateViewModelFactory(private val packageInfo: PackageInfo?, private val file: File?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val application = extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]!!

        @Suppress("UNCHECKED_CAST") // Cast is checked
        when {
            modelClass.isAssignableFrom(CertificatesViewModel::class.java) -> {
                return CertificatesViewModel(application, packageInfo, file) as T
            }
            else -> {
                throw IllegalArgumentException("Nope!!, Wrong Viewmodel!!")
            }
        }
    }
}