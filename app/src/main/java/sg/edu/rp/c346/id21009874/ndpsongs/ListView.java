package sg.edu.rp.c346.id21009874.ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    Button btnStar;
    android.widget.ListView lv;

    ArrayList<Song> al;
    CustomAdapter Ca;
    Song data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        btnStar = findViewById(R.id.btn5star);
        lv = findViewById(R.id.list);

        al = new ArrayList<>();
        Ca = new CustomAdapter(this,R.layout.row,al);
        lv.setAdapter(Ca);

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Song data = al.get(pos);
                Intent i = new Intent(ListView.this,SongEdit.class);
                i.putExtra("data",data);
            }
        });




    }
}
