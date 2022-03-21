package com.alexy.movieapp.data.repository.mapper

import com.alexy.movieapp.data.network.models.CastDto
import com.alexy.movieapp.domain.models.Actor

internal fun CastDto.toDomain(): Actor {
    return Actor(
        asCharacter = this.asCharacter,
        id = this.id,
        image = this.image,
        name = this.name
    )
}