package br.com.ztx.beagle_1.beagle

import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.networking.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException

@BeagleComponent
class AppCustomClient : HttpClient {

    override fun execute(
        request: RequestData,
        onSuccess: (responseData: ResponseData) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ): RequestCall {

        val requestBuilder = Request.Builder().url(request.uri.toString())

        addMethod(request, requestBuilder)
        addHeaders(request.headers, requestBuilder)

        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val newRequest = chain.request().newBuilder()
                    .header("KEY", "VALUE")
                    .build()

                return chain.proceed(newRequest)
            }
        })

        val requestCall = httpClient.build().newCall(requestBuilder.build())
        requestCall.enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                onError(e)
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    onSuccess(createResponseData(response))
                } else {
                    onError(IOException("Unexpected error with status code ${response.code}"))
                }
            }
        })

        return object: RequestCall {
            override fun cancel() {
                requestCall.cancel()
            }
        }
    }

    private fun createResponseData(response: Response): ResponseData {
        val body = response.body?.bytes() ?: byteArrayOf()
        val headers = mutableMapOf<String, String>()
        (0 until response.headers.size).forEach {
            val headerName = response.headers.name(it)
            val headerValue = response.headers.value(it)
            headers[headerName] = headerValue
        }
        return ResponseData(response.code, body, headers)
    }

    private fun addHeaders(headers: Map<String, String>, requestBuilder: Request.Builder) {
        headers.forEach {
            requestBuilder.addHeader(it.key, it.value)
        }
    }

    private fun addMethod(requestData: RequestData, requestBuilder: Request.Builder) {
        when (requestData.method) {
            HttpMethod.GET -> requestBuilder.get()
            HttpMethod.POST -> requestBuilder.post(createRequestBody(requestData.body))
            HttpMethod.DELETE -> requestBuilder.delete()
            HttpMethod.PUT -> requestBuilder.put(createRequestBody(requestData.body))
            HttpMethod.PATCH -> requestBuilder.patch(createRequestBody(requestData.body))
            HttpMethod.HEAD -> requestBuilder.head()
        }
    }

    private fun createRequestBody(body: String?): RequestBody {
        val contentType = "application/json; charset=utf-8".toMediaType();
        val bodyValue = body ?: ""
        return bodyValue.toRequestBody(contentType)
    }
}