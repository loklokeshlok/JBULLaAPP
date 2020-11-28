package com.mahammadjabi.jbulla.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;
import com.mahammadjabi.jbulla.Models.PostsModel;
import com.mahammadjabi.jbulla.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterPosts extends RecyclerView.Adapter {

    List<PostsModel> postsList;

    public static ProgressBar progressBar;
    Context context;

    public AdapterPosts(List<PostsModel> postsList) {
        this.postsList = postsList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

//        progressBar.setVisibility(View.VISIBLE);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_posts_layout,parent,false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        ViewHolderClass viewHolderClass = (ViewHolderClass)holder;

            PostsModel posts = postsList.get(position);

            viewHolderClass.date1.setText(posts.getDate());
            viewHolderClass.time1.setText(posts.getTime());
            viewHolderClass.postdescription1.setText(posts.getDescription());
            viewHolderClass.UserUserName.setText(posts.getUsername());
            Picasso.with(viewHolderClass.itemView.getContext())
                    .load(posts.getProfileimage())
                    .into(viewHolderClass.UserProfileImage);
            Picasso.with(viewHolderClass.itemView.getContext())
                   .load(posts.getPostimage())
                   .into(viewHolderClass.UserPostImage);

    }


    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder
    {

        TextView date1;
        TextView UserUserName;
        TextView time1;
        TextView postdescription1;
        ImageView UserPostImage;
        CircleImageView UserProfileImage;

        public ViewHolderClass(@NonNull View itemView) {


            super(itemView);


             date1 = (TextView)itemView.findViewById(R.id.post_date);
             UserPostImage = (ImageView)itemView.findViewById(R.id.post_image);
             UserProfileImage = (CircleImageView)itemView.findViewById(R.id.post_profile_image);
             UserUserName = (TextView)itemView.findViewById(R.id.post_user_name);
             time1 = (TextView)itemView.findViewById(R.id.post_time);
             postdescription1 =  (TextView)itemView.findViewById(R.id.post_description);
             progressBar = itemView.findViewById(R.id.progressbarhome);

        }
    }
}
