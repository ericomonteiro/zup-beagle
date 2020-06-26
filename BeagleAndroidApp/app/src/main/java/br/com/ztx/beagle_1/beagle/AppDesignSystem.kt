package br.com.ztx.beagle_1.beagle

import br.com.ztx.beagle_1.R
import br.com.ztx.beagle_1.beagle.AppDesignSystem.Style.BTN_BLACK
import br.com.ztx.beagle_1.beagle.AppDesignSystem.Style.BTN_ORANGE
import br.com.ztx.beagle_1.beagle.AppDesignSystem.Style.IMG_INIT
import br.com.ztx.beagle_1.beagle.AppDesignSystem.Style.IMG_SCREEN_INFO_1
import br.com.ztx.beagle_1.beagle.AppDesignSystem.Style.IMG_SCREEN_INFO_2
import br.com.ztx.beagle_1.beagle.AppDesignSystem.Style.TXT_BOLD
import br.com.ztx.beagle_1.beagle.AppDesignSystem.Style.TXT_NORMAL
import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.setup.DesignSystem

@BeagleComponent
class AppDesignSystem : DesignSystem {

    object Style {
        const val BTN_ORANGE = "BTN_ORANGE"
        const val BTN_BLACK = "BTN_BLACK"

        const val IMG_SCREEN_INFO_1 = "IMG_SCREEN_INFO_1"
        const val IMG_SCREEN_INFO_2 = "IMG_SCREEN_INFO_2"

        const val TXT_BOLD = "TXT_BOLD"
        const val TXT_NORMAL = "TXT_NORMAL"
    }

    override fun toolbarStyle(name: String): Int =
        R.style.Toolbar

    override fun buttonStyle(name: String): Int {
        return when (name) {
            BTN_ORANGE -> R.style.buttonOrange
            BTN_BLACK -> R.style.buttonBlack
            else -> R.style.buttonBlack
        }
    }

    override fun image(name: String): Int {
        return when (name) {
            IMG_SCREEN_INFO_1 -> R.mipmap.ic_screen_info_1_round
            IMG_SCREEN_INFO_2 -> R.mipmap.ic_screen_info_2_round
            else -> android.R.drawable.ic_menu_help
        }
    }

    override fun textAppearance(name: String): Int {
        return when (name) {
            TXT_BOLD -> R.style.tVTitle
            TXT_NORMAL -> R.style.tVSubtitle
            else -> R.style.TextBlack
        }
    }

    override fun tabBarStyle(name: String): Int? {
        return R.style.AppTheme
    }

    override fun theme(): Int {
        return R.style.AppTheme
    }
}