package eu.genome.sdk.payment.utils.extensions

import android.graphics.Typeface
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import eu.genome.sdk.payment.R
import eu.genome.sdk.payment.model.PayTheme

internal fun TextView.makeLinks(vararg links: Pair<String, View.OnClickListener>, theme: PayTheme?) {
    val linkColor = theme?.let { it.hyperlinkColor?: ContextCompat.getColor(context, R.color.primary_green) }?: ContextCompat.getColor(context, R.color.primary_green)
    val spannableString = SpannableString(this.text)
    for (link in links) {
        val clickableSpan = object : ClickableSpan() {

            override fun updateDrawState(textPaint: TextPaint) {
                // use this to change the link color
                textPaint.color = linkColor
                // toggle below value to enable/disable
                // the underline shown below the clickable text
                textPaint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD);
                textPaint.isUnderlineText = false
            }

            override fun onClick(view: View) {
                Selection.setSelection((view as TextView).text as Spannable, 0)
                view.invalidate()
                link.second.onClick(view)
            }
        }
        val startIndexOfLink = this.text.toString().indexOf(link.first)
        spannableString.setSpan(clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    this.movementMethod = LinkMovementMethod.getInstance() // without LinkMovementMethod, link can not click
    this.setText(spannableString, TextView.BufferType.SPANNABLE)
}