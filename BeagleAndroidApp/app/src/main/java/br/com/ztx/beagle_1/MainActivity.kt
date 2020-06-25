package br.com.ztx.beagle_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ztx.beagle_1.MainActivity.Constants.SUBTITLE
import br.com.ztx.beagle_1.MainActivity.Constants.TITLE
import br.com.ztx.beagle_1.components.views.CustomScreen
import br.com.zup.beagle.utils.toView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initScreenBeagle()
    }

    private fun initScreenBeagle() {
        val customScreen = CustomScreen(this, TITLE, SUBTITLE).getScreen()
        test_content.addView(customScreen.toView(this))
    }

    private object Constants {
        const val TITLE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
        const val SUBTITLE = "Ut leo eros, porttitor sit amet metus vitae, bibendum porttitor nisi"
    }
}
