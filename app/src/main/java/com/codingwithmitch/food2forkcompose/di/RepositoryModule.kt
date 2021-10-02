package com.codingwithmitch.food2forkcompose.di

import com.codingwithmitch.food2forkcompose.network.RecipeService
import com.codingwithmitch.food2forkcompose.network.model.RecipeDtoMapper
import com.codingwithmitch.food2forkcompose.repository.RecipeRepository
import com.codingwithmitch.food2forkcompose.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeMapper: RecipeDtoMapper,
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService = recipeService,
            mapper = recipeMapper
        )
    }
}

