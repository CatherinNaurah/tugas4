package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.tugas4.Kontak;
import com.example.tugas4.KontakAdaptor;
import com.example.tugas4.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Kontak> data;
    private RecyclerView rvkontak;
    private LinearLayout formLayout;
    private EditText namaInput, nomorInput;
    private Button tambahButton, submitButton;
    private KontakAdaptor kontakAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.data = new ArrayList<>();

        this.rvkontak = findViewById(R.id.rvKontak);
        this.formLayout = findViewById(R.id.formLayout);
        this.namaInput = findViewById(R.id.namaInput);
        this.nomorInput = findViewById(R.id.nomorInput);
        this.tambahButton = findViewById(R.id.tambahButton);
        this.submitButton = findViewById(R.id.submitButton);

        kontakAdaptor = new KontakAdaptor(MainActivity.this, this.data);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
        rvkontak.setLayoutManager(lm);
        rvkontak.setAdapter(kontakAdaptor);

        // Show form when "Tambah" button is clicked
        tambahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formLayout.setVisibility(View.VISIBLE);
                rvkontak.setVisibility(View.GONE);
            }
        });

        // Add new contact when "Submit" button is clicked
        submitButton.setOnClickListener(v -> {
            String nama = namaInput.getText().toString();
            String nomor = nomorInput.getText().toString();

            if (!nama.isEmpty() && !nomor.isEmpty()) {
                // Add new contact to the list
                data.add(new Kontak(nama, nomor));
                kontakAdaptor.notifyDataSetChanged();

                // Clear input fields and hide form
                namaInput.setText("");
                nomorInput.setText("");
                formLayout.setVisibility(View.GONE);
                rvkontak.setVisibility(View.VISIBLE);
            }
   });
}
}