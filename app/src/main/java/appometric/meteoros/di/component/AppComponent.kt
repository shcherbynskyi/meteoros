package appometric.meteoros.di.component

import appometric.meteoros.ui.home.HomeActivity
import appometric.meteoros.di.module.AppModule
import appometric.meteoros.di.module.RetrofitModule
import appometric.meteoros.di.module.RoomModule
import appometric.meteoros.viewmodel.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RoomModule::class, RetrofitModule::class])
interface AppComponent {

    // Activities
    fun inject(activity: HomeActivity)

    // ViewModels
    fun inject(viewModel: HomeViewModel)

}