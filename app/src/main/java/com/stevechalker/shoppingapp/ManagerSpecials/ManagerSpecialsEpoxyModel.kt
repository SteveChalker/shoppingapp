package com.stevechalker.shoppingapp.ManagerSpecials

import android.graphics.Paint
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.stevechalker.shoppingapp.ManagerSpecials.ManagerSpecialsEpoxyModel.Holder
import com.stevechalker.shoppingapp.R
import com.stevechalker.shoppingapp.data.model.ManagerSpecial
import com.stevechalker.shoppingapp.epoxy.KotlinEpoxyHolder
import com.stevechalker.shoppingapp.extensions.formatCurrency

@EpoxyModelClass(layout = R.layout.item_manager_special)
abstract class ManagerSpecialsEpoxyModel : EpoxyModelWithHolder<Holder>() {

    @EpoxyAttribute
    lateinit var managerSpecial: ManagerSpecial

    override fun bind(holder: Holder) {
        holder.itemNameView.text = managerSpecial.display_name
        holder.discountedPriceView.text = managerSpecial.price.formatCurrency()
        holder.originalPriceView.apply {
            text = managerSpecial.original_price.formatCurrency()
            paintFlags = (paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
        }

        holder.glide.load(managerSpecial.imageUrl)
            .into(holder.itemImageView)
    }

    class Holder : KotlinEpoxyHolder() {
        val itemNameView: TextView by bind(R.id.item_name_textView)
        val itemImageView: ImageView by bind(R.id.item_imageView)
        val originalPriceView: TextView by bind(R.id.original_price_textView)
        val discountedPriceView: TextView by bind(R.id.discounted_price_textView)
        val glide by lazy { Glide.with(itemImageView.context) }
    }
}