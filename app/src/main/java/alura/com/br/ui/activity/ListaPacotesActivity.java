package alura.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import alura.com.br.R;
import alura.com.br.dao.PacoteDAO;
import alura.com.br.model.Pacote;
import alura.com.br.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APP_BAR);

        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}