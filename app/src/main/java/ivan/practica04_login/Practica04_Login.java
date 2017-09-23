package ivan.practica04_login;

import android.app.Application;

import java.util.ArrayList;

import datos.Usuario;

/**
 * Created by ivan_ on 22/09/2017.
 * Clase que crea la lista global a ser usada por la applicacion
 */

public class Practica04_Login extends Application {

    public ArrayList<Usuario> listaGlobal= null;

    public Practica04_Login(){
        listaGlobal= new ArrayList<>();
    }

}
