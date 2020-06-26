package br.com.ztx.beagle_1.components

import android.content.Context
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView

@RegisterWidget
class CustomWidgetTitleIncrease(
    private val title: String,
    private val buttonTitle1: String,
    private val buttonTitle2: String
) : WidgetView() {

    override fun buildView(context: Context) = TitleIncreaseComponent(context).apply {
        setTitleText(title)
        setTitleButton1(buttonTitle1)
        setTitleButton2(buttonTitle2)
    }

}