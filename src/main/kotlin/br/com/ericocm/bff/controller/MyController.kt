package br.com.ericocm.bff.controller

import br.com.ericocm.bff.service.MyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController(private val myService: MyService) {
    @GetMapping("/action")
    fun getAction() = myService.createAction()

    @GetMapping("/screen")
    fun getScreen() = myService.createScreen()

    @GetMapping("/builder")
    fun getScreenBuilder() = myService.createScreenBuilder()

    @GetMapping("/widget")
    fun getWidget() = myService.createWidget()
}