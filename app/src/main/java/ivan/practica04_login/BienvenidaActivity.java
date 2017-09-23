package ivan.practica04_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import datos.Usuario;

public class BienvenidaActivity extends AppCompatActivity {

    TextView tvNip,tvCarrera,tvCiudad;
    ListView usuarios;
    Button btnSalir;
    ArrayList<Usuario> lista ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        tvNip = (TextView)findViewById(R.id.tvNip);
        tvCarrera= (TextView)findViewById(R.id.tvCarrera);
        tvCarrera=(TextView)findViewById(R.id.tvCiudad);
        usuarios = (ListView)findViewById(R.id.listUsuarios);
        btnSalir = (Button)findViewById(R.id.btnSalir);
        lista = ((Practica04_Login)getApplicationContext()).listaGlobal;
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salir();
            }
        });
        llenarListView();
        String index=getIntent().getExtras().getString("index");
        colocarDatos(Integer.parseInt(index));
        usuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                clickList(i);
            }
        });

    }

    private void colocarDatos(int index) {
        Usuario u = lista.get(index);
        tvNip.setText(u.nip);
        tvCarrera.setText(u.carrera);
        tvCiudad.setText(u.ciudad);
    }

    private void clickList(int i) {

        tvNip.setText(lista.get(i).nip.toString());
        tvCarrera.setText(lista.get(i).carrera.toString());
        tvCiudad.setText(lista.get(i).ciudad.toString());

    }

    private void salir() {
        this.finish();
    }

    private void llenarListView() {
        ArrayList<String> nips = new ArrayList<>();
        for(Usuario u:lista){
            nips.add(u.nip+"\t"+u.carrera + "\t" + u.ciudad);
        }
        ArrayAdapter<String> adapterList = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nips);
        usuarios.setAdapter(adapterList);
    }
}
