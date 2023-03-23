package appometric.meteoros.util.extensions

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import appometric.meteoros.util.delegates.FragmentBindingDelegate

/**
 * Extension function to delegate initialization data binding in fragments
 *
 * @param layout - layout resource of the fragment that is being initialized by this delegate
 */
fun <T : ViewDataBinding> Fragment.dataBinding(@LayoutRes layout: Int) =
    FragmentBindingDelegate<T>(this, layout)