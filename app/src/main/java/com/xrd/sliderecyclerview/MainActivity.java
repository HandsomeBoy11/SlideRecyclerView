package com.xrd.sliderecyclerview;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SlideDeleteRecyclerView sdrv = (SlideDeleteRecyclerView) findViewById(R.id.sdrv);
        sdrv.setLayoutManager(new LinearLayoutManager(this));
        sdrv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom=10;
            }
        });
        sdrv.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ViewHolder holder1 = (ViewHolder) holder;
                holder1.llContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "内容", Toast.LENGTH_SHORT).show();
                    }
                });holder1.llMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public int getItemCount() {
                return 20;
            }
        });
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llContent;
        private LinearLayout llMenu;
        public ViewHolder(View itemView) {
            super(itemView);
            llContent=itemView.findViewById(R.id.ll_content);
            llMenu=itemView.findViewById(R.id.ll_delete);
        }
    }
}
