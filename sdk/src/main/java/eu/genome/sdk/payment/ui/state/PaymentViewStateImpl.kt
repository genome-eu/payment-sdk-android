package eu.genome.sdk.payment.ui.state

import androidx.lifecycle.MutableLiveData
import eu.genome.sdk.payment.model.PayInitInfo
import eu.genome.sdk.payment.model.PayPaymentInfo
import eu.genome.sdk.payment.model.request.SalePayment
import eu.genome.sdk.payment.model.response.BaseResponse
import eu.genome.sdk.payment.utils.SingleLiveEvent

internal class PaymentViewStateImpl : PaymentViewState {
    override val salePaymentResponse: SingleLiveEvent<BaseResponse> = SingleLiveEvent()
    override val authPaymentResponse: SingleLiveEvent<BaseResponse> = SingleLiveEvent()
    override val savedSomething: MutableLiveData<String> = MutableLiveData()
    override val payInitData: MutableLiveData<PayInitInfo> = MutableLiveData()
    override val isFromWebView: MutableLiveData<Boolean> = MutableLiveData()

    override val tmpPaymentData: MutableLiveData<SalePayment> = MutableLiveData()
    override val payPaymentInfo: MutableLiveData<PayPaymentInfo> = MutableLiveData()
}