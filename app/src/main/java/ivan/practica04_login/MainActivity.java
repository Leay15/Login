package ivan.practica04_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import datos.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText txNip,txPassword;
    Button btnIngresar,btnRegistrar;
    ArrayList<Usuario> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = ((Practica04_Login)getApplicationContext()).listaGlobal;

        txNip = (EditText)findViewById(R.id.txNip);
        txPassword = (EditText)findViewById(R.id.txPassword);
        btnIngresar =(Button)findViewById(R.id.btnIngresar);
        btnRegistrar =(Button)findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar();
            }
        });

    }

    private void ingresar() {
        String nip = txNip.getText().toString();
        String pass =txPassword.getText().toString();
        boolean existe=false;
        boolean passOk=false;
        int index=0;
        for(Usuario u:lista){
            if(u.nip.equals(nip)){
                existe=true;
                if(u.password.equals(pass)){
                    passOk=true;
                    index=this.lista.indexOf(u);
                    break;
                }

            }
        }
        if(existe){
            if(passOk){
                Intent intent = new Intent(this,BienvenidaActivity.class);
                intent.putExtra("index",index);
                txNip.setText("");
                txPassword.setText("");
                startActivity(intent);
            }else{
                Toast.makeText(this,"Password Incorrecto Intente Nuevamente",Toast.LENGTH_LONG).show();
                txPassword.setText("");
            }
        }else{
            Toast.makeText(this,"No Existe Usuario Registrado",Toast.LENGTH_LONG).show();
            txNip.setText("");
            txPassword.setText("");
        }
    }

    private void registrar() {
        String nip = txNip.getText().toString();
        String pass =txPassword.getText().toString();
        boolean existe=false;
        for(Usuario u:lista){
            if(u.nip.equals(nip)){
                existe=true;
                break;
            }
        }
        if(existe){
            Toast.makeText(this,"Ya Existe Usuario Registrado con Ese Nip",Toast.LENGTH_LONG).show();
            Toast.makeText(this,"Intente Ingresando",Toast.LENGTH_LONG).show();
            txNip.setText("");
            txPassword.setText("");
        }else{
            Intent intent = new Intent(this,RegistroActivity.class);
            intent.putExtra("nip",nip);
            intent.putExtra("password",pass);
            txNip.setText("");
            txPassword.setText("");
            startActivity(intent);
        }
    }
}
