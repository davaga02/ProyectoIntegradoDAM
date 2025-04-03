package com.example.gestionpedidos1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.gestionpedidos1.R;

public class EmployeesFragment extends Fragment {

    public  EmployeesFragment() {
        // Constructor vacío
    }

    public static EmployeesFragment newInstance() {

        Bundle args = new Bundle();

        EmployeesFragment fragment = new EmployeesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        return inflater.inflate(R.layout.fragment_employees, container, false);
    }
}
