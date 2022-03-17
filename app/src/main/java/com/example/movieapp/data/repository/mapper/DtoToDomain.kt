package com.example.movieapp.data.repository.mapper

import com.example.movieapp.data.data.network.models.CastDto
import com.example.movieapp.domain.models.Actor

internal fun CastDto.toDomain(): Actor {
    return Actor(
        asCharacter = this.asCharacter,
        id = this.id,
        image = this.image,
        name = this.name
    )
}