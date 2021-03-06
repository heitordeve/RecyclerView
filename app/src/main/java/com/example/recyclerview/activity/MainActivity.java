package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();

        //Configurando Adapter
        Adapter adapter = new Adapter( listaFilmes );

        //Configurando RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); //Otimizar funcionamento do RecyclerView
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter( adapter );

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        filme.getTitulo() + " | Evento: Item Pressionado",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        filme.getTitulo() + " | Evento: Item Click Longo",
                                        Toast.LENGTH_SHORT
                                ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes() {

        Filme filme = new Filme("Homem Aranha - De Volta ao Lar", "Aventura", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Liga da Justi??a", "Fic????o", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Capit??o Am??rica - Guerra Civil", "Aventura", "2016");
        this.listaFilmes.add( filme );

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Pica-Pau", "Com??dia/Anima????o", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("A M??mia", "Terror", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Meu malvado favorito 3", "Com??dia", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Carros 3", "Com??dia", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Valhala - A lenda de Thor", "Aventura", "2019");
        this.listaFilmes.add( filme );

        filme = new Filme("Invas??o ao Servi??o Secreto", "A????o", "2017");
        this.listaFilmes.add( filme );

        filme = new Filme("Midway - Batalha em Alto Mar", "A????o", "2019");
        this.listaFilmes.add( filme );

        filme = new Filme("Velozes e Furiosos: Hobbs e Shaw", "A????o", "2019");
        this.listaFilmes.add( filme );

        filme = new Filme("Amizade Maldita", "Terror", "2019");
        this.listaFilmes.add( filme );

        filme = new Filme("M8 - Quando a Morte Socorre a Vida", "Drama", "2019");
        this.listaFilmes.add( filme );

    }
}