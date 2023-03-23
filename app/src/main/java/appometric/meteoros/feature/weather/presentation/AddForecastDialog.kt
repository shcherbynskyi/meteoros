package appometric.meteoros.feature.weather.presentation

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import appometric.meteoros.R
import appometric.meteoros.databinding.DialogAddForecastBinding

class AddForecastDialog(
    private val passedContext: Context,
    private val onPositiveClick: ((cityName: String) -> Unit)? = null,
    private val onNegativeClick: (() -> Unit)? = null
) : AppCompatDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val binding: DialogAddForecastBinding = DataBindingUtil.inflate(
            LayoutInflater.from(passedContext),
            R.layout.dialog_add_forecast,
            null,
            false
        )

        return AlertDialog.Builder(passedContext)
            .setView(binding.root)
            .setTitle(passedContext.getString(R.string.dialog_add_forecast_title_text))
            .setPositiveButton(passedContext.getString(R.string.dialog_add_forecast_positive_button_text)) { _, _ ->
                onPositiveClick?.invoke(binding.dialogAddForecastCityNameEditText.text.toString())
            }
            .setNegativeButton(passedContext.getString(R.string.dialog_add_forecast_negative_button_text)) { dialog, _ ->
                onNegativeClick?.invoke()
                dialog.dismiss()
            }
            .create()
    }
}