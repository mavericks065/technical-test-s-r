package au.com.nig.domain

data class StarWarsCharacter(
    val id: Long,
    val votes: Long,
    val name: String,
    val homeworld: String = ""
)

