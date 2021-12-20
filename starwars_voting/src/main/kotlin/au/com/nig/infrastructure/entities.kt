package au.com.nig.infrastructure


data class Character(
    val id: Long,
    val name: String,
    val homeworld: String = "",
    val imageUrl: String
) {
    constructor(fields: Map<String, String>) : this(
        id = fields["id"]!!.toLong(),
        name = fields["name"]!!,
        homeworld = fields["homeworld"] ?: "",
        imageUrl = fields["pic"]!!
    )
}

data class Score(
    val score: Long
)
