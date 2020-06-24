package br.com.ericocm.bff.controller

import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.models.HttpMethod
import org.springframework.core.io.ClassPathResource
import org.springframework.web.bind.annotation.*

@RestController
class MockController {

    val staticContentPath = "/static/response"

    @GetMapping("{folder}/{file}")
    fun getGenericJson(@PathVariable folder: String, @PathVariable file : String) : Any? {
        return fileJSONToObject(folder, file, HttpMethod.GET)
    }

    @PostMapping("{folder}/{file}")
    fun postGenericJson(@PathVariable folder: String, @PathVariable file : String) : Any? {
        return fileJSONToObject(folder, file, HttpMethod.POST)
    }

    @PutMapping("{folder}/{file}")
    fun putGenericJson(@PathVariable folder: String, @PathVariable file : String) : Any? {
        return fileJSONToObject(folder, file, HttpMethod.PUT)
    }

    @DeleteMapping("{folder}/{file}")
    fun deleteGenericJson(@PathVariable folder: String, @PathVariable file : String) : Any? {
        return fileJSONToObject(folder, file, HttpMethod.DELETE)
    }

    private fun fileJSONToObject(folder: String,file : String, httpMethod: HttpMethod) : Any? {
        val fullPathName = "$staticContentPath/$folder/$httpMethod/$file.json"
        println(fullPathName)
        val resource = ClassPathResource(fullPathName)
        return ObjectMapper().readValue(resource.inputStream, Any::class.java)
    }


}