package manitsche.projeto.exercciolistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listMaterias;
    private String[] itens = {"Matemática Aplicada à Computação", "Ética, Cidadania e Sociedade", "Língua Portuguesa",
            "Algoritmos e Estrutura de Dados", "Banco de Dados I", "Programação Web I", "Introdução à Computação",
            "Análise e Projeto de Sistemas", "Inglês Instrumental", "Metodologia da Pesquisa Científica", "Sistemas Operacionais",
            "Banco de Dados II", "Programação Orientada a Objetos", "Redes de Computadores", "Programação Web II",
            "Projeto Integrador", "Gestão de Projetos", "Inovação e Empreendedorismo", "Engenharia de Software",
            "Interação Humano-Computador", "Sistemas Embarcados", "Segurança e Auditoria de Sistemas",
            "Trabalho de Conclusão de Curso (TCC)", "Desenvolvimento para Dispositivos Móveis", "Tópicos Especiais em Computação"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMaterias = findViewById(R.id.listMaterias);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        listMaterias.setAdapter(adaptador);

        listMaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String materiaSelecionada = itens[position];

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Matrícula")
                        .setMessage("Você deseja se matricular na disciplina " + materiaSelecionada + "?")
                        .setPositiveButton("SIM", (dialog, which) -> {
                            Toast.makeText(MainActivity.this, "Matrícula realizada na disciplina " + materiaSelecionada, Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("NÃO", null)
                        .show();
            }
        });
    }
}