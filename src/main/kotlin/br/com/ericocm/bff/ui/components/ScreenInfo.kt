package br.com.ericocm.bff.ui.components

import br.com.ericocm.bff.ui.components.ScreenInfo.Constants.BTN_TEXT_BLACK
import br.com.ericocm.bff.ui.components.ScreenInfo.Constants.BTN_TEXT_ORANGE
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.Text

class ScreenInfo(val title: String, val subtitle: String, val imageStyle: String) {

    fun build(): Widget {
        return createFirstPage()
    }

    private fun createFirstPage(): Widget {
        return Container(
            children = listOf(
                createImage(),
                createGroupedText(title, subtitle)
            )
        ).applyFlex(
            Flex(
                flexDirection = FlexDirection.COLUMN,
                justifyContent = JustifyContent.SPACE_BETWEEN,
                alignItems = AlignItems.CENTER
            )
        )
    }

    private fun createImage(): Widget {
        return Image(
            name = imageStyle
        ).applyFlex(
            Flex(
                flexWrap = FlexWrap.WRAP,
                size = Size(
                    width = 232.unitReal(),
                    height = 232.unitReal()
                ),
                margin = EdgeValue(
                    top = 136.unitReal(),
                    start = 64.unitReal(),
                    end = 64.unitReal()
                ), alignSelf = AlignSelf.CENTER
            )
        )
    }

    private fun createGroupedText(title: String, subtitle: String): Widget {
        return Container(
            children = listOf(
                Text(
                    text = title,
                    style = Style.TXT_BOLD
                ).applyFlex(
                    Flex(
                        flexWrap = FlexWrap.WRAP,
                        margin = EdgeValue(
                            top = 40.unitReal(),
                            start = 24.unitReal(),
                            end = 24.unitReal()
                        ), alignSelf = AlignSelf.CENTER
                    )
                ),
                Text(
                    text = subtitle,
                    style = Style.TXT_NORMAL
                ).applyFlex(
                    Flex(
                        flexWrap = FlexWrap.WRAP,
                        margin = EdgeValue(
                            top = 8.unitReal(),
                            start = 24.unitReal(),
                            end = 24.unitReal()
                        )
                    )
                )
            )
        )
    }

    private fun createBottomNavigation(): Widget {
        return Container(
            children = listOf(
                Button(
                    text = BTN_TEXT_BLACK,
                    style = Style.BTN_BLACK
                ),
                Button(
                    text = BTN_TEXT_ORANGE,
                    style = Style.BTN_ORANGE
                )
            )
        ).applyFlex(
            Flex(
                flexDirection = FlexDirection.ROW,
                alignItems = AlignItems.CENTER,
                justifyContent = JustifyContent.SPACE_BETWEEN,
                margin = EdgeValue(
                    top = 108.unitReal(),
                    end = 24.unitReal(),
                    left = 24.unitReal()
                )
            )
        )
    }

    private object Constants {
        const val BTN_TEXT_BLACK = "pular"
        const val BTN_TEXT_ORANGE = "continuar"
        const val TEXT_MESSAGE = "Toast button clicked!"

    }

    private object Style {
        const val BTN_ORANGE = "BTN_ORANGE"
        const val BTN_BLACK = "BTN_BLACK"
        const val TXT_BOLD = "TXT_BOLD"
        const val TXT_NORMAL = "TXT_NORMAL"
    }

}