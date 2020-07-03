package br.com.ztx.beagle_1.beagle

import br.com.ztx.beagle_1.R
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.IMG_SCREEN_INFO_1
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.IMG_SCREEN_INFO_2
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.STYLE_BTN_BLACK
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.STYLE_BTN_ORANGE
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.STYLE_TXT_BOLD
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.STYLE_TXT_NORMAL
import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.setup.DesignSystem

@BeagleComponent
class AppDesignSystem : DesignSystem {

    override fun toolbarStyle(name: String): Int = R.style.Toolbar

    override fun buttonStyle(name: String): Int {
        return when (name) {
            STYLE_BTN_ORANGE -> R.style.buttonOrange
            STYLE_BTN_BLACK -> R.style.buttonBlack
            else -> R.style.buttonBlack
        }
    }

    override fun image(name: String): Int {
        return when (name) {
            IMG_SCREEN_INFO_1 -> R.drawable.img_fazenda
            IMG_SCREEN_INFO_2 -> R.drawable.img_ponte
            else -> android.R.drawable.ic_menu_help
        }
    }

    override fun textAppearance(name: String): Int {
        return when (name) {
            STYLE_TXT_BOLD -> R.style.tVTitle
            STYLE_TXT_NORMAL -> R.style.tVSubtitle
            else -> R.style.tVSubtitle
        }
    }

    override fun tabBarStyle(name: String): Int? {
        return R.style.AppTheme
    }

    override fun theme(): Int {
        return R.style.AppTheme
    }
}