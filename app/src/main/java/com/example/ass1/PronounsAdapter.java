package com.example.ass1;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PronounsAdapter extends RecyclerView.Adapter<PronounsAdapter.ViewHolder>{

    private RecycleViewInterface recycleViewInterface;


    private String[] captions;
    private int[] imageIds;
    private Pronouns [] pro;

    private Context context;


    public PronounsAdapter(RecycleViewInterface recycleViewInterface, String[] captions, int[] imageIds,Context context) {
        this.recycleViewInterface = recycleViewInterface;
        this.captions = captions;
        this.imageIds = imageIds;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pronouns_img_name, parent, false);

        return new ViewHolder(v,recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(dr);

        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(captions[position]);

        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
                // Start the second activity
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView,RecycleViewInterface recycleViewInterface){
            super(cardView);
            this.cardView = cardView;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recycleViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recycleViewInterface.onItemClick(pos);
                        }
                    }
                   // recycleViewInterface.onItemClick(getAdapterPosition());

                }
            });
        }
    }

}
