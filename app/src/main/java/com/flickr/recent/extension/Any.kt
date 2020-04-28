package com.flickr.recent.extension

import android.os.Handler

fun delay(delayMillis: Long, block: () -> Unit) {
    Handler().postDelayed({ block() }, delayMillis)
}
