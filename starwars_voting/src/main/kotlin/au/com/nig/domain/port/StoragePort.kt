package au.com.nig.domain.port

import au.com.nig.domain.StarWarsCharacter

interface StoragePort {

    fun findSortedCharacters(): List<StarWarsCharacter>
    fun updateScoreOfCharacter(characterId: Long): StarWarsCharacter
}
