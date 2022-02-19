package ru.rizz.demokassa.ui

import android.os.*
import android.view.*
import androidx.databinding.*
import androidx.fragment.app.*
import ru.rizz.demokassa.*
import ru.rizz.demokassa.features.common.*
import javax.inject.*

abstract class FragmentBase<
	TModel : ViewModelBase,
	TEvent : IVmEvent,
	TBinding : ViewDataBinding> : Fragment() {

	protected abstract val layoutId: Int
	protected abstract val vm: TModel
	protected abstract fun onEvent(ev: TEvent)
	protected abstract fun onViewCreated()

	protected lateinit var binding: TBinding private set
	protected lateinit var screens: Screens private set
	protected lateinit var viewService: ViewService private set

	@Inject
	fun init(screens: Screens, viewService: ViewService) {
		this.screens = screens
		this.viewService = viewService
	}

	final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
		binding.lifecycleOwner = viewLifecycleOwner
		binding.setVariable(BR.vm, vm)
		return binding.root
	}

	final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		vm.eventsFlow.launchAndCollectIn(viewLifecycleOwner) {
			@Suppress("UNCHECKED_CAST")
			onEvent(it as TEvent)
		}
		onViewCreated()
	}

	protected fun <T> androidx.lifecycle.LiveData<T>.observe(observer: androidx.lifecycle.Observer<T>) {
		observe(viewLifecycleOwner, observer)
	}
}