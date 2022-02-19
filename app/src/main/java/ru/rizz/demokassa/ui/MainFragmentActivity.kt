package ru.rizz.demokassa.ui

import android.os.*
import androidx.appcompat.app.*
import androidx.lifecycle.*
import dagger.hilt.android.*
import kotlinx.coroutines.*
import ru.rizz.demokassa.R
import ru.rizz.demokassa.ui.navigation.*
import javax.inject.*

@AndroidEntryPoint
class MainFragmentActivity : AppCompatActivity() {

	private lateinit var mStartFragmentSelector: IStartFragmentSelector
	private lateinit var mScreens: Screens

	@Inject
	fun init(startFragmentSelector: IStartFragmentSelector, screens: Screens) {
		mStartFragmentSelector = startFragmentSelector
		mScreens = screens
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		if (savedInstanceState == null) {
			lifecycleScope.launch {
				mStartFragmentSelector()
			}
		}
	}

	override fun onBackPressed() {
		mScreens.back()
	}
}