package com.example.p6recycleview;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p6recycleview.databinding.ViewholderAvionBinding;

import java.util.List;

public class AvionesViewModel extends AndroidViewModel {

    AvionRepositorio avionRepositorio;

    MutableLiveData<List<Avion>> listAvionesMutableLiveData = new MutableLiveData<>();

    public AvionesViewModel(@NonNull Application application) {
        super(application);

        avionRepositorio = new AvionRepositorio();
        listAvionesMutableLiveData.setValue(avionRepositorio.obtener());
    }

    MutableLiveData<List<Avion>> obtener(){
        return listAvionesMutableLiveData;
    }
}
