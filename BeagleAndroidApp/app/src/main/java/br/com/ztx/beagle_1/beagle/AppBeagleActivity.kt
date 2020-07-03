package br.com.ztx.beagle_1.beagle

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import br.com.ztx.beagle_1.R
import br.com.ztx.beagle_1.beagle.AppBeagleActivity.ErrorMessage.ERROR
import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ServerDrivenState
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_app_beagle.*

@BeagleComponent
class AppBeagleActivity : BeagleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_beagle)
    }

    override fun getServerDrivenContainerId(): Int = R.id.server_driven_container

    override fun getToolbar(): Toolbar = custom_toolbar

    override fun onServerDrivenContainerStateChanged(state: ServerDrivenState) {
        if (state is ServerDrivenState.Loading) {
            progress_bar.visibility = if (state.loading) View.VISIBLE else View.GONE
        } else if (state is ServerDrivenState.Error) {
            Log.d(BeagleTag.TAG, "$ERROR: $state")
            Snackbar.make(window.decorView, "Error", Snackbar.LENGTH_LONG).show()
        }
    }

    private object BeagleTag {
        const val TAG = "BEAGLE_TAG"
    }

    private object ErrorMessage {
        const val ERROR = "ERROR"
    }
}
