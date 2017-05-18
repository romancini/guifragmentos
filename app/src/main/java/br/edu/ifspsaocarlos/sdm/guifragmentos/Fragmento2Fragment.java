package br.edu.ifspsaocarlos.sdm.guifragmentos;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento2Fragment extends Fragment {


    public static Fragmento2Fragment newInstance(Context context) {
        Fragmento2Fragment fragment = new Fragmento2Fragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento2, null);
        ((PrincipalActivity)getActivity())
                .getSupportActionBar().setSubtitle(getString(R.string.fragmento_2));

        Bundle args = getArguments();
        String id = args.getString("id");
        final TextView tv = (TextView) view.findViewById(R.id.tv_fragmento_2);
        tv.setText(id);

        return view;
    }
}
