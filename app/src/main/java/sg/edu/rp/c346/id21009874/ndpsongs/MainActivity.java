package sg.edu.rp.c346.id21009874.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;
    Button btnInsert, btnList;
    TextView tvTitle, tvSinger, tvYear, tvStars;
    RadioGroup ratingBar;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);
        ratingBar = findViewById(R.id.ratingBar);
        tvTitle = findViewById(R.id.tvTitle);
        tvSinger = findViewById(R.id.tvSinger);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);

        ratingBar.setNumStars(5);

        aa = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, al);
        al = new ArrayList<>();

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                String title = etTitle.getText().toString();
                String singers = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int stars = Math.round(ratingBar.getRating());

                long inserted_id = dbh.insertSong(title,singers,year,stars);
                if (inserted_id != -1){
                    al.clear();
                    al.addAll(dbh.getAllSongs());
                    aa.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Insert unsuccessful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListView.class);
                startActivity(i);

            }
        });
    }


}