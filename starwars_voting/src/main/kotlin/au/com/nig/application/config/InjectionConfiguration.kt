package au.com.nig.application.config

import au.com.nig.domain.adapter.CharactersAdapter
import au.com.nig.domain.port.StoragePort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InjectionConfiguration {

    @Bean
    fun getCharactersAdapter(storagePort: StoragePort): CharactersAdapter {
        return CharactersAdapter(storagePort)
    }
}
