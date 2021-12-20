package au.com.nig.application.config

import io.lettuce.core.RedisClient
import io.lettuce.core.RedisURI
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.sync.RedisCommands
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import javax.annotation.PreDestroy

@Configuration
class RedisConfig {
    @Value("\${spring.redis.host}")
    private val redisHostName: String = "localhost"

    @Value("\${spring.redis.port}")
    private val redisPort = 6379

    @Value("\${spring.redis.database}")
    private val redisDatabase = 0

    private lateinit var redisConnection: StatefulRedisConnection<String, String>
    private lateinit var redisClient: RedisClient

    @Lazy
    @Bean
    fun connectionFactory(): RedisCommands<*, *> {
        val redisURI = RedisURI.Builder.redis(redisHostName, redisPort).withDatabase(redisDatabase).build();
        redisClient = RedisClient.create(redisURI)
        redisConnection = redisClient.connect()
        return redisConnection.sync()
    }

    @PreDestroy
    fun redisConnection(): StatefulRedisConnection<String, String> {
        redisConnection.close()
        return redisConnection
    }
}
