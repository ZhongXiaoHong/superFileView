package com.silang.superfileview;

import android.Manifest;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.silang.superfileview.R;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    private String filePath;
    private List<String> datas = new ArrayList<>();
    private List<String> paths = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initPaths();

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                return new RecyclerView.ViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item, parent, false)) {
                };

            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
                holder.itemView.findViewById(R.id.item_root).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String[] perms = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        filePath = getFilePath(position);
                        if (!EasyPermissions.hasPermissions(MainActivity.this, perms)) {
                            EasyPermissions.requestPermissions(MainActivity.this, "需要访问手机存储权限！", 10086, perms);
                        } else {
                            FileDisplayActivity.show(MainActivity.this, filePath);
                        }
                    }
                });
                ((TextView) holder.itemView.findViewById(R.id.item_tv)).setText(getDatas().get(position));
            }

            @Override
            public int getItemCount() {
                return getDatas().size();
            }
        });
    }

    private void initPaths() {
    }

    private void initDatas() {
        datas.add("网络获取并打开doc文件");
        datas.add("打开本地doc文件");


        datas.add("打开本地txt文件");

        datas.add("打开本地excel文件");


        datas.add("打开本地ppt文件");


        datas.add("打开本地pdf文件");
    }

    private List<String> getDatas() {

        if (datas != null && datas.size() > 0) {
            return datas;
        } else {
            datas = new ArrayList<>();
            initDatas();
            return datas;
        }

    }

    private String getFilePath(int position) {
        String path = null;
        switch (position) {
            case 0:
                path = "http://www.hrssgz.gov.cn/bgxz/sydwrybgxz/201101/P020110110748901718161.doc";
                break;
            case 1:

                path =  "/storage/emulated/0/test.docx";

                break;


            case 2:
                path = "/storage/emulated/0/test.txt";
                break;

            case 3:
                path = "/storage/emulated/0/test.xlsx";
                break;
            case 4:
                path = "/storage/emulated/0/test.pptx";
                break;

            case 5:
                path = "/storage/emulated/0/test.pdf";
                break;
        }
        return path;
    }
}
