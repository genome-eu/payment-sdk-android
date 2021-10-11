package eu.genome.sdk.payment.datamodule.repository

import eu.genome.sdk.payment.datamodule.api.Api
import eu.genome.sdk.payment.datamodule.api.PayApi
import eu.genome.sdk.payment.model.PayGatewayInfo
import eu.genome.sdk.payment.model.request.PaymentDto
import eu.genome.sdk.payment.model.response.BaseResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

internal class PayRepositoryImpl(
    private val api: Api
) : PayRepository {

    override fun pay(authPaymentDto: PaymentDto, gatewayInfo: PayGatewayInfo?): Single<BaseResponse> {
        return api.createApi(PayApi::class.java, gatewayInfo)
            .pay(authPaymentDto)
            .subscribeOn(Schedulers.io())
    }
}