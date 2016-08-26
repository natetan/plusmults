package yulongproductions.com.plusmults;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private ColorWheel mColorWheel;

    private TextView mResultTextView;
    private EditText mNum1EditText;
    private EditText mNum2EditText;
    private Button mResultButton;
    private RelativeLayout mLayout;
    private String symbol;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mColorWheel = new ColorWheel();
        mResultTextView = (TextView) findViewById(R.id.resultTextView);
        mNum1EditText = (EditText) findViewById(R.id.num1EditText);
        mNum2EditText = (EditText) findViewById(R.id.num2EditText);
        mResultButton = (Button) findViewById(R.id.resultButton);
        mLayout = (RelativeLayout) findViewById(R.id.mainLayout);

        this.symbol = "";
        this.result = 0;

        mResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String field1 = mNum1EditText.getText().toString().trim();
                String field2 = mNum2EditText.getText().toString().trim();
                if (!field1.equals("") && !field2.equals("")) {
                    int num1 = Integer.parseInt(field1);
                    int num2 = Integer.parseInt(field2);
                    MainActivity.this.symbol = "+";
                    MainActivity.this.result = num1 + num2;
                    mLayout.setBackgroundColor(mColorWheel.getColor());
                    String message = num1 +" " + symbol + " " + num2 + " is " + result;
                    mResultTextView.setText(message);
                } else {
                    Toast.makeText(MainActivity.this, "Please type in a number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mResultButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String field1 = mNum1EditText.getText().toString().trim();
                String field2 = mNum2EditText.getText().toString().trim();
                if (!field1.equals("") && !field2.equals("")) {
                    int num1 = Integer.parseInt(field1);
                    int num2 = Integer.parseInt(field2);
                    MainActivity.this.symbol = "*";
                    MainActivity.this.result = num1 * num2;
                    mLayout.setBackgroundColor(mColorWheel.getColor());
                    String message = num1 +" " + symbol + " " + num2 + " is " + result;
                    mResultTextView.setText(message);
                    return true;
                } else {
                    Toast.makeText(MainActivity.this, "Please type in a number", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
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
}
