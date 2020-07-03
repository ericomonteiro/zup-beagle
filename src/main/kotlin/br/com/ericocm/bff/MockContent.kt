package br.com.ericocm.bff

import com.fasterxml.jackson.annotation.JsonProperty

class MockContent(
    @JsonProperty("httpStatus")
    val httpStatus: Int,

    @JsonProperty("content")
    val content: Any?
)