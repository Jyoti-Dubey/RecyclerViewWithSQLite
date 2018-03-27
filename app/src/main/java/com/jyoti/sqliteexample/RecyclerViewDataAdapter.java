package com.jyoti.sqliteexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jyoti on 18/01/2018.
 */

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.RecyclerViewHolder> {
    private final String TAG = "RecyclerViewDataAdapter";
    private Context context;
    private ArrayList<RecyclerViewDataProvider> arrayList ;


    public RecyclerViewDataAdapter(Context context, ArrayList<RecyclerViewDataProvider> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_recyclerview, parent, false);
        RecyclerViewHolder recyclerviewholder = new RecyclerViewHolder(view);
        return recyclerviewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        RecyclerViewDataProvider recyclerViewDataProvider = arrayList.get(position);

        holder.empName.setText(recyclerViewDataProvider.getEmpName());
        holder.empsalary.setText(recyclerViewDataProvider.getEmpsalary());
        holder.deptName.setText(recyclerViewDataProvider.getDeptName());
        holder.deptsal.setText(recyclerViewDataProvider.getDeptsal());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView empName;
        private TextView empsalary;
        private TextView deptName;
        private TextView deptsal;

        public RecyclerViewHolder(View itemView) {
            super(itemView);


            empName = (TextView) itemView.findViewById(R.id.empName);
            empsalary = (TextView) itemView.findViewById(R.id.empsalary);
            deptName = (TextView) itemView.findViewById(R.id.deptName);
            deptsal = (TextView) itemView.findViewById(R.id.deptsal);

            itemView.setOnClickListener(this);
        }//end of  RecyclerViewHolder method

        @Override
        public void onClick(View view) {

            Toast.makeText(view.getContext(), "Clicked Item Position = " + getPosition(), Toast.LENGTH_SHORT).show();

        }
    }//end of RecyclerViewHolder class
}
