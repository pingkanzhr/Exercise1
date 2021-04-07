package com.example.exercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private ArrayList<Kelas_Nama> arrayList;

    public ListViewAdapter(Context context){
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Kelas_Nama>();
        this.arrayList.addAll(Home_Act.classNamaArrayList);
    }

    public void cariNama(String query) {
        Home_Act.classNamaArrayList.clear();
        if (query.isEmpty()){
            Home_Act.classNamaArrayList.addAll(arrayList);
        }else {
            query = query.toLowerCase();
            for (Kelas_Nama search : arrayList){
                if (search.getNama().toLowerCase().contains(query)){
                    Home_Act.classNamaArrayList.add(search);
                }
            }
        }
        notifyDataSetChanged();
    }
    public class ViewHolder{
        TextView name;
    }
    
    @Override
    public int getCount() {
        return Home_Act.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Home_Act.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_listview,null);
            holder.name = view.findViewById(R.id.tv_namaitem);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(Home_Act.classNamaArrayList.get(i).getNama());
        return view;
    }
}
