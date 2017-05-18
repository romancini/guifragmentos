package br.edu.ifspsaocarlos.sdm.guifragmentos;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento1Fragment extends Fragment {
    private DatabaseHelper helper;
    private String nome, usuario, senha;

    public static Fragmento1Fragment newInstance(Context context) {
        Fragmento1Fragment fragment = new Fragmento1Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fragmento1, null);

        ((PrincipalActivity)getActivity())
                .getSupportActionBar()
                .setSubtitle(getString(R.string.fragmento_1));

        Button cadastroButton = (Button)view.findViewById(R.id.btn_cadastro_usuario);
        cadastroButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Fragmento2Fragment f2 = new Fragmento2Fragment();
                Bundle args = new Bundle();
                nome = ((EditText) view.findViewById(R.id.et_nome)).getText().toString();
                usuario = ((EditText) view.findViewById(R.id.et_usuario)).getText().toString();
                senha = ((EditText) view.findViewById(R.id.et_senha)).getText().toString();
                long id = salvarUsuario(nome, usuario, senha);
                if (id > 0) {
                    args.putString("id", Long.toString(id));
                    args.putString("nome", nome);
                    args.putString("usuario", usuario);
                    args.putString("senha", senha);
                    f2.setArguments(args);
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, f2);
                    ft.commit();
                }
            }
        });

        return view;
    }

    private long salvarUsuario(String nome, String usuario, String senha){
        long resultado = 0;
        try {
            helper = new DatabaseHelper(getActivity());
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nome_completo", nome);
            values.put("usuario", usuario);
            values.put("senha", senha);
            resultado = db.insert("usuarios", null, values);
            Toast.makeText(getActivity(), "Cadastro realizado com sucesso", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
            System.out.println("erro: " + e);
        }

        return resultado;
    }
}
