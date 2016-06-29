package pom.poly.com.tryfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pom.poly.com.tryfirebase.Data.Student;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edName)
    EditText edName;
    @BindView(R.id.edMajor)
    EditText edMajor;
    @BindView(R.id.btSend)
    Button btSend;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ref = FirebaseDatabase.getInstance().getReference();
    }

    @OnClick(R.id.btSend)
    public void onClick() {
        writeStudent(edName.getText() + "", edMajor.getText() + "");
    }

    private void writeStudent(String name, String major) {
        Student student = new Student(name, major);
        ref.child("Students").push().setValue(student);
    }
}
