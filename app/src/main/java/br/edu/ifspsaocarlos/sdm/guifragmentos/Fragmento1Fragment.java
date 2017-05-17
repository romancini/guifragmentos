package br.edu.ifspsaocarlos.sdm.guifragmentos;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento1Fragment extends Fragment {

    public static Fragmento1Fragment newInstance(Context context) {
        Fragmento1Fragment fragment = new Fragmento1Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento1, null);

        ((PrincipalActivity)getActivity())
                .getSupportActionBar()
                .setSubtitle(getString(R.string.fragmento_1));

        Button cadastroButton = (Button)view.findViewById(R.id.btn_cadastro_usuario);
        cadastroButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Fragmento2Fragment f2 = new Fragmento2Fragment();
                Bundle args = new Bundle();
                args.putString("id", "1");
                f2.setArguments(args);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, f2);
                ft.commit();
            }
        });

        return view;
    }

}
