package mitso.m.homework_5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button mButton_Send;
    EditText mEditText_To;
    EditText mEditText_Subject;
    EditText mEditText_MessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mEditText_To = (EditText) findViewById(R.id.et_To_AM);
        TextDrawable.drawStringInEditText(mEditText_To, Constants.TO, 110);
        mEditText_Subject = (EditText) findViewById(R.id.et_Subject_AM);
        TextDrawable.drawStringInEditText(mEditText_Subject, Constants.SUBJECT, 235);

        mEditText_MessageText = (EditText) findViewById(R.id.et_MessageText_AM);
        mButton_Send = (Button) findViewById(R.id.btn_Send_AM);

        mButton_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String To = mEditText_To.getText().toString();
                String subject = mEditText_Subject.getText().toString();
                String messageText = mEditText_MessageText.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] {To});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, messageText);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}
