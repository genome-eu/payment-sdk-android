package eu.genome.sdk.payment.ui.state

import androidx.lifecycle.MutableLiveData
import eu.genome.sdk.payment.model.PayInitInfo
import eu.genome.sdk.payment.model.PayPaymentInfo
import eu.genome.sdk.payment.model.request.SalePayment
import eu.genome.sdk.payment.model.response.BaseResponse
import eu.genome.sdk.payment.utils.SingleLiveEvent

internal interface PaymentViewState {
     val salePaymentResponse: SingleLiveEvent<BaseResponse>
     val authPaymentResponse: SingleLiveEvent<BaseResponse>
     val savedSomething: MutableLiveData<String>
     val payInitData: MutableLiveData<PayInitInfo>
     val isFromWebView: MutableLiveData<Boolean>
     val tmpPaymentData: MutableLiveData<SalePayment>
     val payPaymentInfo: MutableLiveData<PayPaymentInfo>
}