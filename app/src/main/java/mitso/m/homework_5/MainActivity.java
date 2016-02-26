package mitso.m.homework_5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tb_Toolbar_AM);
        setSupportActionBar(myToolbar);

        EditText mEditText_SentTo = (EditText)findViewById(R.id.et_SendTo_AM);
        TextDrawable.drawStringInEditText(mEditText_SentTo, "Send To:", 250);

        EditText mEditText_Subject = (EditText)findViewById(R.id.et_Subject_AM);
        TextDrawable.drawStringInEditText(mEditText_Subject, "Subject:", 235);


    }
}
