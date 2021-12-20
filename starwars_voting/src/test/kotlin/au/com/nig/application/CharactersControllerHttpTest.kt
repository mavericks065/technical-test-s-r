package au.com.nig.application

import au.com.nig.domain.StarWarsCharacter
import au.com.nig.domain.port.CharactersPort
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(CharactersController::class)
@ActiveProfiles("test")
internal class CharactersControllerHttpTest(
    @Autowired val mockMvc: MockMvc,
) {
    @MockBean
    lateinit var charactersAdapter: CharactersPort

    @Test
    fun `should fetch all characters`() {
        // Given
        `when`(charactersAdapter.findAllCharacters())
            .thenReturn(listOf(StarWarsCharacter(1L, 3L, "Luke Nicolas","Tarbes")))

        // When / Then
        mockMvc.perform(MockMvcRequestBuilders.get("/characters")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("utf-8"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("\$[0].id").value(1L))
            .andExpect(MockMvcResultMatchers.jsonPath("\$[0].votes").value(3L))
            .andExpect(MockMvcResultMatchers.jsonPath("\$[0].name").value("Luke Nicolas"))
            .andExpect(MockMvcResultMatchers.jsonPath("\$[0].homeworld").value("Tarbes"))

    }

    @Test
    fun `should increment the votes of a character`() {
        // Given
        `when`(charactersAdapter.voteFor(1L))
            .thenReturn(StarWarsCharacter(1L, 3L, "Luke Nicolas","Tarbes"))

        // When / Then
        mockMvc.perform(MockMvcRequestBuilders.patch("/characters/1/scores")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("utf-8"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("\$.id").value(1L))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.votes").value(3L))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.name").value("Luke Nicolas"))
            .andExpect(MockMvcResultMatchers.jsonPath("\$.homeworld").value("Tarbes"))
    }
}
