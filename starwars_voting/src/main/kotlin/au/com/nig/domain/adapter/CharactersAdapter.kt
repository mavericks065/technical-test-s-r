package au.com.nig.domain.adapter

import au.com.nig.domain.StarWarsCharacter
import au.com.nig.domain.port.CharactersPort
import au.com.nig.domain.port.StoragePort

class CharactersAdapter(
    private val storagePort: StoragePort
): CharactersPort {
    override fun findAllCharacters(): List<StarWarsCharacter> {
        return storagePort.findSortedCharacters()
    }

    override fun voteFor(characterId: Long): StarWarsCharacter {
        return storagePort.updateScoreOfCharacter(characterId)
    }
}
