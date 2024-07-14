package com.example.routetask.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import com.example.androidtask.api.models.Product
import com.example.androidtask.databinding.ProductLayoutBinding

class ProductAdapter():
    Adapter<ProductAdapter.ViewHolder>(){

    private val items : ArrayList<Product> = ArrayList()
    class ViewHolder(val binding: ProductLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ProductLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val item = items[position]
            img.load(item.images[0])
            title.text = item.title
            price.text = "${item.price.toString()} EGP"
            description.text = item.description
            discountPrice.text = "EGP ${item.discountPercentage.toString()}"
            review.text = "Review (${item.reviews[0].rating.toString()}) "
        }
    }
    fun setData(newList: List<Product>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}