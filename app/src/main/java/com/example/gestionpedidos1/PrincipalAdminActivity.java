package com.example.gestionpedidos1;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.gestionpedidos1.fragment.EmployeesFragment;
import com.example.gestionpedidos1.fragment.HomeFragment;
import com.example.gestionpedidos1.fragment.OrdersFragment;
import com.example.gestionpedidos1.fragment.ProductsFragment;
import com.example.gestionpedidos1.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PrincipalAdminActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaprincipaladmin);

        initView();
        initValues();
        initListener();
    }

    // Inicializa las vistas
    private void initView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    // Configura el fragmento inicial
    private void initValues() {
        fragmentManager = getSupportFragmentManager();
        loadFirstFragment();
    }

    // Configura el Listener del BottomNavigationView
    private void initListener() {
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                int itemId = item.getItemId(); // Get the item ID

                if (itemId == R.id.nav_home) {
                    selectedFragment = HomeFragment.newInstance();
                } else if (itemId == R.id.nav_orders) {
                    selectedFragment = OrdersFragment.newInstance();
                } else if (itemId == R.id.nav_products) {
                    selectedFragment = ProductsFragment.newInstance();
                } else if (itemId == R.id.nav_profile) {
                    selectedFragment = ProfileFragment.newInstance();
                } else if (itemId == R.id.nav_employees) {
                    selectedFragment = EmployeesFragment.newInstance();
                }

                // Cargar el fragmento correspondiente
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameContainer, selectedFragment)
                            .addToBackStack(null)  // Permite navegar hacia atrás entre fragmentos
                            .commit();
                }

                return true; // Indica que el ítem fue seleccionado
            }
        });
    }

    // Método para cargar el primer fragmento
    private void loadFirstFragment() {
        fragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, fragment)
                .commit();
    }
}