package com.example.student.bai02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtHoTen,txtCMND,txtTTBoSung;
    RadioGroup rgBangCap;
    RadioButton rbTrungCap,rbCaoDang,rbDaiHoc;
    CheckBox cbDocBao,cbDocSach,cbDocCode;

    Button btnGuiTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHoTen = (EditText) findViewById(R.id.txtHoTen);
        txtCMND = (EditText) findViewById(R.id.txtCMND);
        txtTTBoSung = (EditText) findViewById(R.id.txtTTBoSung);

        rgBangCap = (RadioGroup) findViewById(R.id.rgBangCap);
        rbTrungCap = (RadioButton) findViewById(R.id.rbtnTrungCap);
        rbCaoDang = (RadioButton) findViewById(R.id.rbtnCaoDang);
        rbDaiHoc = (RadioButton) findViewById(R.id.rbtnDaiHoc);

        cbDocBao = (CheckBox) findViewById(R.id.cbBao);
        cbDocSach = (CheckBox) findViewById(R.id.cbSach);
        cbDocCode = (CheckBox) findViewById(R.id.cbCode);

        btnGuiTT = (Button) findViewById(R.id.btnGuiTT);

        btnGuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = txtHoTen.getText().toString();
                if(ten.equals("")||ten.length()<3){
                    Toast.makeText(MainActivity.this,"Tên người không được để trống và có ít nhất 3 ký tự",Toast.LENGTH_SHORT).show();
                    return;
                }
                String cmnd = txtCMND.getText().toString();
                if(cmnd.length()!=9){
                    Toast.makeText(MainActivity.this,"CMND phải là số và có 9 số",Toast.LENGTH_SHORT).show();
                    return;
                }
                String bangcap ="";
                if(rbTrungCap.isChecked()){
                    bangcap="Trung Cấp";
                }else if(rbCaoDang.isChecked()){
                    bangcap="Cao Đẳng";
                }else if(rbDaiHoc.isChecked()){
                    bangcap="Đại Học";
                }
                List<String> listSoThich = new ArrayList<>();
                if(cbDocBao.isChecked()){
                    listSoThich.add("Đọc báo");
                }
                if(cbDocSach.isChecked()){
                    listSoThich.add("Đọc Sách");
                }
                if(cbDocCode.isChecked()){
                    listSoThich.add("Đọc Code");
                }
                String ttBS=txtTTBoSung.getText().toString();

                ThongTinCaNhan ttcn = new ThongTinCaNhan(ten,cmnd,bangcap,listSoThich,ttBS);
                Toast.makeText(MainActivity.this,ttcn.xuat(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
