package au.com.nig.application

import au.com.nig.domain.StarWarsCharacter
import au.com.nig.domain.port.CharactersPort
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/characters"])
@Api(value = "characters", tags = ["API pertaining the characters available on our application"])
class CharactersController(
    private val charactersAdapter: CharactersPort
) {
    companion object {
        private val log = LoggerFactory.getLogger(CharactersController::class.java)
    }

    @ApiOperation(value = "Up Vote a star wars character")
    @PatchMapping(value = ["/{id}/scores"])
    fun upVote(
        @PathVariable id: Long
    ): StarWarsCharacter {
        log.info("Vote for characters $id")
        return charactersAdapter.voteFor(id)
    }

    @ApiOperation(value = "Get Characters")
    @GetMapping(value = [""])
    fun getCharacters(): List<StarWarsCharacter> {
        log.info("Fetch characters")
        return charactersAdapter.findAllCharacters()
    }
}
