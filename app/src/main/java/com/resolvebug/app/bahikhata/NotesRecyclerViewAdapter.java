package com.resolvebug.app.bahikhata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class NotesRecyclerViewAdapter extends RecyclerView.Adapter<NotesRecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private List<CardItems> cardItemsList;
    private OnItemClickListener mListener;
    private LinearLayout notesCardLayout;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public NotesRecyclerViewAdapter(Context context, List<CardItems> cardItemsList) {
        this.context = context;
        this.cardItemsList = cardItemsList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.notes_cardview_layout, null);
        return new RecyclerViewHolder(view, mListener);
    }

    // "final" is added just because of image view. in case it creates any problem in future, remove image view and remove "final"
    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        CardItems cardItems = cardItemsList.get(position);
        holder.itemAmount.setText(String.valueOf(cardItems.getAmount()));
        holder.itemMessage.setText(cardItems.getMessage());
        holder.important.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                holder.important.setImageResource(R.drawable.ic_baseline_favorite_24px);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItemsList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView itemAmount, itemMessage;
        ImageView important;

        public RecyclerViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            itemAmount = itemView.findViewById(R.id.item_amount);
            itemMessage = itemView.findViewById(R.id.item_message);
            important = itemView.findViewById(R.id.important);
            notesCardLayout = itemView.findViewById(R.id.notes_linear_layout);
            notesCardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
