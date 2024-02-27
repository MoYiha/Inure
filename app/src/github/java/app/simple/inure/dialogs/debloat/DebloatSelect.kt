package app.simple.inure.dialogs.debloat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import app.simple.inure.R
import app.simple.inure.constants.DebloatSortConstants
import app.simple.inure.decorations.ripple.DynamicRippleTextView
import app.simple.inure.extensions.fragments.ScopedBottomSheetFragment

class DebloatSelect : ScopedBottomSheetFragment() {

    private lateinit var recommended: DynamicRippleTextView
    private lateinit var expert: DynamicRippleTextView
    private lateinit var all: DynamicRippleTextView

    private var debloatSelectCallback: DebloatSelectCallback? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_debloat_select, container, false)

        recommended = view.findViewById(R.id.select_recommended)
        expert = view.findViewById(R.id.select_expert)
        all = view.findViewById(R.id.select_all)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recommended.setOnClickListener {
            debloatSelectCallback?.onModeSelected(DebloatSortConstants.RECOMMENDED)
            dismiss()
        }

        expert.setOnClickListener {
            debloatSelectCallback?.onModeSelected(DebloatSortConstants.EXPERT)
            dismiss()
        }

        all.setOnClickListener {
            debloatSelectCallback?.onModeSelected(DebloatSortConstants.ALL_REMOVAL)
            dismiss()
        }
    }

    fun setOnDebloatSelectCallback(callback: DebloatSelectCallback) {
        debloatSelectCallback = callback
    }

    companion object {
        fun newInstance(): DebloatSelect {
            val args = Bundle()
            val fragment = DebloatSelect()
            fragment.arguments = args
            return fragment
        }

        fun FragmentManager.showDebloatSelectionDialog(): DebloatSelect {
            val dialog = newInstance()
            dialog.show(this, TAG)
            return dialog
        }

        interface DebloatSelectCallback {
            fun onModeSelected(mode: Int)
        }

        private const val TAG = "debloat_select"
    }
}