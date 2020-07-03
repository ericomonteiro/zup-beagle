package br.com.ztx.beagle_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.ztx.beagle_1.MainActivity.Constants.SUBTITLE
import br.com.ztx.beagle_1.MainActivity.Constants.TITLE
import br.com.ztx.beagle_1.beagle.AppBeagleConfig
import br.com.ztx.beagle_1.components.CustomPageIndicatorComponent
import br.com.ztx.beagle_1.components.views.CustomScreen
import br.com.zup.beagle.utils.toView
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ScreenRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        val repository = MainRepository()
        val factory = MainViewModel.ViewModelFactory(repository)
        ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        initScreenBeagle()
        //getRemoteJson()
        showScreenServerDrivenUI()
    }

    private fun initScreenBeagle() {
        //val customScreen = CustomScreen(this, TITLE, SUBTITLE).getScreen()
        //test_content.addView(customScreen.toView(this))
        val customPageIndicator = CustomPageIndicatorComponent().getScreen()
        test_content.addView(customPageIndicator.toView(this))
    }

    private fun getRemoteJson() {
        viewModel.getRemoteScreen().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun showScreenServerDrivenUI() {
        val beagleConfig = AppBeagleConfig()
        val intent = BeagleActivity.newIntent(this, ScreenRequest(beagleConfig.baseUrl))
        startActivity(intent)
        finish()
    }

    private object Constants {
        const val TITLE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
        const val SUBTITLE = "Ut leo eros, porttitor sit amet metus vitae, bibendum porttitor nisi"
    }


}
