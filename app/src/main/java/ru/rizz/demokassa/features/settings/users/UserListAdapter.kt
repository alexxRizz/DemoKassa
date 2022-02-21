package ru.rizz.demokassa.features.settings.users

import android.view.*
import ru.rizz.demokassa.*
import ru.rizz.demokassa.databinding.*
import ru.rizz.demokassa.model.*
import ru.rizz.demokassa.ui.*

class UserListAdapter(
	private val mItems: List<User>,
	private val mOnClick: (pos: Int) -> Unit
) : RecyclerSingleViewAdapterBase<RowMainMenuItemBinding>() {

	override val layoutId get() = R.layout.row_user

	override fun onBinding(pos: Int, view: View) {
		view.setOnClickListener {
			mOnClick(pos)
		}
	}

	override fun getRow(pos: Int) =
		mItems[pos]

	override fun getItemCount() =
		mItems.size
}