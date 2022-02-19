package ru.rizz.demokassa.ui

import android.content.*
import android.widget.*
import dagger.hilt.android.qualifiers.*
import javax.inject.*

class ViewService @Inject constructor(
	@ActivityContext private val mContext: Context
) {
	fun showToast(text: String) =
		Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show()
}