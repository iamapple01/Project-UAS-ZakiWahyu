package com.example.projectuas.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.projectuas.Models.SliderItems
import com.example.projectuas.databinding.ViewholderSliderBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions


class SliderAdapter(
    private var sliderItems:MutableList<SliderItems>,private val viewPager2: ViewPager2
):RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    private var context: Context? = null
    private val runnable = Runnable {
        sliderItems.addAll(sliderItems)
        notifyDataSetChanged()
    }
    inner class SliderViewHolder(private val binding:ViewholderSliderBinding):
        RecyclerView.ViewHolder(binding.root) {

            fun bind(sliderItem: SliderItems){
                context?.let{
                    Glide.with(it)
                        .load(sliderItem.image)
                        .apply{ RequestOptions().transform(CenterCrop(), RoundedCorners(60))}
                        .into(binding.imageSlide)
                }
            }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderAdapter.SliderViewHolder {
        context=parent.context
        val binding=ViewholderSliderBinding.inflate(LayoutInflater.from(context),parent,false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderAdapter.SliderViewHolder, position: Int) {
        holder.bind(sliderItems[position])
        if (position == sliderItems.size - 2){
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int =sliderItems.size


}