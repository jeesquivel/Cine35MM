package cine35mm.companydomain.cine35mm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.FirebaseDatabase;
import Dominio.FirebaseReferences;
import Dominio.Usuario;

public class registrarUsuarios extends AppCompatActivity {
    private EditText editText_nombre, editText_contrasenna, editText_correo;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        editText_nombre=findViewById(R.id.editText_name);
        editText_contrasenna = findViewById(R.id.editText_contrasenna);
        editText_correo=findViewById(R.id.editText_correo);

        progressBar =findViewById(R.id.progressBar_login);
        progressBar.setVisibility(View.GONE);
        mAuth= FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()!=null){

        }
    }

    public void registrarUsuario(View view){
        try{
            final String nombre=editText_nombre.getText().toString().trim();
            final String correo= editText_correo.getText().toString().trim();
            final String contrasenna= editText_contrasenna.getText().toString().trim();
            mAuth.createUserWithEmailAndPassword(correo,contrasenna)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Usuario usuario= new Usuario(nombre,correo,contrasenna,0);
                                FirebaseDatabase.getInstance().getReference(FirebaseReferences.USUARIOS_REFERENCE)
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progressBar.setVisibility(View.GONE);

                                        if (task.isSuccessful()){
                                            abrirLogin();
                                        }else{
                                            Toast.makeText(registrarUsuarios.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }else{
                                Toast.makeText(registrarUsuarios.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }catch (Exception e){
            Toast.makeText(registrarUsuarios.this,"Verifique los datos de entrada", Toast.LENGTH_LONG).show();
        }

    }

    public void abrirLogin(){
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }


}
