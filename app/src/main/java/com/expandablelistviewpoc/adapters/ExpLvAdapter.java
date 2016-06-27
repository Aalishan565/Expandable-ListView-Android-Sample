package com.expandablelistviewpoc.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.expandablelistviewpoc.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by aalishan on 19/4/16.
 */
public class ExpLvAdapter extends BaseExpandableListAdapter {
    private List<String> names;
    private HashMap<String, List<String>> data;
    private Context ctx;

    public ExpLvAdapter(Context ctx, List<String> names, HashMap<String, List<String>> data) {
        this.ctx = ctx;
        this.names = names;
        this.data = data;

    }

    @Override
    public int getGroupCount() {
        return names.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(names.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return names.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(names.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String name = (String) this.getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_row_item, null);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_parent);
        tvName.setTypeface(null, Typeface.BOLD);
        tvName.setText(name);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String name = (String) this.getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_row_item, null);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_child);
        tvName.setText(name);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
