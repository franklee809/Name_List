package com.example.frank.name_list;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.frank.name_list.R.string.class_name;


public class new_class extends AppCompatActivity{
    private static final String b = "New_class";
    private static final String VIEW_INDEX = "index";
    private Button NextButton1;
    private EditText editClass;
    private Button save;
    private Button view_class;
    private TextView title;
    String mstudent_name; // get student name
    String mclass_name; // get class name
    ArrayList<String> student_name1 = new ArrayList<String>();


    private class_info[] mclass_info = new class_info[]{
            new class_info(class_name),
            new class_info(R.string.student_name_input)};

    private int Index = 0;

    private void updatetitle(){
        int a = mclass_info[Index].getID();
        title.setText(a);
    }



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_class);

        editClass = (EditText)findViewById(R.id.editText2);
        title =(TextView)findViewById(R.id.textView4);


        save = (Button)findViewById(R.id.button6);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Index == 0) {
                    String getclassname = editClass.getText().toString();

                    if (getclassname == null || getclassname.trim().equals("")){
                        Toast.makeText(new_class.this, R.string.empty_input,
                                Toast.LENGTH_SHORT).show();
                    }
                    else{
                        mclass_name = getclassname;
                        Toast.makeText(new_class.this, "You have entered '"+editClass.getText()+"'",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else if(Index == 1){
                    String getStudentname = editClass.getText().toString();
                    if (getStudentname == null || getStudentname.trim().equals("")){
                        Toast.makeText(new_class.this, R.string.empty_input,
                                Toast.LENGTH_SHORT).show();
                    }
                    else{
                        mstudent_name = getStudentname;
                        student_name1.add(getStudentname);

                        Toast.makeText(new_class.this, "You have entered '"+ editClass.getText()+"'",
                                Toast.LENGTH_SHORT).show();


                    }

                }
                editClass.setText("");
            }
        });

        NextButton1=(Button)findViewById(R.id.button5);
        NextButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editClass.setText(""); // clear text
                if (Index < 1) { // class name array should not be empty
                    Index = (Index + 1) % mclass_info.length;
                }
                else if (Index>=1){
                    Toast.makeText(new_class.this, R.string.last_page,
                            Toast.LENGTH_SHORT).show();
                }

                updatetitle();
            }
        });
        if(savedInstanceState!=null){
            Index = savedInstanceState.getInt(VIEW_INDEX,0);
        }
        updatetitle();


        view_class = (Button)findViewById(R.id.view_class1);
        view_class.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mstudent_name == null || mstudent_name.trim().equals("")) {
                    Toast.makeText(new_class.this,"Please enter student name",
                            Toast.LENGTH_SHORT).show();
                }
                else if (mclass_name == null || mclass_name.trim().equals("")){
                    Toast.makeText(new_class.this,"Please enter class name",
                            Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent i = new Intent(new_class.this, view_class.class);
                    i.putExtra("Class_Name",mclass_name);
                    i.putExtra("name",student_name1);
                    startActivity(i);
                }
            }

        });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(b,"onSaveInstanceState");
        savedInstanceState.putInt(VIEW_INDEX,Index);
    }
}