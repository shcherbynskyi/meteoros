package appometric.meteoros.di.module

import appometric.meteoros.repository.RoomRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomRepository() = RoomRepository()

}