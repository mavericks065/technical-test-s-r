package au.com.nig.domain.port

import au.com.nig.domain.StarWarsCharacter

interface CharactersPort {
    fun findAllCharacters(): List<StarWarsCharacter>
    fun voteFor(characterId: Long): StarWarsCharacter
}
