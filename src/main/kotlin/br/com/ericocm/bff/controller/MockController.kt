package br.com.ericocm.bff.controller

import br.com.ericocm.bff.MockContent
import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.models.HttpMethod
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MockController {

    val staticContentPath = "/static/response"

    @GetMapping("{folder}/{file}")
    fun getGenericJson(@PathVariable folder: String, @PathVariable file : String) : Any? {
        val mockContent = fileJSONToObject(folder, file, HttpMethod.GET)
        return ResponseEntity.status(mockContent.httpStatus).body(mockContent.content)
    }

    @PostMapping("{folder}/{file}")
    fun postGenericJson(@PathVariable folder: String, @PathVariable file : String) : Any? {
        val mockContent = fileJSONToObject(folder, file, HttpMethod.POST)
        return ResponseEntity.status(mockContent.httpStatus).body(mockContent.content)
    }

    @PutMapping("{folder}/{file}")
    fun putGenericJson(@PathVariable folder: String, @PathVariable file : String) : Any? {
        val mockContent = fileJSONToObject(folder, file, HttpMethod.PUT)
        return ResponseEntity.status(mockContent.httpStatus).body(mockContent.content)
    }

    @DeleteMapping("{folder}/{file}")
    fun deleteGenericJson(@PathVariable folder: String, @PathVariable file : String) : ResponseEntity<Any?> {
        val mockContent = fileJSONToObject(folder, file, HttpMethod.DELETE)
        return ResponseEntity.status(mockContent.httpStatus).body(mockContent.content)
    }

    private fun fileJSONToObject(folder: String,file : String, httpMethod: HttpMethod) : MockContent {
        val fullPathName = "$staticContentPath/$folder/$httpMethod/$file.json"
        println(fullPathName)
        val resource = ClassPathResource(fullPathName)
        return ObjectMapper().readValue(resource.inputStream, MockContent::class.java)
    }


}