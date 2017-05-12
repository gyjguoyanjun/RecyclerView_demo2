
package com.gyj.recyclerview_demo2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.gyj.recyclerview_demo2.R;
import com.gyj.recyclerview_demo2.bean.Book;

import java.util.HashMap;
import java.util.List;


/**
 * @class describe
 * @anthor 郭彦君
 * @time 2017/5/12
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ItemViewHolder> {

    private List<Book> mItems;
    public HashMap<Integer, Boolean> map;

    public MyRecyclerViewAdapter(List<Book> mItems) {
        this.mItems = mItems;
        map = new HashMap<>();
        init();
    }

    private void init() {
        if (null == mItems || mItems.size() <= 0) {
            return;
        }
        for (int i = 0, p = mItems.size(); i < p; i++) {
            map.put(i, false);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_item, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        if (null == mItems || mItems.size() <= 0) {
            return;
        }
        holder.name.setText(mItems.get(position).getName());

        holder.checkBox.setTag(new Integer(position));//防止划回来时选中消失

        if (map != null) {
            holder.checkBox.setChecked((map.get(position)));
        } else {
            holder.checkBox.setChecked(false);
        }


    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public final CheckBox checkBox;
        public final TextView name;

        public ItemViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
            name = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }


    public void setMap(HashMap<Integer, Boolean> map) {
        this.map = map;
        notifyDataSetChanged();
    }


}
