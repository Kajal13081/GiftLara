package com.example.giftlara;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GiftAdapter extends RecyclerView.Adapter<GiftAdapter.ViewHolder> {

    private List<ModelClass> userList;

    public GiftAdapter(List<ModelClass> userList) {

        this.userList = userList;
    }

    public void setFilteredList(List<ModelClass> filteredList) {

        this.userList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GiftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gifts_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiftAdapter.ViewHolder holder, int position) {

        int resource = userList.get(position).getGiftImage();
        String name=userList.get(position).getGiftName();
        int price=userList.get(position).getGiftPrice();
        int rating=userList.get(position).getGiftRating();

        holder.setData(resource,name,price,rating);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    //view holder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textview3;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //here use xml ids
            //give different name not like constructor
            imageView=itemView.findViewById(R.id.giftImageView);
            textView=itemView.findViewById(R.id.giftName);
            textView2=itemView.findViewById(R.id.price);
            textview3=itemView.findViewById(R.id.rating);
        }

        public void setData(int resource, String name, int price, int rating) {

            imageView.setImageResource(resource);
            textView.setText(name);
            textView2.setText(price);
            textview3.setText(rating);

        }
    }
}
