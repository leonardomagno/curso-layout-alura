package alura.com.br.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import alura.com.br.R;
import alura.com.br.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getOpPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);


        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        int quantidadeDeDias = pacote.getDias();
        String diasEmTexto = "";
        if (quantidadeDeDias > 1) {
            diasEmTexto = quantidadeDeDias + " Dias";
        } else {
            diasEmTexto = quantidadeDeDias + " Dia";
        }
        dias.setText(diasEmTexto);

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        BigDecimal precoDoPacote = pacote.getPreco();
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String moedaBrasileira = formatoBrasileiro
                .format(precoDoPacote)
                .replace("R$", "R$ ");
        preco.setText(moedaBrasileira);

        return viewCriada;
    }
}
