package com.hanabi.thithu.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hanabi.thithu.models.Message;
import com.hanabi.thithu.R;


import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.HolderMessage> {

    private LayoutInflater layoutInflater;
    private ArrayList<Message> data;
    private OnClickMessageListener listener;

    public MessageAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    public void setListener(OnClickMessageListener listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<Message> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderMessage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_message, parent, false);
        return new HolderMessage(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMessage holder, int position) {
        final Message message = data.get(position);
        holder.bindView(message);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickMessage(message);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onClickLongMessage(message);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    public class HolderMessage extends RecyclerView.ViewHolder {

        public HolderMessage(@NonNull View itemView) {
            super(itemView);

        }

        private void bindView(Message message) {

        }
    }

    public interface OnClickMessageListener {
        void onClickMessage(Message message);

        void onClickLongMessage(Message message);
    }

}
