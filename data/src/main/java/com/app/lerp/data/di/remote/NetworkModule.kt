package com.app.lerp.data.di.remote

import com.app.lerp.data.remote.comments.CommentsApi
import com.app.lerp.data.remote.comments.CommentsRemote
import com.app.lerp.data.remote.post.PostApi
import com.app.lerp.data.remote.post.PostRemote
import com.app.lerp.usecase.repository.comments.RemoteCommentsRepository
import com.app.lerp.usecase.repository.post.RemotePostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providePostApi(@Named("baseUrl") retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    @Provides
    fun providePostApiNetwork(api: PostApi): RemotePostRepository {
        return PostRemote(api)
    }

    @Provides
    fun provideCommentsApi(@Named("baseUrl") retrofit: Retrofit): CommentsApi {
        return retrofit.create(CommentsApi::class.java)
    }

    @Provides
    fun provideCommentsApiNetwork(api: CommentsApi): RemoteCommentsRepository {
        return CommentsRemote(api)
    }
}