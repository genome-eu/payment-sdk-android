package eu.genome.sdk.payment.datamodule.api

import eu.genome.sdk.payment.model.request.PaymentDto
import eu.genome.sdk.payment.model.response.BaseResponse
import io.reactivex.Single
import retrofit2.http.*

internal interface PayApi {

    @POST("cc")
    fun pay(@Body paymentDto: PaymentDto): Single<BaseResponse>
}