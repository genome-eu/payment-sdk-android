package eu.genome.sdk.payment

import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import eu.genome.sdk.payment.core.ProgressActivity
import eu.genome.sdk.payment.ui.MainViewModel
import eu.genome.sdk.payment.ui.PaymentFragment
import eu.genome.sdk.payment.utils.extensions.addFragmentToContainerWithoutBackStack
import eu.genome.sdk.payment.ui.navigation.ThreeDSNavigation
import eu.genome.sdk.payment.ui.threeds.ThreeDSFragment
import eu.genome.sdk.payment.utils.extensions.addFragmentToContainer
import eu.genome.sdk.payment.utils.extensions.observeCommandSafety
import kotlinx.android.synthetic.main.activity_sdk.*

internal class SdkActivity : ProgressActivity(R.layout.activity_sdk) {

    override fun getProgressBar(): ProgressBar = progressBar
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: addFragmentToContainerWithoutBackStack(
            PaymentFragment.newInstance()
        )

        viewModel.run {
            observeCommandSafety(mainNavigation) {
                when (it) {
                    ThreeDSNavigation -> {
                        addFragmentToContainer(
                            ThreeDSFragment.newInstance()
                        )
                    }
                }

            }
        }
    }
}
