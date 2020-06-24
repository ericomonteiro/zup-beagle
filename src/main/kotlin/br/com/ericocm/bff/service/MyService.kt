package br.com.ericocm.bff.service

import br.com.zup.beagle.action.Action
import br.com.zup.beagle.action.ShowNativeDialog
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextAlignment
import org.springframework.stereotype.Service

@Service
class MyService {
    fun createAction(): Action = ShowNativeDialog(
            title = "My Dialog",
            message = "This is a native popup!",
            buttonText = "Close"
    )

    fun createScreen(): Screen = Screen(child = this.createWidget())

    fun createScreenBuilder(): ScreenBuilder = MyScreenBuilder(this.createWidget())

    fun createWidget(): Widget = Text(
            text = "Hello, world!",
            alignment = TextAlignment.CENTER,
            textColor = "#505050"
    )
}

private class MyScreenBuilder(
        private val component: ServerDrivenComponent
) : ScreenBuilder {
    override fun build() = Screen(child = this.component)
}