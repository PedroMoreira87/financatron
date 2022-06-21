//package com.example.financatron.product
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.financatron.DataModel
//import com.example.financatron.OnClickedListener
//import com.example.financatron.R
//
//class ProductAdapter(private val clickListener:OnClickedListener) :
//    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
//    inner class ViewHolder(itemView:View) :
//        RecyclerView.ViewHolder(itemView) {
//            var tvProductName:TextView
//            var tvProductPrice:TextView
//            var tvProductDay:TextView
//            init {
//                tvProductName = itemView.findViewById(R.id.tvProductName)
//                tvProductPrice = itemView.findViewById(R.id.tvProductPrice)
//                tvProductDay = itemView.findViewById(R.id.tvProductDay)
//                itemView.setOnClickListener {
//                    clickListener.onItemClicked(it, adapterPosition)
//                }
//                itemView.setOnLongClickListener {
//                    clickListener.onItemLongClicked(it, adapterPosition)
//                    true
//                }
//            }
//        }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        var itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_product,
//                parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val product = DataModel.instance.products[position]
//        holder.tvProductName.text = product.name
//        holder.tvProductPrice.text = product.price.toString()
//        holder.tvProductDay.text = product.day
//    }
//
//    override fun getItemCount(): Int {
//        return DataModel.instance.products.size
//    }
//}