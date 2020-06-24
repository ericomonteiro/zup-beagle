package br.com.ztx.beagle_1.components.views

import android.content.Context
import br.com.ztx.beagle_1.AppDesignSystem
import br.com.ztx.beagle_1.components.CustomBeagleComponent
import br.com.ztx.beagle_1.components.actions.CustomAction
import br.com.ztx.beagle_1.components.views.CustomScreen.Constants.BTN_TEXT_BLACK
import br.com.ztx.beagle_1.components.views.CustomScreen.Constants.BTN_TEXT_ORANGE
import br.com.ztx.beagle_1.components.views.CustomScreen.Constants.TEXT_MESSAGE
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.Text

class CustomScreen(val context: Context, val title: String, val subtitle: String) :
    CustomBeagleComponent {

    object Constants {
        const val BTN_TEXT_BLACK = "jump"
        const val BTN_TEXT_ORANGE = "continue"
        const val TEXT_MESSAGE = "Toast button clicked!"
    }

    override fun getScreen(): Screen {
        return Screen(
            child = Container(
                children = listOf(
                    Image(
                        name = AppDesignSystem.Style.IMG_INIT
                    ).applyFlex(
                        Flex(
                            size = Size(
                                width = 225.unitReal(),
                                height = 225.unitReal()
                            ),
                            margin = EdgeValue(
                                top = 116.unitReal(),
                                start = 64.unitReal(),
                                end = 64.unitReal()
                            ), alignSelf = AlignSelf.CENTER
                        )
                    ),
                    Text(
                        text = title,
                        style = AppDesignSystem.Style.TXT_BOLD
                    ).applyFlex(
                        Flex(
                            margin = EdgeValue(
                                top = 40.unitReal(),
                                start = 24.unitReal(),
                                end = 24.unitReal()
                            ), alignSelf = AlignSelf.CENTER
                        )
                    ),
                    Text(
                        text = subtitle,
                        style = AppDesignSystem.Style.TXT_NORMAL
                    ).applyFlex(
                        Flex(
                            margin = EdgeValue(
                                top = 8.unitReal(),
                                start = 24.unitReal(),
                                end = 24.unitReal()
                            )
                        )
                    ),
                    Container(
                        children = listOf(
                            Button(
                                text = BTN_TEXT_BLACK,
                                style = AppDesignSystem.Style.BTN_BLACK,
                                action =
                                CustomAction(
                                    context,
                                    TEXT_MESSAGE
                                )
                            ),
                            Button(
                                text = BTN_TEXT_ORANGE,
                                style = AppDesignSystem.Style.BTN_ORANGE,
                                action = CustomAction(
                                    context,
                                    TEXT_MESSAGE
                                )
                            )
                        )
                    ).applyFlex(
                        Flex(
                            flexDirection = FlexDirection.ROW,
                            alignItems = AlignItems.FLEX_END,
                            justifyContent = JustifyContent.SPACE_BETWEEN,
                            margin = EdgeValue(
                                top = 108.unitReal(),
                                end = 24.unitReal(),
                                left = 24.unitReal()
                            )
                        )
                    )
                )
            )
        )
    }
}