package com.testtask.kb2fty7.testprojectpsyh.view.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.testtask.kb2fty7.testprojectpsyh.R;
import com.testtask.kb2fty7.testprojectpsyh.model.Person;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Yurii on 2/3/2016.
 */
public class RecyclerPersonListAdapter extends RecyclerView.Adapter<RecyclerPersonListAdapter.PersonViewHolder> {
    private List<Person> mPersons;
    private Context mContext;
    private IPersonListAdapterListener mListener;

    public RecyclerPersonListAdapter(List<Person> persons, IPersonListAdapterListener listener, Context context) {
        mContext = context;
        mPersons = persons;
        mListener = listener;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_person_view, parent, false);
        PersonViewHolder personViewHolder = new PersonViewHolder(view);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, final int position) {
        Glide.with(holder.cardView.getContext()).load(mPersons.get(position).getPhoto()).into(holder.imageView);
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = mPersons.get(position).getId();
                removeItem(position);
                mListener.onClickLike(id);
            }
        });
        holder.dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = mPersons.get(position).getId();
                removeItem(position);
                mListener.onClickDislike(id);

            }
        });
        if (mPersons.get(position).getStatus().equals("like")){
            holder.iconImageView.setImageResource(R.drawable.heart);
        } else {
            holder.iconImageView.setImageBitmap(null);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    private void removeItem(int position) {
        mPersons.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mPersons.size());
    }

    public interface IPersonListAdapterListener {
        void onClickLike(long id);

        void onClickDislike(long id);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.personCardView)
        CardView cardView;
        @Bind(R.id.personImageView)
        ImageView imageView;
        @Bind(R.id.likeButton)
        Button likeButton;
        @Bind(R.id.dislikeButton)
        Button dislikeButton;
        @Bind(R.id.likeIconImageView)
        ImageView iconImageView;

        public PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}
