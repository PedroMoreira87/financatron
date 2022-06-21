//package com.example.financatron.user
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
//class UserAdapter(private val clickListener:OnClickedListener) :
//    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
//    inner class ViewHolder(itemView:View) :
//        RecyclerView.ViewHolder(itemView){
//        var tvUserName: TextView
//        init {
//            tvUserName = itemView.findViewById(R.id.tvUserName)
//            itemView.setOnClickListener {
//                clickListener.onItemClicked(it,adapterPosition)
//            }
//            itemView.setOnLongClickListener {
//                clickListener.onItemLongClicked(it,adapterPosition)
//                true
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(
//                R.layout.item_user,
//                parent,false)
//        return ViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val user = DataModel.instance.users[position]
//        holder.tvUserName.text = user.name
//    }
//
//    override fun getItemCount(): Int {
//        return DataModel.instance.users.size
//    }
//
//}