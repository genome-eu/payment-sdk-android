package eu.genome.sdk.payment.ui.state

import androidx.lifecycle.MutableLiveData
import eu.genome.sdk.payment.model.PayInitInfo
import eu.genome.sdk.payment.model.PayPaymentInfo
import eu.genome.sdk.payment.model.request.PaymentDto
import eu.genome.sdk.payment.model.response.BaseResponse
import eu.genome.sdk.payment.utils.SingleLiveEvent

internal interface PaymentViewState {
     val salePaymentResponse: SingleLiveEvent<BaseResponse>
     val authPaymentResponse: SingleLiveEvent<BaseResponse>
     val savedSomething: MutableLiveData<String>
     val payInitData: MutableLiveData<PayInitInfo>
     val isFromWebView: MutableLiveData<Boolean>
     val tmpPaymentDtoData: MutableLiveData<PaymentDto>
     val payPaymentInfo: MutableLiveData<PayPaymentInfo>
}