package br.com.ztx.beagle_1.components.pageindicator

import android.content.Context
import android.view.View
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.pager.PageIndicatorComponent
import br.com.zup.beagle.widget.pager.PageIndicatorOutput

@RegisterWidget
data class CustomPageIndicator(
    val skipName: String? = null,
    val continueName: String? = null
) : PageIndicatorComponent {

    @Transient
    private lateinit var customPageIndicatorView: CustomPageIndicatorView
    @Transient
    private lateinit var output: PageIndicatorOutput

    override fun initPageView(pageIndicatorOutput: PageIndicatorOutput) {
        output = pageIndicatorOutput
    }

    override fun onItemUpdated(newIndex: Int) {
        customPageIndicatorView.setCurrentIndex(newIndex)
    }

    override fun setCount(pages: Int) {
        customPageIndicatorView.setCount(pages)
    }

    override fun buildView(context: Context): View = CustomPageIndicatorView(
        context
    ).apply {
        skipName?.let {
            setSkipName(it)
        }
        continueName?.let {
            setContinueName(it)
        }
        customPageIndicatorView = this
        setIndexChangedListener { index ->
            output.swapToPage(index)
        }
    }
}
