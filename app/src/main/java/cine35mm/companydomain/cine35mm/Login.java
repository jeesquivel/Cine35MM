package cine35mm.companydomain.cine35mm;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText correoEditText,contrasennaEditText;
    private FirebaseAuth.AuthStateListener mAuthStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser usuario = firebaseAuth.getCurrentUser();
            if (usuario!=null){
                Log.i("Sesion","iniciada las sesi'on");


            }else{
                Log.i("Sesion","mierda");

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        contrasennaEditText=findViewById(R.id.editText_password_login);
        correoEditText =findViewById(R.id.editText_correo_login);

    }

    public void iniciarSesion(View view){
        try {
            String password= contrasennaEditText.getText().toString().trim();
            String correo= correoEditText.getText().toString().trim();
            FirebaseAuth.getInstance().signInWithEmailAndPassword(correo,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Log.i("sesion","cool");
                            }else{
                                Toast.makeText(Login.this,"Verifique los datos de entrada",Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }catch (Exception e){
            Toast.makeText(Login.this,"Verifique los datos de entrada",Toast.LENGTH_LONG).show();
        }

    }


    public void registrarUsuarioOnclick(View view){
        Intent intent = new Intent(getApplicationContext(),registrarUsuarios.class);
        startActivity(intent);
    }







}
