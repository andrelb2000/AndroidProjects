package br.com.amm.alula8exrest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CEPFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CEPFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private EditText cepEditText, logEditText, compEditText,
                      bairroEditText, cidadeEditText, ufEditText;
    private Button buscaLog;
    private String VIACEP =  "https://viacep.com.br/ws/";
    public CEPFragment() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cepEditText = (EditText) view.findViewById(R.id.IDF1editTextCEP);
        logEditText    = (EditText) view.findViewById(R.id.IDF1editTextRUA);
        compEditText   = (EditText) view.findViewById(R.id.IDF1editTextComp);
        bairroEditText = (EditText) view.findViewById(R.id.IDF1editTextBAIRRO);
        cidadeEditText = (EditText) view.findViewById(R.id.IDF1editTextCIDADE);
        ufEditText     = (EditText) view.findViewById(R.id.IDF1editTextUF);

        buscaLog    = (Button)   view.findViewById(R.id.IDF1buttonCEP);
        buscaLog.setOnClickListener(new View.OnClickListener() {
            String logradouro, comp, bairro, cidade, uf;
            @Override
            public void onClick(View view) {
                ConexaoViaCEP ccx = new ConexaoViaCEP(VIACEP,cepEditText.getText().toString());
                try{
                    while(!ccx.isConectado()){
                        Thread.sleep(1000);
                    }
                    JsonReader jr = ccx.getReader();
                    jr.beginObject();
                    if(jr.hasNext()){
                        //Ex:  "cep":        "20510-150",
                        jr.nextName();       jr.skipValue();
                        //Ex: "logradouro": "Rua Itacuruçá",
                        jr.nextName();      logradouro = jr.nextString();
                        //Ex:"complemento": "",
                        jr.nextName();      comp = jr.nextString();
                        //Ex: "bairro":     "Tijuca",
                        jr.nextName();      bairro = jr.nextString();
                        //Ex: "localidade": "Rio de Janeiro",
                        jr.nextName();      cidade = jr.nextString();
                        //Ex: "uf":         "RJ",
                        jr.nextName();      uf = jr.nextString();
                        // Coloca nos Widgets e manda para o Pai //
                        logEditText.setText(logradouro);  mListener.colocaLogradouro(logradouro);
                        compEditText.setText(comp);       mListener.colocaComp(comp);
                        bairroEditText.setText(bairro);   mListener.colocaBairro(bairro);
                        cidadeEditText.setText(cidade);   mListener.colocaCidade(cidade);
                        ufEditText.setText(uf);           mListener.colocaUF(uf);
                    }
                    ccx.fecharConexao();
                }catch (Exception ioe){
                    System.out.println("Errro:" + ioe);
                }
            }
        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ce, container, false);
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
    public interface OnFragmentInteractionListener {
        public void colocaLogradouro(String logradouro);
        public void colocaComp(String complemento);
        public void colocaBairro(String bairro);
        public void colocaCidade(String cidade);
        public void colocaUF(String UF);
    }
}
