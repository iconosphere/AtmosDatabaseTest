package com.example.atmosdatabasetest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.atmosdatabasetest.R;
import com.example.atmosdatabasetest.data.Blend;

import java.util.List;

public class BlendAdapter extends RecyclerView.Adapter<BlendAdapter.ViewHolder> {

    // Member variables.
    private List<Blend> mBlendList; // Cached copy of Blends.
    private Context mContext;

    public BlendAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BlendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Get current Blend.
        Blend currentBlend = mBlendList.get(position);

        // Populate the TextViews with data.
        holder.mNameText.setText(currentBlend.getName());
        holder.mRecipeText.setText(currentBlend.getRecipe());
        holder.mDescriptionText.setText(currentBlend.getFurtherInfo());
        holder.mDidYouKnowText.setText(currentBlend.getDidYouKnow());

    }

    public void setBlends(List<Blend> blends) {
        mBlendList = blends;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mBlendList != null)
            return mBlendList.size();
        else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        // Member variables for the TextViews.
        private TextView mNameText;
        private TextView mRecipeText;
        private TextView mDescriptionText;
        private TextView mDidYouKnowText;

        ViewHolder(View itemView) {
            super(itemView);

            // Initialise the views.
            mNameText = itemView.findViewById(R.id.name);
            mRecipeText = itemView.findViewById(R.id.recipe);
            mDescriptionText = itemView.findViewById(R.id.furtherinfo);
            mDidYouKnowText = itemView.findViewById(R.id.didYouKnow);
        }
    }
}
