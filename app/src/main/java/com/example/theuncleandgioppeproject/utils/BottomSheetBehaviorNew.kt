package com.example.theuncleandgioppeproject.utils

import android.content.Context
import android.view.View
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.google.android.material.bottomsheet.BottomSheetBehavior



class BottomSheetBehaviorNew<V : View>  : BottomSheetBehavior<View>() {
    @Override
    fun onStateChanged(bottomSheet: View, @State newState: Int) {}
    }
