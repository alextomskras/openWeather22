package com.dreamer.openweather22

//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions
//import com.dreamer.myweather2.internal.glide.GlideApp

//import com.bumptech.glide.RequestBuilder
import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.dreamer.openweather22.Activity.MainActivityRepository
import com.dreamer.openweather22.Model.CountryModel
import dreamer.com.openweather22.R

//import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


class CountryRecyclerViewAdapter(_context: Context, _countryList: List<CountryModel>) : androidx.recyclerview.widget.RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder>() {
    //    val mainActivity = MainActivity
    lateinit var Activity: MainActivityRepository
    val context = _context
    val countryList = _countryList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_country_model_layout, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
//        notifyDataSetChanged()
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]

        holder.countryName.text = country.name
        holder.countryCapital.text = country.weather[1].description
        holder.countryPopulation.text = country.base.toString()
        holder.countryRegion.text = country.location.toString()
        holder.countrySubRegion.text = country.visibility.toString()
        val picturesUrl = "https://openweathermap.org/img/wn/01d@2x.png"
//        val picturesUrl = country.flag
        Log.e(CountryRecyclerViewAdapter::class.java.simpleName, picturesUrl.toString())
//        try {
//            Picasso.get()
////                        .load("$picturesUrl")
//                    .load("https://restcountries.eu/data/afg.svg")
//                    .fit()
//                    .into(holder.countryImage)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }


//            try {
////                var url = picturesUrl /* URL of Image */
//                var url = "https://s3.amazonaws.com/appsdeveloperblog/micky.gif" /* URL of Image */
//
//                if (url.startsWith("http://"))
//                    url = url.replace("http://", "https://")
//
//                val requestOptions = RequestOptions()
//
//                requestOptions.placeholder(R.drawable.ic_launcher_background)
//                requestOptions.error(R.drawable.ic_launcher_foreground)
//                GlideApp
//                        .with(context)
//                        .setDefaultRequestOptions(requestOptions)
//                        .asGif()
//
//                        .load(url)
//
//                        .into(holder.countryImage)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        var url = "https://upload.wikimedia.org/wikipedia/commons/d/d7/Android_robot.svg" /* URL of Image */
        try {
            var url = picturesUrl /* URL of Image */
            val requestBuilder: RequestBuilder<PictureDrawable> = GlideToVectorYou
                    .init()
                    .with(context)
                    .requestBuilder

            // Customize request like you were using Glide normally
            requestBuilder
                    .load((Uri.parse(url)))
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(holder.countryImage)
        } catch (e: Exception) {
            e.printStackTrace()
        }
//    }

//        var url = "https://upload.wikimedia.org/wikipedia/commons/d/d7/Android_robot.svg" /* URL of Image */
//        GlideToVectorYou.justLoadImage(Activity, Uri.parse(url), holder.countryImage)

//// setup Glide request without the into() method
//        val thumbnailRequest = GlideApp
//                .with(context)
//                .load(picturesUrl)
//
//// pass the request as a a parameter to the thumbnail request
//        GlideApp
//                .with(context)
//                .load(UsageExampleGifAndVideos.gifUrl)
//                .thumbnail(thumbnailRequest)
//                .into(imageView)


//        GlideToVectorYou.justLoadImage(Activity(), picturesUrl, holder.countryImage)
//        SvgLoader.pluck()
//                .with(mainActivity)
////                .with(this@CountryRecyclerViewAdapter)
//                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
//                .load(picturesUrl, holder.countryImage);


    }


    class CountryViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.country_name)
        val countryCapital: TextView = itemView.findViewById(R.id.country_capital)
        val countryPopulation: TextView = itemView.findViewById(R.id.country_population)
        val countryRegion: TextView = itemView.findViewById(R.id.country_region)
        val countrySubRegion: TextView = itemView.findViewById(R.id.country_subregion)
        val countryImage: ImageView = itemView.findViewById(R.id.country_image)
    }


}



