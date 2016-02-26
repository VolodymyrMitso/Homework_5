package mitso.m.homework_5;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEditText_To;
    EditText mEditText_Subject;
    EditText mEditText_MessageText;
    Button mButton_Send;
    Button mButton_Call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mEditText_To = (EditText) findViewById(R.id.et_To_AM);
        mEditText_Subject = (EditText) findViewById(R.id.et_Subject_AM);
        mEditText_MessageText = (EditText) findViewById(R.id.et_MessageText_AM);

        TextDrawable.drawStringInEditText(mEditText_To, Constants.TO, 110);
        TextDrawable.drawStringInEditText(mEditText_Subject, Constants.SUBJECT, 235);

        mButton_Send = (Button) findViewById(R.id.btn_Send_AM);
        mButton_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String To = mEditText_To.getText().toString();
                String subject = mEditText_Subject.getText().toString();
                String messageText = mEditText_MessageText.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{To});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, messageText);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client:"));
            }
        });

        mButton_Call = (Button) findViewById(R.id.btn_Call_AM);
        mButton_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse(Constants.TEL));
                if (checkWriteExternalPermission())
                    startActivity(call);
            }
        });
    }

    private boolean checkWriteExternalPermission() {
        String permission = "android.permission.CALL_PHONE";
        int res = getApplicationContext().checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
}