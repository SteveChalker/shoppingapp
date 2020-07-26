package com.stevechalker.shoppingapp.manager_specials

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.flexbox.FlexboxLayoutManager
import com.stevechalker.shoppingapp.R
import com.stevechalker.shoppingapp.data.model.ManagerSpecial
import com.stevechalker.shoppingapp.extensions.formatCurrency

class ManagerSpecialsAdapter constructor(
    private val managerSpecials: List<ManagerSpecial>
) : RecyclerView.Adapter<ManagerSpecialsAdapter.ManagerSpecialViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManagerSpecialViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_manager_special, parent, false)
        return ManagerSpecialViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ManagerSpecialViewHolder, position: Int) {
        holder.itemNameView.text = managerSpecials[position].display_name
        holder.discountedPriceView.text = managerSpecials[position].price.formatCurrency()
        holder.originalPriceView.apply {
            text = managerSpecials[position].original_price.formatCurrency()
            paintFlags = (paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
        }

        Glide.with(holder.itemImageView.context)
            .load(managerSpecials[position].imageUrl)
            .into(holder.itemImageView)

        holder.managerSpecialContainer.layoutParams =
            FlexboxLayoutManager.LayoutParams(
                managerSpecials[position].width,
                managerSpecials[position].height
            )
    }

    override fun getItemCount() = managerSpecials.count()

    class ManagerSpecialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val managerSpecialContainer: CardView =
            itemView.findViewById(R.id.manager_special_container)
        val itemNameView: TextView = itemView.findViewById(R.id.item_name_textView)
        val itemImageView: ImageView = itemView.findViewById(R.id.item_imageView)
        val originalPriceView: TextView = itemView.findViewById(R.id.original_price_textView)
        val discountedPriceView: TextView = itemView.findViewById(R.id.discounted_price_textView)
    }

}