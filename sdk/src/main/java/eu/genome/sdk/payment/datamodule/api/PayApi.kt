package eu.genome.sdk.payment.datamodule.api

import eu.genome.sdk.payment.model.request.SalePayment
import eu.genome.sdk.payment.model.request.ThreeDPayment
import eu.genome.sdk.payment.model.response.BaseResponse
import io.reactivex.Single
import retrofit2.http.*

internal interface PayApi {

    @POST("cc")
    fun pay3D(@Body data: ThreeDPayment): Single<BaseResponse>

    @POST("cc")
    fun paySale(@Body payment: SalePayment): Single<Any>

    @POST("cc")
    fun pay(@Body payment: SalePayment): Single<BaseResponse>
}