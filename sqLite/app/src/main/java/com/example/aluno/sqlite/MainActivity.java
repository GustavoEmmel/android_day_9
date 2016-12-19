package com.example.aluno.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MySQLiteHelper db = new MySQLiteHelper(this);

        final EditText bookTitle = (EditText) findViewById(R.id.et_book_title);
        final EditText bookAuthor = (EditText) findViewById(R.id.et_book_author);

        final TextView txtText = (TextView) findViewById(R.id.txv_text);

        Button btnAdd = (Button) findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book(bookTitle.getText().toString(), bookAuthor.getText().toString());
                db.addBook(book);

                List<Book> list = db.getAllBooks();

                String allBooks = "";
                int count = 0;
                for(Book bookUnique : list){
                    allBooks = allBooks + " register #" + count++ + " " + bookUnique.toString();
                }

                txtText.setText(allBooks);
            }
        });

    }
}
