package bd.nosql.bdformulario

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db : FirebaseFirestore = FirebaseFirestore.getInstance();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    btn_salvar.setOnClickListener {
        salvarContato()
        }
    btn_limpar.setOnClickListener {
        limparCampos()
        }
    }

    fun limparCampos(){
        edt_nome.setText("")
        edt_senha.setText("")
        edt_email.setText("")
        edt_telefone.setText("")
        edt_celular.setText("")
        edt_cpf.setText("")
        edt_cidade.setText("")
    }
    fun salvarContato(){
        if(edt_nome.text.toString() == ""
            //|| edt_senha.text.toString() == "" ||
            //edt_email.text.toString() == "" || edt_telefone.text.toString() == "" ||
            //edt_celular.text.toString() == "" || edt_cpf.text.toString() == "" ||
            //edt_cidade.text.toString() == ""
        ){

            Toast.makeText(this@MainActivity,  "Preencha todos os Campos", Toast.LENGTH_LONG).show()

        }else{
            val usuario = Usuario(edt_nome.text.toString(), edt_senha.text.toString(),
                edt_email.text.toString(), edt_telefone.text.toString(),edt_celular.text.toString(),
                edt_cpf.text.toString(),edt_cidade.text.toString())

            db.collection("Nome")
                .document(edt_nome.text.toString())
                .set(usuario)
                .addOnSuccessListener {   }
                .addOnFailureListener {   }

            Toast.makeText(this@MainActivity,  "Foi", Toast.LENGTH_LONG).show()


        }
    }

}
