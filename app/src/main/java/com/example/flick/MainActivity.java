package com.example.flick;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.flick.Adapter.TitleAdapter;
import com.example.flick.Handler.ApiHandler;
import com.example.flick.Network.IApiService;
import com.example.flick.Network.MainResponse;
import com.example.flick.Network.PhotoName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private IApiService service = ApiHandler.getInstance().getService();
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private TitleAdapter titleAdapter;
    private ArrayList<PhotoName> photoNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listTitle);
        gridLayoutManager = new GridLayoutManager(MainActivity.this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        getPhotoName();
    }

    private void getPhotoName() {
        AsyncTask.execute(() ->{
            service.getPhotos().enqueue(new Callback<MainResponse>() {
                @Override
                public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                    photoNames = new ArrayList<>(response.body().getPhotoList().getPhotoNames());
                    titleAdapter = new TitleAdapter(photoNames);
                    recyclerView.setAdapter(titleAdapter);
                }

                @Override
                public void onFailure(Call<MainResponse> call, Throwable t) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle(t.getLocalizedMessage()).setNegativeButton("XUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).create().show();
                }
            });
        });
    }
}