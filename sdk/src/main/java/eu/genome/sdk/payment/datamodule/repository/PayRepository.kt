package eu.genome.sdk.payment.datamodule.repository

import eu.genome.sdk.payment.model.PayGatewayInfo
import eu.genome.sdk.payment.model.request.PaymentDto
import eu.genome.sdk.payment.model.response.BaseResponse
import io.reactivex.Single

internal interface PayRepository {

    fun pay(authPaymentDto: PaymentDto, gatewayInfo: PayGatewayInfo?): Single<BaseResponse>
}