package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONTut extends AppCompatActivity {
    private String myJSONObjectString = "{\n" +
            "  \"studentName\": \"LeeBoonKong\",\n" +
            "  \"courseName\": \"Computer Science\",\n" +
            "  \"Age\": \"23\",\n" +
            "  \"borrowBooks\": [\n" +
            "    \"A\",\n" +
            "    \"B\",\n" +
            "    \"C\"\n" +
            "  ],\n" +
            "  \"libraryProfile\": {\n" +
            "    \"libraryID\": \"0003\",\n" +
            "    \"numberOfBorrowedBooks\": \"3\",\n" +
            "    \"allowedToEnter\": \"true\"\n" +
            "  },\n" +
            "  \"friends\": [\n" +
            "    {\n" +
            "      \"name\": \"Avicii\",\n" +
            "      \"status\": \"Best Friend\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Justin Bieber\",\n" +
            "      \"status\": \"Unfriend\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Jason\",\n" +
            "      \"status\": \"Normal Friend\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Kelly\",\n" +
            "      \"status\": \"Girlfriend\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private Button btnGetName, btnGetCourse, btnGetAge,btnGetArray,btnGetLibraryID,btnGetFriends;
    private TextView tvData;
    private JSONObject myJSONObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsontut);

        btnGetName = findViewById(R.id.btnGetname);
        btnGetCourse = findViewById(R.id.btnGetcourse);
        btnGetAge = findViewById(R.id.btnGetage);
        btnGetArray = findViewById(R.id.btnGetarray);
        tvData = findViewById(R.id.tvData);
        btnGetLibraryID = findViewById(R.id.btnGetLibraryId);
        btnGetFriends = findViewById(R.id.btnGetfriends);

        setOnlistners();
        prepareJSON();

    }

    private void setOnlistners(){
        btnGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = myJSONObject.getString(name="studentName");
                    tvData.setText(name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnGetCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String course = myJSONObject.getString(course="courseName");
                    tvData.setText(course);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnGetAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String age = myJSONObject.getString(age="Age");
                    tvData.setText(age);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnGetArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray booksArray = new JSONArray(myJSONObject.getString("borrowBooks"));
                    String result="";
                    for(int i=0;i<booksArray.length();i++){
                        String bookName = booksArray.getString(i);
                        result += bookName +"\n";
                        tvData.setText(result);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnGetLibraryID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject libraryJsonObject = new JSONObject(myJSONObject.getString("libraryProfile"));
                    String libraryId = libraryJsonObject.getString("libraryID");
                        tvData.setText(libraryId);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
            }
        });

        btnGetFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray friendsArr = myJSONObject.getJSONArray("friends");
                    for(int i=0;i<friendsArr.length();i++){
                        JSONObject friend = friendsArr.getJSONObject(i);
                        String name = friend.getString("name");
                        if(name.equalsIgnoreCase("Jason")){
                            tvData.setText(friend.getString("status"));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void prepareJSON(){
        try {
            myJSONObject = new JSONObject(myJSONObjectString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
