package com.chien.mylistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //變數宣告
    Context context;
    //名稱與價格有七個 圖有七個 都要用ARRAYS
    String[] fastfood, prices;
    int[] imgs = {R.drawable.f101, R.drawable.f102, R.drawable.f104,
            R.drawable.f105, R.drawable.f201, R.drawable.f203, R.drawable.f301};
    ListView listView;
    TextView show;
    String all="";

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        listView = findViewById(R.id.listView);
        show = findViewById(R.id.emptyView);

        //從 strings.xml 取得資料
        fastfood = getResources().getStringArray(R.array.fastfood);
        prices = getResources().getStringArray(R.array.price);

        //轉換好要開新記憶體位置
        adapter = new MyAdapter(context);
        //給值了
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //多選
        listView.setSelector(R.color.lvcolor); //點到會有底色
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t1 = fastfood[position];
                String t2 = prices[position];

                Toast.makeText(context, t1 + " " + t2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //自訂內部類 Adapter
    public class MyAdapter extends BaseAdapter {

        //載入版面分析
        LayoutInflater inflater;
        //建構方法 實作 inflater
        public MyAdapter(Context c) {
            inflater=LayoutInflater.from(c); //這是為了找到並決定版面位置才能去對應位置並給值
        }

        //override
        //取得項目數量 就是上方 Arrays 的長度 setp1
        @Override
        public int getCount() {
            return fastfood.length;
        }
        //按長度排列項目內容 setp2
        @Override
        public Object getItem(int position) {
            return fastfood[position];
        }
        //取得項目引數參數 setp3
        @Override
        public long getItemId(int position) {
            return position;
        }
        //建立子項目版面 setp4
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //載入指定Layout
            //後面的root 參數是看要不要綁在某個群組中 目前不需要綁
            convertView = inflater.inflate(R.layout.mylayout, null);
            //初始化元件 容器有分層 所以不可以只用基礎的 findViewById
            ImageView img = convertView.findViewById(R.id.imgLogo);  //圖
            TextView name = convertView.findViewById(R.id.txtName);  //產品名稱
            TextView price = convertView.findViewById(R.id.txtengName);  //價格
            //接著要把上面元件放值
            img.setImageResource(imgs[position]);
            name.setText(fastfood[position]);
            price.setText(prices[position]);  //注意變數名字喔 上上下下不可以有一樣的
            //打包好後遞迴
            return convertView;
        }
    }

    public void onClick(View view) {
        String all="";
        for(int i=0; i<fastfood.length; i++){
            if(listView.isItemChecked(i)){
                all += fastfood[i]+"\n";
            }
        }
        show.setText("選取項目有 : " + "\n" + all); //收集全部結果
    }
}
