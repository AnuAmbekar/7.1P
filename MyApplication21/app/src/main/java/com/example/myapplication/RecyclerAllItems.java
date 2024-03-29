package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAllItems extends RecyclerView.Adapter<RecyclerAllItems.ViewHolder> implements ClickListener {
    Context context;
    List<String> status, description;

    private final ClickListener clickListener;

    public RecyclerAllItems(Context context, List<String> status, List<String> description, ClickListener clickListener) {
        this.context = context;
        this.status = status;
        this.description = description;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerAllItems.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.all_items, parent, false);
        return new ViewHolder(itemView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAllItems.ViewHolder holder, int position) {
        holder.textView.setText(String.valueOf(status.get(position)));
        holder.textView2.setText(String.valueOf(description.get(position)));
    }

    @Override
    public int getItemCount() {
        return status.size();
    }

    @Override
    public void onItemClick(int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView, textView2;
        CardView cardView;
        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            cardView = itemView.findViewById(R.id.cardView);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (clickListener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            clickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
