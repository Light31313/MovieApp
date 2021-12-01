package gam.trainingcourse.navigationdrawer.model

import com.google.gson.annotations.SerializedName
import kotlin.random.Random

data class Movie(
    @SerializedName("title")
    val name: String = "",
    var category: String = "",
    @SerializedName("vote_average")
    val score: String = "",
    var price: Float = 0f,
    @SerializedName("poster_path")
    val imageUrl: String = ""
) {
    private val categories = arrayOf(
        "Action",
        "Comedy",
        "Horror",
        "Adventure",
        "Animation",
        "Sci-Fi",
        "Fantasy",
        "Detective"
    )

    init {
        price = Random.nextFloat() * 10
        category = categories[Random.nextInt(categories.size)]
    }
}