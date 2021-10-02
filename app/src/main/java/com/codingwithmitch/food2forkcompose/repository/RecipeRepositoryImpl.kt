package com.codingwithmitch.food2forkcompose.repository

import com.codingwithmitch.food2forkcompose.network.RecipeService
import com.codingwithmitch.food2forkcompose.domain.model.Recipe
import com.codingwithmitch.food2forkcompose.network.model.RecipeDtoMapper


class RecipeRepositoryImpl (
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper,
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token = token, id))
    }

}