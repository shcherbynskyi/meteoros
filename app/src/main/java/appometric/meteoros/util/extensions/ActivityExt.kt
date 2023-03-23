package appometric.meteoros.util.extensions

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import appometric.meteoros.util.delegates.ActivityBindingDelegate

/**
 * Extension function to delegate initialization of data binding in activities
 *
 * @param layout - layout resource of the activity that is being initialized by this delegate
 */
fun <T : ViewDataBinding> AppCompatActivity.dataBinding(@LayoutRes layout: Int) =
    ActivityBindingDelegate<T>(this, layout)