package gam.trainingcourse.navigationdrawer.adapter.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String) {
    if (url.isNotEmpty())
        Glide.with(this).load(url).into(this)
}