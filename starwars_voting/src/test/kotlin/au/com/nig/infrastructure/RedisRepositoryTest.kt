package au.com.nig.infrastructure

import au.com.nig.domain.port.StoragePort
import au.com.nig.infrastructure.RedisRepository.Companion.CHARACTERS_KEY
import io.lettuce.core.RedisClient
import io.lettuce.core.api.sync.RedisCommands
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.test.context.junit.jupiter.SpringExtension
import redis.embedded.RedisServer

@TestConfiguration
internal class RedisTestConfiguration {
    @Bean
    fun reactiveRedisConnectionFactory(): ReactiveRedisConnectionFactory? {
        return LettuceConnectionFactory("localhost", 6370)
    }
}

@Import(RedisTestConfiguration::class)
@ExtendWith(SpringExtension::class)
internal class RedisRepositoryTest{
    private lateinit var redisServer: RedisServer

    private lateinit var redisCommands: RedisCommands<String, String>

    @Autowired
    private lateinit var lettuceConnectionFactory: LettuceConnectionFactory

    private lateinit var redisRepository: StoragePort

    @BeforeEach
    fun beforeEach() {
        try {
            println("------------------ TEST --------------------")
            redisServer = RedisServer.builder().port(6370).setting("bind 127.0.0.1").build();
            redisServer.start()
            redisCommands = (lettuceConnectionFactory.nativeClient as RedisClient).connect().sync()
            redisRepository = RedisRepository(redisCommands)
            redisCommands.hset("$CHARACTERS_KEY:1", mutableMapOf(Pair("id", "1"), Pair("name", "Luke Skywalker"), Pair("pic", "https://vignette.wikia.nocookie.net/starwars/images/2/20/LukeTLJ.jpg"), Pair("homeworld", "tatooine")))
            redisCommands.hset("$CHARACTERS_KEY:2", mutableMapOf(Pair("id", "2"), Pair("name", "C-3PO"), Pair("pic", "https://vignette.wikia.nocookie.net/starwars/images/3/3f/C-3PO_TLJ_Card_Trader_Award_Card.png") , Pair("homeworld" ,"tatooine")))
            redisCommands.hset("$CHARACTERS_KEY:3", mutableMapOf(Pair("id", "3"), Pair("name", "R2-D2"), Pair("pic", "https://vignette.wikia.nocookie.net/starwars/images/e/eb/ArtooTFA2-Fathead.png") , Pair("homeworld" ,"naboo")))
            redisCommands.zadd(CHARACTERS_KEY, 5.toDouble(), "1")
            redisCommands.zadd(CHARACTERS_KEY, 3.toDouble(), "2")
            redisCommands.zadd(CHARACTERS_KEY, 0.toDouble(), "3")
            println("------------------ TEST --------------------")


        } catch (e: Exception) {
            println(e)
        }
    }

    @AfterEach
    fun afterEach() {
        redisServer.stop()
    }

    @Test
    fun `findSortedCharacters should return the characters ordered in descending order`() {
        // When
        val result = redisRepository.findSortedCharacters()

        // Then
        assertEquals(3, result.size)
        assertEquals(5, result[0].votes)
        assertEquals(3, result[1].votes)
        assertEquals(0, result[2].votes)
    }

    @Test
    fun `updateScoreOfCharacter should return the character with its vote score incremented`() {
        // When
        val result = redisRepository.updateScoreOfCharacter(1)

        // Then
        assertEquals(6, result.votes)
    }
}
