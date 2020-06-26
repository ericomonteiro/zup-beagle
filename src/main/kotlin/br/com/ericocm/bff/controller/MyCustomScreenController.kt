package br.com.ericocm.bff.controller

import br.com.ericocm.bff.controller.MyCustomScreenController.Colors.GRAY
import br.com.ericocm.bff.controller.MyCustomScreenController.Colors.ORANGE
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.SCREEN_INFO_1_SUBTITLE
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.SCREEN_INFO_1_TITLE
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.SCREEN_INFO_2_SUBTITLE
import br.com.ericocm.bff.controller.MyCustomScreenController.Constants.SCREEN_INFO_2_TITLE
import br.com.ericocm.bff.controller.MyCustomScreenController.Style.IMG_SCREEN_INFO_1
import br.com.ericocm.bff.controller.MyCustomScreenController.Style.IMG_SCREEN_INFO_2
import br.com.ericocm.bff.controller.components.ScreenInfo
import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.widget.core.AlignItems
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.FlexDirection
import br.com.zup.beagle.widget.core.JustifyContent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.PageView
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.pager.PageIndicator
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
                            ScreenInfo(SCREEN_INFO_1_TITLE, SCREEN_INFO_1_SUBTITLE, IMG_SCREEN_INFO_1).build(),
                            ScreenInfo(SCREEN_INFO_2_TITLE, SCREEN_INFO_2_SUBTITLE, IMG_SCREEN_INFO_2).build()
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

    private fun createViewPager(pages: List<ServerDrivenComponent>): PageView {
        return PageView(
            pageIndicator = PageIndicator(ORANGE, GRAY),
            pages = pages
        )
    }

    private object Constants {
        const val SCREEN_INFO_1_TITLE = "Bem vindo ao Beagle!"
        const val SCREEN_INFO_1_SUBTITLE = "Essa tela esta vindo de um servidor remoto."

        const val SCREEN_INFO_2_TITLE = "Torne o deploy mais rapido"
        const val SCREEN_INFO_2_SUBTITLE = "Voce agora pode realizar alteracoes no app sem precisar subir pra loja novamente"
    }

    private object Style {
        const val IMG_SCREEN_INFO_1 = "IMG_SCREEN_INFO_1"
        const val IMG_SCREEN_INFO_2 = "IMG_SCREEN_INFO_2"
    }

    private object Colors {
        const val GRAY = "#555555"
        const val ORANGE = "#F44336"
        const val RED = "#FF0000"
        const val GREEN = "#00FF00"
        const val BLUE = "#0000FF"
    }

}