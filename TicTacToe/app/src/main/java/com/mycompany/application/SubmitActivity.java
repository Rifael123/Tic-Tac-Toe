package com.mycompany.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class SubmitActivity extends Activity {
    EditText player1Name,player2Name;
    Button sbt;
    public String nameSatu,nameDua;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submitName);
        
        sbt = findViewById(R.id.submit);
        player1Name = findViewById(R.id.playerOneName);
        player2Name = findViewById(R.id.playerTwoName);
        
       
        
        sbt.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View p1) {
                    
                    
                    nameSatu = player1Name.getText().toString();
                    nameDua = player2Name.getText().toString();
                    if(nameSatu.equals("")){
                        Toast.makeText(SubmitActivity.this,"Please Enter Player Name !",Toast.LENGTH_SHORT).show();
                        
                    }else{
                    Intent intent = new Intent(SubmitActivity.this, MainActivity.class);
                    intent.putExtra("player_satu",nameSatu);
                    intent.putExtra("player_dua",nameDua);
                    startActivity(intent);
                    
                    }
                    
                    
                }
            });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"Setting");
       
        menu.add(0,0,0,"About Developer");
        menu.add(0,0,0,"Exit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        if(item.getTitle() == "Setting"){
            Toast.makeText(SubmitActivity.this,"Setting Masih Belum Ada Untuk Saat Ini",Toast.LENGTH_SHORT).show();
        }else if(item.getTitle() == "Exit"){
            exitDialog();
        }else if(item.getTitle() == "About Developer"){
            Toast.makeText(SubmitActivity.this,"Developer is Rifael Eurico Sitorus",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public void exitDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(SubmitActivity.this);
        alert.setTitle("Message!");
        alert.setMessage("Do you want to Exit ??");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface p1, int p2) {
                    finishAndRemoveTask();
                }
            });
            
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface p1, int p2) {
                }
            });
          
            
         alert.show();
            
        
    }
    
    
    
    
    
}
