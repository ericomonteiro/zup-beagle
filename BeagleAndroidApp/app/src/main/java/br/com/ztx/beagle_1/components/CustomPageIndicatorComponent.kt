package br.com.ztx.beagle_1.components

import br.com.ztx.beagle_1.components.views.CustomBeagleComponent
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.PageView
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextAlignment

class CustomPageIndicatorComponent : CustomBeagleComponent {

    override fun getScreen(): Screen {
        return Screen(
            child = Container(
                children = listOf(
                    PageView(
                        pageIndicator = CustomPageIndicator(),
                        pages = listOf(
                            Text("Page 1", alignment = TextAlignment.CENTER).applyFlex(
                                Flex(
                                    alignSelf = AlignSelf.CENTER,
                                    grow = 1.0
                                )
                            ),
                            Text("Page 2", alignment = TextAlignment.CENTER).applyFlex(
                                Flex(
                                    alignSelf = AlignSelf.CENTER,
                                    grow = 1.0
                                )
                            ),
                            Text("Page 3", alignment = TextAlignment.CENTER).applyFlex(
                                Flex(
                                    alignSelf = AlignSelf.CENTER,
                                    grow = 1.0
                                )
                            )
                        )
                    )
                )
            )
        )
    }
}