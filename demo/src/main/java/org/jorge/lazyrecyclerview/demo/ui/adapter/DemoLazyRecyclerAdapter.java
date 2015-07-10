package org.jorge.lazyrecyclerview.demo.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jorge.lazyrecyclerview.LazyRecyclerAdapter;
import org.jorge.lazyrecyclerview.demo.R;
import org.jorge.lazyrecyclerview.demo.datamodel.DemoDataModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Jorge Antonio Diaz-Benito Soriano (github.com/Stoyicker).
 */
public class DemoLazyRecyclerAdapter extends LazyRecyclerAdapter<DemoLazyRecyclerAdapter.ViewHolder> {

    private final List<DemoDataModel> mItems;

    @LayoutRes
    private static final Integer ADAPTER_ITEM_LAYOUT_RES = R.layout.adapter_item_demo;

    public DemoLazyRecyclerAdapter(@NonNull final List<DemoDataModel> items) {
        super(items);
        this.mItems = items;
    }

    @Override
    public DemoLazyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(ADAPTER_ITEM_LAYOUT_RES,
                parent,
                Boolean.FALSE);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final DemoDataModel item = getItem(position);
        holder.mTextView.setText(item.getText());
    }

    private DemoDataModel getItem(@NonNull final Integer position) {
        return mItems.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.entry_text)
        TextView mTextView;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}