package ru.rizz.demokassa.ui

import android.view.*
import androidx.annotation.*
import androidx.databinding.*
import androidx.recyclerview.widget.*
import ru.rizz.demokassa.*

abstract class RecyclerSingleViewAdapterBase<TBinding : ViewDataBinding>
	: RecyclerView.Adapter<RecyclerSingleViewAdapterBase.MyViewHolder>() {

	class MyViewHolder(root: View) : RecyclerView.ViewHolder(root)

	@get:LayoutRes protected abstract val layoutId: Int

	private lateinit var binding: TBinding

	protected open fun onBinding(pos: Int, view: View) = Unit

	protected abstract fun getRow(pos: Int): Any

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
		binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
		return MyViewHolder(binding.root)
	}

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		binding.setVariable(BR.vm, getRow(position))
		onBinding(position, holder.itemView)
		binding.executePendingBindings()
	}
}