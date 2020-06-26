package br.com.ericocm.bff.controller

import br.com.ericocm.bff.controller.MyCustomScreenController.Colors.GRAY
import br.com.ericocm.bff.controller.MyCustomScreenController.Colors.ORANGE
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.BTN_TEXT_BLACK
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.BTN_TEXT_ORANGE
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.SAMPLE_TXT_1
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.SAMPLE_TXT_2
import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.core.Appearance
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.PageView
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.pager.PageIndicator
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.Text
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

//TODO Remover magic numbers
//TODO Mover objects para outro lugar
@RestController
class MyCustomScreenController() {

    @BeaglePreview
    @GetMapping("/custom_screen")
    fun getScreen(): Screen {
        return Screen(
            child = Container(
                children = listOf(
                    createViewPager(
                        listOf(
                            createFirstPage()
                        )
                    )
                )
            ).applyFlex(
                Flex(
                    flexDirection = FlexDirection.COLUMN,
                    justifyContent = JustifyContent.SPACE_BETWEEN,
                    alignItems = AlignItems.CENTER,
                    grow = 1.0
                )
            )
        )
    }

    private fun createFirstPage(): Widget {
        return Container(
            children = listOf(
                createImage(),
                createGroupedText(SAMPLE_TXT_1, SAMPLE_TXT_2),
                createBottomNavigation()
            )
        ).applyFlex(
            Flex(
                flexDirection = FlexDirection.COLUMN,
                justifyContent = JustifyContent.SPACE_BETWEEN,
                alignItems = AlignItems.CENTER,
                grow = 1.0
            )
        )
    }

    private fun createViewPager(pages: List<ServerDrivenComponent>): PageView {
        return PageView(
            pageIndicator = PageIndicator(ORANGE, GRAY),
            pages = pages
        )
    }

    private fun createImage(): Widget {
        return Image(
            name = Style.IMG_INIT
        ).applyFlex(
            Flex(
                flexWrap = FlexWrap.WRAP,
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

        const val SAMPLE_TXT_1 = "Bem vindo ao Beagle!"
        const val SAMPLE_TXT_2 = "Essa tela esta vindo de um servidor remoto."
    }

    private object Style {
        const val BTN_ORANGE = "BTN_ORANGE"
        const val BTN_BLACK = "BTN_BLACK"
        const val IMG_INIT = "IMG_INIT"
        const val TXT_BOLD = "TXT_BOLD"
        const val TXT_NORMAL = "TXT_NORMAL"
    }

    private object Colors {
        const val GRAY = "#555555"
        const val ORANGE = "#F44336"
        const val RED = "#FF0000"
        const val GREEN = "#00FF00"
        const val BLUE = "#0000FF"
    }
}