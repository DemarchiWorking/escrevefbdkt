package bd.nosql.bdformulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class Visualizar :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Usuario> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return UsuarioViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.activity_visualizar, parent,false)
    )
        }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is UsuarioViewHolder -> {
                holder.bind(items.get(position))

            }
        }
        }
    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(usuarioList: List<Usuario>){

    }

    class UsuarioViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val usuarioNome : TextView = itemView.edt_nome
        val usuarioSenha : TextView = itemView.edt_senha
        val usuarioEmail : TextView = itemView.edt_email
        val usuarioTelefone : TextView = itemView.edt_telefone
        val usuarioCelular : TextView = itemView.edt_celular
        val usuarioCpf : TextView = itemView.edt_cpf
        val usuarioCidade : TextView = itemView.edt_cidade

        fun bind(usuarioPost: Usuario){
            usuarioNome.setText(usuarioPost.Nome)
            usuarioSenha.setText(usuarioPost.Senha)
            usuarioEmail.setText(usuarioPost.Email)
            usuarioTelefone.setText(usuarioPost.Telefone)
            usuarioCelular.setText(usuarioPost.Celular)
            usuarioCpf.setText(usuarioPost.Cpf)
            usuarioCidade.setText(usuarioPost.Cidade)
        }
    }
}
