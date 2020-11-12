package com.example.p6recycleview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p6recycleview.databinding.FragmentRecyclerAvionBinding;
import com.example.p6recycleview.databinding.ViewholderAvionBinding;

import java.util.List;

public class RecyclerAvionFragment extends Fragment {


    private FragmentRecyclerAvionBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentRecyclerAvionBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AvionesViewModel avionesViewModel = new ViewModelProvider(this).get(AvionesViewModel.class);

        AvionAdapter avionAdapter = new AvionAdapter();

        binding.recyclerView.setAdapter(avionAdapter);


        avionesViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Avion>>() {
            @Override
            public void onChanged(List<Avion> avions) {
                Log.e("ABCD", "lista aviones obtenida");
                avionAdapter.establecerLista(avions);
            }
        });
    }

    class AvionViewHolder extends RecyclerView.ViewHolder {
        public final ViewholderAvionBinding binding;

        public AvionViewHolder(ViewholderAvionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class AvionAdapter extends RecyclerView.Adapter<AvionViewHolder>{

        List<Avion> aviones;

        @NonNull
        @Override
        public AvionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.e("ABCD", "CREANDO VIEWHOLDER");
            return new AvionViewHolder(ViewholderAvionBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull AvionViewHolder holder, int position) {
            Avion avion = aviones.get(position);

            Log.e("ABCD","Rellendando viewholder " + position + " con los datos del " + avion.nombre);
            holder.binding.nombre.setText(avion.nombre);
            holder.binding.valoracion.setRating(avion.valoracion);
        }

        @Override
        public int getItemCount() {
            return aviones != null ? aviones.size() : 0;
        }

        public void establecerLista(List<Avion> elementos){
            this.aviones = elementos;
            notifyDataSetChanged();
        }
    }
}


