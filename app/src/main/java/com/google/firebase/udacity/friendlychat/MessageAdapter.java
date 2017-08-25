package com.google.firebase.udacity.friendlychat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<FriendlyMessage> mData;

    public MessageAdapter(List<FriendlyMessage> mData) {
        this.mData = mData;
    }

    public List<FriendlyMessage> getmData() {
        return mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FriendlyMessage friendlyMessage = mData.get(position);
        boolean isPhoto = friendlyMessage.getPhotoUrl() != null;
        if (isPhoto) {
            holder.messageTextView.setVisibility(View.GONE);
            holder.photoImageView.setVisibility(View.VISIBLE);
            Glide.with(holder.photoImageView.getContext())
                    .load(friendlyMessage.getPhotoUrl())
                    .into(holder.photoImageView);//Glid is used to load the image
        } else {
            holder.messageTextView.setVisibility(View.VISIBLE);
            holder.photoImageView.setVisibility(View.GONE);
            holder.messageTextView.setText(friendlyMessage.getText());
        }
        holder.authorTextView.setText(friendlyMessage.getName());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView photoImageView;
        TextView messageTextView;
        TextView authorTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            photoImageView = (ImageView) itemView.findViewById(R.id.photoImageView);
            messageTextView = (TextView) itemView.findViewById(R.id.messageTextView);
            authorTextView = (TextView) itemView.findViewById(R.id.nameTextView);
        }
    }


//    public MessageAdapter(Context context, int resource, List<FriendlyMessage> objects) {
//        super(context, resource, objects);
//    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
//        }
//
//        ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
//        TextView messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
//        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);
//
//        FriendlyMessage message = getItem(position);
//
//        boolean isPhoto = message.getPhotoUrl() != null;
//        if (isPhoto) {
//            messageTextView.setVisibility(View.GONE);
//            photoImageView.setVisibility(View.VISIBLE);
//            Glide.with(photoImageView.getContext())
//                    .load(message.getPhotoUrl())
//                    .into(photoImageView);//Glid is used to load the image
//        } else {
//            messageTextView.setVisibility(View.VISIBLE);
//            photoImageView.setVisibility(View.GONE);
//            messageTextView.setText(message.getText());
//        }
//        authorTextView.setText(message.getName());
//
//        return convertView;
//    }
}
