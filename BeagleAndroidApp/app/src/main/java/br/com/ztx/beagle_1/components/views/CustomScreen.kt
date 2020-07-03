package br.com.ztx.beagle_1.components.views

import android.content.Context
import br.com.ztx.beagle_1.designsystem.StyleConstants
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.IMG_SCREEN_INFO_1
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.STYLE_BTN_BLACK
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.STYLE_BTN_ORANGE
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.STYLE_TXT_BOLD
import br.com.ztx.beagle_1.designsystem.StyleConstants.Tutorial.STYLE_TXT_NORMAL
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.Text

class CustomScreen(
    val context: Context,
    private val title: String,
    private val subtitle: String
) :
    CustomBeagleComponent {

    override fun getScreen(): Screen {
        return Screen(
            child = Container(
                children = listOf(
                    Image(
                        name = IMG_SCREEN_INFO_1
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
                        style = STYLE_TXT_BOLD
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
                        style = STYLE_TXT_NORMAL
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
                                text = StyleConstants.Tutorial.TXT_BTN_SKIP,
                                style = STYLE_BTN_BLACK
                            ),
                            Button(
                                text = StyleConstants.Tutorial.TXT_BTN_CONTINUE,
                                style = STYLE_BTN_ORANGE
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