package com.example.finalpokus.userinterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalpokus.R
import com.example.finalpokus.model.User

class UserAdapter(
    private val userList: List<User>,
    private val onItemClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = userList.size

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val userNameTextView: TextView = view.findViewById(R.id.userName)

        init {
            itemView.setOnClickListener {
                onItemClick(userList[adapterPosition])
            }
        }

        fun bind(user: User) {
            userNameTextView.text = user.name
        }
    }
}
