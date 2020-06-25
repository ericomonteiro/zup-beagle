package br.com.ztx.beagle_1.components.views

import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.widget.layout.Screen

interface CustomBeagleComponent {

    @BeaglePreview
    fun getScreen(): Screen
}