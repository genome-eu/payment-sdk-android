package eu.genome.sdk.payment.datamodule.repository

import eu.genome.sdk.payment.model.PayGatewayInfo
import eu.genome.sdk.payment.model.request.SalePayment
import eu.genome.sdk.payment.model.request.ThreeDPayment
import eu.genome.sdk.payment.model.response.BaseResponse
import io.reactivex.Single

internal interface PayRepository {
    fun pay3D(salePayment: ThreeDPayment, gatewayInfo: PayGatewayInfo): Single<BaseResponse>
    fun pay(authPayment: SalePayment, gatewayInfo: PayGatewayInfo?): Single<BaseResponse>
}