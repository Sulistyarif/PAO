package com.zakiadev.e_mike;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomExpandableListviewAdapter extends BaseExpandableListAdapter {

    Context context;
    String[] listParent;
    String[] listchild;

    TextView textView;

    public CustomExpandableListviewAdapter(Context context, String[] listParent, String[] listchild) {
        this.context = context;
        this.listParent = listParent;
        this.listchild = listchild;
    }

    @Override
    public int getGroupCount() {
        return listParent.length;
    }

    @Override
    public int getChildrenCount(int i) {
//        ditulis satu karena childnya hanya satu, yaitu penjelasannya
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return listParent[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return listchild[i];
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String parentTitle = (String) getGroup(i);
        if (view == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_custom_item, null);
        }
        textView = (TextView)view.findViewById(R.id.tvGlossaParent);
        textView.setText(parentTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String childDec = (String) getChild(i,i);
        if (view == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_custom_child_item, null);
        }
        textView = (TextView)view.findViewById(R.id.tvGlossaChild);
        textView.setText(childDec);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
