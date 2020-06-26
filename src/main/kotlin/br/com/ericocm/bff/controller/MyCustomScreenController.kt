package br.com.ericocm.bff.controller

import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.BTN_TEXT_BLACK
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.BTN_TEXT_ORANGE
import br.com.ericocm.bff.service.MyService
import br.com.zup.beagle.ext.unitReal
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

@RestController
class MyCustomScreenController(private val service: MyService) {

    object Constants {
        const val BTN_TEXT_BLACK = "jump"
        const val BTN_TEXT_ORANGE = "continue"
        const val TEXT_MESSAGE = "Toast button clicked!"
    }

    object Style {
        const val BTN_ORANGE = "BTN_ORANGE"
        const val BTN_BLACK = "BTN_BLACK"
        const val IMG_INIT = "IMG_INIT"
        const val TXT_BOLD = "TXT_BOLD"
        const val TXT_NORMAL = "TXT_NORMAL"
    }

    @GetMapping("/custom_screen")
    fun getScreen(): Screen {
        val title = "Bem vindo ao Beagle!"
        val subtitle = "Essa tela esta vindo de um servidor remoto"
        return Screen(
            child = Container(
                children = listOf(
                    PageView(
                        pageIndicator = PageIndicator("RED", "GRAY"),
                        pages = listOf(
                            Container(
                                children = listOf(
                                    Image(
                                        name = Style.IMG_INIT
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
                                        style = Style.TXT_BOLD
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
                                        style = Style.TXT_NORMAL
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
                            ),
                            Container (
                                children = listOf(
                                    Text (
                                        text = "Second page"
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}