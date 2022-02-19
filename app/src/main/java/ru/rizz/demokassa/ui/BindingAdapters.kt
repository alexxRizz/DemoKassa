package ru.rizz.demokassa.ui

import android.view.*
import android.widget.*
import androidx.annotation.*
import androidx.databinding.*

@BindingAdapter("android:src")
fun ImageView.setSrcBinding(@DrawableRes resId: Int) =
	setImageResource(resId)

@BindingAdapter("android:visibility")
fun View.setVisibilityBinding(isVisible: Boolean) {
	visibility = if (isVisible) View.VISIBLE else View.GONE
}