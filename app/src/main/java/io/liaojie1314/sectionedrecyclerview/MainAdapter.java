package io.liaojie1314.sectionedrecyclerview;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class MainAdapter extends SectionedRecyclerViewAdapter<MainAdapter.ViewHolder> {

    Activity mActivity;
    ArrayList<String> sectionList;
    HashMap<String, ArrayList<String>> itemList = new HashMap<>();
    int selectedSection = -1;
    int selectedItem = -1;

    public MainAdapter(Activity activity, ArrayList<String> sectionList, HashMap<String, ArrayList<String>> itemList) {
        this.mActivity = activity;
        this.sectionList = sectionList;
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @Override
    public int getSectionCount() {
        return sectionList.size();
    }

    @Override
    public int getItemCount(int section) {
        return itemList.get(sectionList.get(section)).size();
    }

    @Override
    public void onBindHeaderViewHolder(ViewHolder holder, int section) {
        holder.mTextView.setText(sectionList.get(section));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int section, int relativePosition, int absolutePosition) {
        String sItem=itemList.get(sectionList.get(section)).get(relativePosition);
        holder.mTextView.setText(sItem);
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, sItem, Toast.LENGTH_SHORT).show();
                selectedSection=section;
                selectedItem=relativePosition;
                notifyDataSetChanged();
            }
        });
        if (selectedSection==section&&selectedItem==relativePosition){
            holder.mTextView.setBackground(ContextCompat.getDrawable(
                    mActivity,R.drawable.rectangle_fill
            ));
            holder.mTextView.setTextColor(Color.WHITE);
        }else {
            holder.mTextView.setBackground(ContextCompat.getDrawable(
                    mActivity,R.drawable.rectangle_outline
            ));
            holder.mTextView.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemViewType(int section, int relativePosition, int absolutePosition) {
        if (section == 1) {
            return 0;
        }
        return super.getItemViewType(section, relativePosition, absolutePosition);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        if (viewType == VIEW_TYPE_HEADER) {
            layout = R.layout.item_header;
        } else {
            layout = R.layout.item_slot;
        }
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view);
        }
    }
}
