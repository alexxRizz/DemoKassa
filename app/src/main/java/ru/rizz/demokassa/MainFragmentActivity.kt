package ru.rizz.demokassa

import android.os.*
import androidx.appcompat.app.*
import androidx.lifecycle.*
import dagger.hilt.android.*
import kotlinx.coroutines.*
import ru.rizz.demokassa.navigation.*
import javax.inject.*

@AndroidEntryPoint
class MainFragmentActivity : AppCompatActivity() {

	private lateinit var mStartFragmentSelector: IStartFragmentSelector

	@Inject
	fun init(startFragmentSelector: IStartFragmentSelector) {
		mStartFragmentSelector = startFragmentSelector
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
		if (supportFragmentManager.backStackEntryCount > 1)
			super.onBackPressed()
		// Намеренно не выходим из приложения при нажатии на back,
		// т.к. это стандартная практика для kiosk-mode приложений.
	}
}