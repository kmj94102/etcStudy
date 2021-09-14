package com.example.etcstudy.design_test.all_account

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.etcstudy.databinding.CellWalletBinding

class WalletAdapter : ListAdapter<WalletItem, WalletAdapter.WalletViewHolder>(diffUtil) {

    inner class WalletViewHolder(val binding : CellWalletBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : WalletItem){
            binding.txtCardTitle.text = item.title
            binding.cardWallet.setCardBackgroundColor(ContextCompat.getColor(binding.cardWallet.context, item.cardColorRes))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletViewHolder =
        WalletViewHolder(CellWalletBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: WalletViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<WalletItem>(){
            override fun areItemsTheSame(oldItem: WalletItem, newItem: WalletItem): Boolean = true

            override fun areContentsTheSame(oldItem: WalletItem, newItem: WalletItem): Boolean = true
        }
    }

}