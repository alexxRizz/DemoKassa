package ru.rizz.demokassa.features.common

import android.os.*
import android.view.*
import androidx.databinding.*
import androidx.fragment.app.*
import ru.rizz.demokassa.*
import javax.inject.*

abstract class FragmentBase<
	TModel : ViewModelBase,
	TEvent : IVmEvent,
	TBinding : ViewDataBinding> : Fragment() {

	protected abstract val layoutId: Int
	protected abstract val vm: TModel
	protected abstract fun onEvent(ev: TEvent)

	protected lateinit var binding: TBinding private set
	protected lateinit var screens: Screens private set

	@Inject
	fun init(screens: Screens) {
		this.screens = screens
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
		binding.lifecycleOwner = viewLifecycleOwner
		binding.setVariable(BR.vm, vm)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		vm.eventsFlow.launchAndCollectIn(viewLifecycleOwner) {
			@Suppress("UNCHECKED_CAST")
			onEvent(it as TEvent)
		}
	}
}