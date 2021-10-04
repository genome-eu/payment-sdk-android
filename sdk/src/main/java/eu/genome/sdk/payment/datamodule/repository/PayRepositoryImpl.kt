package eu.genome.sdk.payment.datamodule.repository

import eu.genome.sdk.payment.datamodule.api.Api
import eu.genome.sdk.payment.datamodule.api.PayApi
import eu.genome.sdk.payment.model.PayGatewayInfo
import eu.genome.sdk.payment.model.request.SalePayment
import eu.genome.sdk.payment.model.request.ThreeDPayment
import eu.genome.sdk.payment.model.response.BaseResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

internal class PayRepositoryImpl(
    private val api: Api
): PayRepository {
    override fun pay3D(salePayment: ThreeDPayment, gatewayInfo: PayGatewayInfo): Single<BaseResponse> {
        return api.createApi(PayApi::class.java, gatewayInfo)
            .pay3D(salePayment)
            .subscribeOn(Schedulers.io())
    }

    override fun pay(authPayment: SalePayment, gatewayInfo: PayGatewayInfo?): Single<BaseResponse> {
        return api.createApi(PayApi::class.java, gatewayInfo)
            .pay(authPayment)
            .subscribeOn(Schedulers.io())
    }
}