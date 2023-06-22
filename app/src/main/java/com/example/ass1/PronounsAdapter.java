package com.example.ass1;

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

    private final RecycleViewInterface recycleViewInterface;


    private String[] captions;
    private int[] imageIds;
    private Pronouns [] pro;

    public PronounsAdapter(String[] captions, int[] imageIds,RecycleViewInterface recycleViewInterface){
        this.captions = captions;
        this.imageIds = imageIds;
        this.recycleViewInterface=recycleViewInterface;
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

                }
            });
        }
    }

}
