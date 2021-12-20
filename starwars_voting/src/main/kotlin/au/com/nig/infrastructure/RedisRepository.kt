package au.com.nig.infrastructure

import au.com.nig.domain.StarWarsCharacter
import au.com.nig.domain.port.StoragePort
import io.lettuce.core.api.sync.RedisCommands
import org.springframework.stereotype.Service

@Service
class RedisRepository(
    private val redisCommands: RedisCommands<String, String>
): StoragePort {
    companion object {
        const val CHARACTERS_KEY = "characters:starwars"

        fun transformToStarWarsCharacter(character: Character, score: Score): StarWarsCharacter = StarWarsCharacter(
            id = character.id,
            votes = score.score,
            name = character.name,
            homeworld = character.homeworld
        )
    }
    override fun findSortedCharacters(): List<StarWarsCharacter> {
        val sortedCharacters = redisCommands.zrevrangeWithScores(CHARACTERS_KEY, 0, -1)
            .map {  scoredValue ->
                val map = redisCommands.hgetall("$CHARACTERS_KEY:${scoredValue.value}")
                val character = Character(map)
                transformToStarWarsCharacter(character, Score(scoredValue.score.toLong()))
            }
        return sortedCharacters
    }

    override fun updateScoreOfCharacter(characterId: Long): StarWarsCharacter {
        val score = incrementScore(characterId)
        val character =  findCharacter(characterId)
        return transformToStarWarsCharacter(character, Score(score))
    }

    private fun incrementScore(characterId: Long): Long {
        return redisCommands.zincrby(CHARACTERS_KEY, 1.toDouble(), characterId.toString()).toLong()
    }

    private fun findCharacter(characterId: Long): Character {
        return Character(redisCommands.hgetall("$CHARACTERS_KEY:$characterId"))
    }
}
