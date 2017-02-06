package com.example.vinith.realmtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    // RecyclerView for Showing Retriving Data
    RecyclerView mStudentRecyclerView;

    // Show Button for Showing Data
    Button mShowBt;
    //Realm Instance
    private Realm realm;

    //RecyclerView Adapter
    StudentAdapter mStudentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowBt = (Button) findViewById(R.id.show);

        //get realm instance
        this.realm = RealmController.with(this).getRealm();

        mStudentRecyclerView = (RecyclerView) findViewById(R.id.student_recyclerView);

        mStudentRecyclerView.setVisibility(View.GONE);
        //Setting Recycler view
        setupRecycler();

        //Storing Data in Realm DB
        setRealmData();

        // get all persisted objects
        // create the helper adapter and notify data set changes
        // changes will be reflected automatically
        setRealmAdapter(RealmController.with(this).getStudent());


        //Click Listner for Showing Recycler view
        mShowBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStudentRecyclerView.setVisibility(View.VISIBLE);
            }
        });
    }


    /**
     * Setting Adapter
     *
     * @param students
     */
    public void setRealmAdapter(RealmResults<Student> students) {

        RealmStudentAdapter realmAdapter = new RealmStudentAdapter(this.getApplicationContext(), students, true);
        // Set the data and tell the RecyclerView to draw
        mStudentAdapter.setRealmAdapter(realmAdapter);
        mStudentAdapter.notifyDataSetChanged();
    }


    /**
     * Setting Recycler view
     */
    private void setupRecycler() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mStudentRecyclerView.setHasFixedSize(true);

        // use a linear layout manager since the cards are vertically scrollable
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mStudentRecyclerView.setLayoutManager(linearLayoutManager);

        // create an empty adapter and add it to the recycler view
        mStudentAdapter = new StudentAdapter(this);
        mStudentRecyclerView.setAdapter(mStudentAdapter);
    }


    /**
     * Storing Values in the realm DB
     */
    private void setRealmData() {

        ArrayList<Student> studentList = new ArrayList<>();

        Student student = new Student();
        student.setId(1 );
        student.setName("Raj");
        student.setAge(20);
        studentList.add(student);

        student = new Student();
        student.setId(2 );
        student.setName("Ravi");
        student.setAge(22);
        studentList.add(student);

        student = new Student();
        student.setId(3 );
        student.setName("Ram");
        student.setAge(24);
        studentList.add(student);

        student = new Student();
        student.setId(4 );
        student.setName("Vinith");
        student.setAge(24);
        studentList.add(student);

        student = new Student();
        student.setId(5 );
        student.setName("Rajesh");
        student.setAge(26);
        studentList.add(student);


        for (Student s : studentList) {
            // Persist your data easily
            realm.beginTransaction();
            realm.copyToRealm(s);
            realm.commitTransaction();
        }


    }


}
