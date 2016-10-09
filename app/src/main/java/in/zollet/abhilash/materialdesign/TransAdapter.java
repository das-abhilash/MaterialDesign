package in.zollet.abhilash.materialdesign;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class TransAdapter extends RecyclerView.Adapter<TransAdapter.ViewHolder> {
    View mEmptyViewText;

    public TransAdapter(View emptyViewText) {
        mEmptyViewText = emptyViewText;
    }
    public TransAdapter(){

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        final ViewHolder vh = new ViewHolder(view);
        return vh;
    }




        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            int pos = position % 6;
            switch (pos) {
                case 0:
                    holder.name.setText("Hospital pvt.ltd.");
                    holder.merchantType.setImageResource(R.drawable.medical);
                    break;
                case 1:
                    holder.name.setText("Netbanking pvt.ltd.");
                    holder.merchantType.setImageResource(R.drawable.netbanking);
                    break;
                case 2:
                    holder.name.setText("Gas Station pvt.ltd.");
                    holder.merchantType.setImageResource(R.drawable.gas_station);
                    break;
                case 3:
                    holder.name.setText("Restrunat pvt.ltd.");
                    holder.merchantType.setImageResource(R.drawable.restrutrant);
                    break;
                case 4:
                    holder.name.setText("Shop pvt.ltd.");
                    holder.merchantType.setImageResource(R.drawable.shop);
                    break;
                case 5:
                    holder.name.setText("Travel pvt.ltd.");
                    holder.merchantType.setImageResource(R.drawable.travel);
                    break;

            }
          }

    @Override
    public int getItemCount () {
        return 18;

    }
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView showMore,showLess,merchantType;
            public TextView name;
            public RelativeLayout detail_layout;


            public ViewHolder(View view) {
                super(view);
                name = (TextView) view.findViewById(R.id.name_of_merchant);
                showLess = (ImageView) view.findViewById(R.id.show_less);
                merchantType = (ImageView) view.findViewById(R.id.type_of_merchant);
                showMore = (ImageView) view.findViewById(R.id.show_more);
                detail_layout = (RelativeLayout) view.findViewById(R.id.more_layout);
                showMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMore.setVisibility(View.GONE);
                        detail_layout.setVisibility(View.VISIBLE);

                    }
                });
                showLess.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMore.setVisibility(View.VISIBLE);
                        detail_layout.setVisibility(View.GONE);
                    }
                });
            }

        }

}

