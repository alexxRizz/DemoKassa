package ru.rizz.demokassa.features.mainmenu

import android.view.*
import ru.rizz.demokassa.*
import ru.rizz.demokassa.databinding.*
import ru.rizz.demokassa.ui.*

class MainMenuAdapter(
	private val mItems: List<MainMenuItem>,
	private val mOnClick: (pos: Int) -> Unit
) : RecyclerSingleViewAdapterBase<RowMainMenuItemBinding>() {

	override val layoutId get() = R.layout.row_main_menu_item

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