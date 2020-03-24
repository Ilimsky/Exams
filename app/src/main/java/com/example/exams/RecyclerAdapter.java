package com.example.exams;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyImageViewHolder> {

    private String[] answers;
    private Context context;

    public RecyclerAdapter(String[] answers, Context context) {
        this.answers = answers;
        this.context = context;
    }

    @NonNull
    @Override
    public MyImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout, viewGroup, false);
        MyImageViewHolder imageViewHolder = new MyImageViewHolder(view, context, answers);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyImageViewHolder viewHolder, int i) {
        try {
            viewHolder.textView.setText(answers[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return answers.length;
    }

    public static class MyImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        Context context;
        String[] answers;

        public MyImageViewHolder(@NonNull View itemView, Context context, String[] answers) {
            super(itemView);
            textView = itemView.findViewById(R.id.answer_title);
            this.context = context;
            this.answers = answers;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DisplayActivity.class);
            intent.putExtra("text_id", answers[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
