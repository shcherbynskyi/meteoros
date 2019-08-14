package appometric.meteoros.di.module

import android.app.Application
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    internal fun providesApplication(): Application = app

}