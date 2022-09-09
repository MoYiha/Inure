package app.simple.inure.factories.installer

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import app.simple.inure.viewmodels.installer.InstallerCertificatesViewModel
import app.simple.inure.viewmodels.installer.InstallerInformationViewModel
import app.simple.inure.viewmodels.installer.InstallerManifestViewModel
import app.simple.inure.viewmodels.installer.InstallerViewModel
import java.io.File

class InstallerViewModelFactory(private val uri: Uri? = null, private val file: File? = null) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val application = extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]!!

        return when {
            modelClass.isAssignableFrom(InstallerViewModel::class.java) -> {
                InstallerViewModel(application, uri!!) as T
            }
            modelClass.isAssignableFrom(InstallerManifestViewModel::class.java) -> {
                InstallerManifestViewModel(application, file!!) as T
            }
            modelClass.isAssignableFrom(InstallerInformationViewModel::class.java) -> {
                InstallerInformationViewModel(application, file!!) as T
            }
            modelClass.isAssignableFrom(InstallerCertificatesViewModel::class.java) -> {
                InstallerCertificatesViewModel(application, file!!) as T
            }
            else -> {
                throw IllegalArgumentException("Wrong ViewModel!!")
            }
        }
    }
}