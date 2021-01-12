package com.chien.mydialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            dialog1();
        }
        else if(view.getId() == R.id.button2) {
            dialog2();
        }
        else if(view.getId() == R.id.button3) {
            dialog3();
        }
        else if(view.getId() == R.id.button4) {
            dialog4();
        }
        else if(view.getId() == R.id.button5) {
            dialog5();
        }
        else if(view.getId() == R.id.button6) {
            dialog6();
        }
        else {
            dialog7();
        }
    }

    //跳窗建立
    private void dialog1() {
        AlertDialog.Builder builde = new AlertDialog.Builder(context);  //跳窗容器建立
        builde.setTitle(R.string.button_text1); //標頭
        builde.setMessage(R.string.like_android); //內容
        //確定按鈕 這個可以做事情
        builde.setPositiveButton(R.string.like, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Yes", Toast.LENGTH_SHORT).show();
                dialog.dismiss();//跳窗消失
            }
        });
        //取消按鈕
        builde.setNegativeButton(R.string.not, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); //跳窗消失
            }
        });
        builde.setCancelable(false); //不准點空白處退出跳窗
        builde.create().show();
    }

    private void dialog2() {
        AlertDialog.Builder builde = new AlertDialog.Builder(context);  //跳窗容器建立
        builde.setTitle(R.string.button_text2); //標頭
        builde.setMessage(R.string.like_android); //內容
        //確定按鈕 這個可以做事情
        builde.setPositiveButton(R.string.like, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Yes", Toast.LENGTH_SHORT).show();
                dialog.dismiss();//跳窗消失
            }
        });
        //取消按鈕
        builde.setNegativeButton(R.string.not, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); //跳窗消失
            }
        });
        //無意見按鈕
        builde.setNeutralButton(R.string.no_idea, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "None", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); //跳窗消失
            }
        });
        builde.setCancelable(false); //不准點空白處退出跳窗
        builde.create().show();
    }

    private void dialog3() {
        AlertDialog.Builder builde = new AlertDialog.Builder(context);  //跳窗容器建立
        builde.setTitle(R.string.button_text3); //標頭
        builde.setMessage(R.string.input_code); //內容
        builde.setIcon(android.R.drawable.ic_dialog_alert);

        final EditText et = new EditText(context);
        // ↑ 下方方法 setPositiveButton( 內部類  DialogInterface.OnClickListener() 想讀取 et 變數 要加final 比較好 唯一值不可複寫不可改變
        builde.setView(et);

        //確定按鈕 這個可以做事情
        builde.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String keyin = et.getText().toString();
                Toast.makeText(context, keyin, Toast.LENGTH_SHORT).show();
                dialog.dismiss();//跳窗消失
            }
        });
        //取消按鈕
        builde.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); //跳窗消失
            }
        });

        builde.setCancelable(false); //不准點空白處退出跳窗
        builde.create().show();
    }

    private void dialog4() {
        AlertDialog.Builder builde = new AlertDialog.Builder(context);  //跳窗容器建立
        builde.setTitle(R.string.button_text4); //標頭
        builde.setIcon(android.R.drawable.ic_dialog_email);

        //builde.setMessage(R.string.input_code); //這個不可以跟下面這個一起用 否則會壞掉喔......
        builde.setSingleChoiceItems(R.array.drink, 0, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] arr = getResources().getStringArray(R.array.drink);
                Toast.makeText(context, arr[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        //取消按鈕
        builde.setNegativeButton(R.string.no_idea, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); //跳窗消失
            }
        });

        builde.setCancelable(false); //不准點空白處退出跳窗
        builde.create().show();
    }

    private void dialog5() {
        AlertDialog.Builder builde = new AlertDialog.Builder(context);  //跳窗容器建立
        builde.setTitle(R.string.button_text5); //標頭
        builde.setIcon(android.R.drawable.presence_online);

        final String[] arr = getResources().getStringArray(R.array.drink);
        final boolean[] drinkChecked = new boolean[arr.length];

        builde.setMultiChoiceItems(arr, drinkChecked, new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //將勾選結果儲存到 drinkChecked
                drinkChecked[which] = isChecked;
            }
        });

        //確定按鈕 這個可以做事情
        builde.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<arr.length; i++){
                    if(drinkChecked[i] == true){
                        sb.append(arr[i]);
                    }
                }
                Toast.makeText(context, sb.toString()+ " ", Toast.LENGTH_SHORT).show();
                dialog.dismiss();//跳窗消失
            }
        });

        //取消按鈕
        builde.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); //跳窗消失
            }
        });

        builde.setCancelable(false); //不准點空白處退出跳窗
        builde.create().show();
    }

    private void dialog6() {
        AlertDialog.Builder builde = new AlertDialog.Builder(context);  //跳窗容器建立
        builde.setTitle(R.string.button_text6); //標頭
        builde.setIcon(android.R.drawable.presence_online);

        builde.setItems(R.array.food, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] food = getResources().getStringArray(R.array.food);
                Toast.makeText(context, food[which], Toast.LENGTH_SHORT).show();
            }
        });

        //取消按鈕
        builde.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss(); //跳窗消失
            }
        });

        builde.setCancelable(false); //不准點空白處退出跳窗
        builde.create().show();
    }

    private void dialog7() {
        //版面
        LayoutInflater inflater = getLayoutInflater();
        // 下方 findViewById(R.id.rt) 因為有底 所以要加
        View view = inflater.inflate(R.layout.dialog, findViewById(R.id.rt));

        TextView show = view.findViewById(R.id.randomText);
        Button btn = view.findViewById(R.id.randomBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = (int)(Math.random()*100);
                show.setText(num + "");
            }
        });

        //Dialog
        AlertDialog.Builder builde = new AlertDialog.Builder(context);  //跳窗容器建立
        builde.setTitle(R.string.button_text7); //標頭
        builde.setIcon(android.R.drawable.presence_online);

        builde.setView(view);

        builde.setPositiveButton("確定", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nn = show.getText().toString();
                Toast.makeText(context, nn, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builde.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builde.setCancelable(false);
        builde.create().show();
    }
}