package br.com.amm.aula8exfragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SegundoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SegundoFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Button enviaPaiButton;
    private Button recebePaiButton;
    private EditText numEnviaEditText;

    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        enviaPaiButton = (Button) view.findViewById(R.id.IDbuttonFrag2EnviaPai);
        recebePaiButton = (Button) view.findViewById(R.id.IDbuttonFrag2RecebePai);
        numEnviaEditText = (EditText) view.findViewById(R.id.IDeditTextFrag2num);

        enviaPaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.recebidoFragmento2(Integer.parseInt(numEnviaEditText.getText().toString()));
            }
        });
        recebePaiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int recebido = mListener.enviaFragmento2();
                numEnviaEditText.setText(Integer.toString(recebido));
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segundo, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void recebidoFragmento2(int numero);
        int  enviaFragmento2();
    }
    public void setNumFrag2(int i){
        numEnviaEditText.setText(Integer.toString(i));
    }
}
