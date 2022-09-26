package cn.pivotstudio.modulec.homescreen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.pivotstudio.husthole.moduleb.network.model.Replied
import cn.pivotstudio.modulec.homescreen.databinding.ItemNoticeBinding
import cn.pivotstudio.modulec.homescreen.databinding.ItemNoticeHeaderBinding
import cn.pivotstudio.modulec.homescreen.ui.fragment.NoticeFragment

class NoticeAdapter(private val context: NoticeFragment) :
    ListAdapter<Replied, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        const val TYPE_NOTICE_HEADER = 0
        const val TYPE_NOTICE_CONTENT = 1
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Replied> =
            object : DiffUtil.ItemCallback<Replied>() {
                override fun areItemsTheSame(
                    oldItem: Replied, newItem: Replied
                ): Boolean {
                    return oldItem.replyId == newItem.replyId
                }

                override fun areContentsTheSame(
                    oldItem: Replied, newItem: Replied
                ): Boolean {
                    return false
                }
            }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_NOTICE_HEADER
            else -> TYPE_NOTICE_CONTENT
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount().plus(1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_NOTICE_HEADER -> HeaderViewHolder(
                ItemNoticeHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> ContentViewHolder(
                ItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ContentViewHolder -> {
                if (position > 0) {
                    holder.bind(getItem(position - 1))
                }
            }
        }
    }

    //内容 ViewHolder
    inner class ContentViewHolder(private val binding: ItemNoticeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(reply: Replied) {
            binding.reply = reply
            binding.layoutReply.setOnClickListener { context.navToSpecificHole(reply.holeId.toInt()) }
        }
    }

    inner class HeaderViewHolder(private val binding: ItemNoticeHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}