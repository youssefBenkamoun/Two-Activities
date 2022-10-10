package ma.project.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Button send;
    private EditText txtMessage;
    private TextView reply_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reply_text = findViewById(R.id.text_reply);
        send = findViewById(R.id.button_main);
        txtMessage = findViewById(R.id.editText_main);
        TextView shown = findViewById(R.id.textView_reply);
        shown.setText("Reply Received");
        Intent intent1 = getIntent();


        if(intent1 != null){

            String reply1=intent1.getStringExtra("reply");
            if(reply1 == null){
                shown.setText("");
            }
            reply_text.setText(reply1);

        }


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String msg = txtMessage.getText().toString();
                intent.putExtra("message", msg);
                startActivity(intent);
            }
        });


    }
}