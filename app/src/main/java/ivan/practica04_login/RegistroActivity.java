package ivan.practica04_login;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import datos.Usuario;

public class RegistroActivity extends AppCompatActivity {

    EditText txNip,txPassword,txCarrera,txCiudad;
    Button btnGuardar,btnRegresar;

    ArrayList<Usuario> lista = ((Practica04_Login)getApplicationContext()).listaGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txNip = (EditText)findViewById(R.id.txNip);
        txPassword = (EditText)findViewById(R.id.txPassword);
        txCarrera = (EditText)findViewById(R.id.txCarrera);
        txCiudad = (EditText)findViewById(R.id.txCiudad);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnRegresar = (Button)findViewById(R.id.btnRegresar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar();
            }
        });
    }

    private void regresar() {
        this.finish();
    }

    private void guardar() {
        if(txNip.getText().toString().isEmpty() || txPassword.getText().toString().isEmpty() ||
                txCarrera.getText().toString().isEmpty() || txCiudad.getText().toString().isEmpty()){
            Toast.makeText(this,"No puede haber campos vacios",Toast.LENGTH_LONG).show();
        }else {
            String nip = txNip.getText().toString();
            boolean existe=false;
            for (Usuario u : lista) {
                if (u.nip.equals("nip")){
                    existe=true;
                    break;
                }
            }
            if(existe){
                Toast.makeText(this,"Ya existe un usuario registrado con ese Nip",Toast.LENGTH_LONG).show();
                Toast.makeText(this,"Intente con otro Nip",Toast.LENGTH_LONG).show();
            }else{

                Usuario user = new Usuario();
                user.nip=nip;
                user.password=txPassword.getText().toString();
                user.carrera=txCarrera.getText().toString();
                user.ciudad=txCiudad.getText().toString();
                lista.add(user);

                Toast.makeText(this,"Usuario Registrado Con Exito",Toast.LENGTH_LONG).show();

            }

        }
    }
}
