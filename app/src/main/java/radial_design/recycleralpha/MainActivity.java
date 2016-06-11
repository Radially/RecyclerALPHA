package radial_design.recycleralpha;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private List<Question> Qestions;
    private RecyclerView rv;
    private SwipeRefreshLayout swipeLayout;
    private int pPlace =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeLayout.setRefreshing(false);
                    }
                }, 3000);
            }

        });


        initializeData();
        initializeAdapter();

    }



    private void initializeData(){
        Qestions = new ArrayList<>();
        Qestions.add(new Question(1, "Plane", new String[]{"Boeing 787-800", "Airbus A350-900", "Airbus A330-300", "Boeing 757-300"}, "Boeing 787-800", R.drawable.bqi1));
        Qestions.add(new Question(2, "Tail", new String[]{"Delta", "Air France", "American Airlines", "SAS"}, "Delta", R.drawable.bqi2));
        Qestions.add(new Question(3, "Airport", new String[]{"Dubai/DXB", "Brussels/BRU", "Edinburgh/EDI", "Abu-Dhabi/AUH"}, "Dubai/DXB", R.drawable.bqi3));
        Qestions.add(new Question(4, "Plane", new String[]{"Boeing 787-800", "Boeing 737-900", "Airbus A330-300", "Boeing 757-200"}, "Boeing 757-200", R.drawable.bqi4));
    }

    private void initializeAdapter(){
        final RVAdapter adapter;
        adapter = new RVAdapter(Qestions);
        adapter.setCICL(new  RVAdapter.CustomItemClickListener()  {
            @Override
            public void onItemClick(View v, int position) {
                // do what ever you want to do with it
                /*Qestions.add(pPlace+1, new Question(pPlace+2, "Tail", new String[]{"", "", "", ""}, "", R.drawable.radial_d_500_logo));
                pPlace++;
                adapter.Qestions=Qestions;
                Toast.makeText(getApplicationContext(),"Toast!"+position,Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();*/
                Intent myIntent = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(myIntent);
                adapter.qn=position;

            }
        });

        rv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // refreshing path:


}
