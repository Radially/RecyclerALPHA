package radial_design.recycleralpha;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuestionActivity extends ActionBarActivity {
    private List<Question> Qestions;


    boolean b;

    public void setQuestionActivity(){

        final Button b1 = (Button)findViewById(R.id.b1);
        final Button b2 = (Button)findViewById(R.id.b2);
        final Button b3 = (Button)findViewById(R.id.b3);
        final Button b4 = (Button)findViewById(R.id.b4);

        Qestions = new ArrayList<>();
        Qestions.add(new Question(1, "Plane", new String[]{"Boeing 787-800", "Airbus A350-900", "Airbus A330-300", "Boeing 757-300"}, "Boeing 787-800", R.drawable.bqi1));
        Qestions.add(new Question(2, "Tail", new String[]{"Delta", "Air France", "American Airlines", "SAS"}, "Delta", R.drawable.bqi2));
        Qestions.add(new Question(3, "Airport", new String[]{"Dubai/DXB", "Brussels/BRU", "Edinburgh/EDI", "Abu-Dhabi/AUH"}, "Dubai/DXB", R.drawable.bqi3));
        Qestions.add(new Question(4, "Plane", new String[]{"Boeing 787-800", "Boeing 737-900", "Airbus A330-300", "Boeing 757-200"}, "Boeing 757-200", R.drawable.bqi4));

        RVAdapter adapter=new RVAdapter(Qestions);
        final Question Q= Qestions.get(adapter.qn);


        TextView tv = (TextView)findViewById(R.id.tvQ);
        ImageView iv = (ImageView)findViewById(R.id.Question_photo);


        Random r = new Random();
        final String [] mix = new String [4];
        int mixer = r.nextInt(4);
        for(int i=0; i<4;i++){
            if ((mixer+i)>=4) mixer-=4;
            mix[i]=Q.answers[i+mixer];
        }

        b1.setText(mix[0]);
        b2.setText(mix[1]);
        b3.setText(mix[2]);
        b4.setText(mix[3]);

        tv.setText(Q.cat);
        iv.setImageResource(Q.photoId);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = mix[0].equals(Q.answer);
                if(b) {
                    b1.setBackgroundColor(getResources().getColor(R.color.trueC));
                    success();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_SHORT).show();
                    b1.setBackgroundColor(getResources().getColor(R.color.falseC));
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=mix[1].equals(Q.answer);
                if(b) {
                    b2.setBackgroundColor(getResources().getColor(R.color.trueC));
                    success();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_SHORT).show();
                    b2.setBackgroundColor(getResources().getColor(R.color.falseC));
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=mix[2].equals(Q.answer);
                if(b) {
                    b3.setBackgroundColor(getResources().getColor(R.color.trueC));
                    success();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_SHORT).show();
                    b3.setBackgroundColor(getResources().getColor(R.color.falseC));

                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=mix[3].equals(Q.answer);
                if(b) {
                    b4.setBackgroundColor(getResources().getColor(R.color.trueC));
                    success();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_SHORT).show();
                    b4.setBackgroundColor(getResources().getColor(R.color.falseC));
                }
            }
        });




    }

   /* private void answered(int bNum){
        Button[] bArr= {b1,b2,b3,b4};

        if(b) {
            Toast.makeText(getApplicationContext(),"Good Answer!", Toast.LENGTH_LONG).show();
            bArr[bNum+1].setBackgroundColor(getResources().getColor(R.color.trueC));
        }
        else {
            Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_LONG).show();
            bArr[bNum+1].setBackgroundColor(getResources().getColor(R.color.falseC));
        }

    }*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        setQuestionActivity();
    }

    private void success(){
        Toast.makeText(getApplicationContext(),"Good Answer!", Toast.LENGTH_LONG).show();
        try {
            this.wait(3000);
        }
        catch (Exception exception){
        }
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
}
