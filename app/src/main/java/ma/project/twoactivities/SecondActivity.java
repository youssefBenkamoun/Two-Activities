package ma.project.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button replyButton;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.text_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        textView.setText(message);
        replyButton = findViewById(R.id.button_reply);
        editText = findViewById(R.id.editText_reply);
        Log.d(LOG_TAG,"HI");
        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(SecondActivity.this , MainActivity.class);
                String reply = editText.getText().toString();
                intent1.putExtra("reply",reply);
                startActivity(intent1);
            }
        });

    }
}