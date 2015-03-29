package com.noriaki.noriakiodanjunior;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noriaki.noriakiodanjunior.model.SiteBean;

import java.util.List;

/**
 * Created by Noriaki on 15/03/2015.
 */
public class RedesSociaisAdapter extends BaseAdapter {
    private List<SiteBean> items;
    private Context context;

    public RedesSociaisAdapter(List<SiteBean> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_redes_sociais, null);
        ImageView ivLogo = (ImageView) view.findViewById(R.id.ivLogo);
        TextView tvNome = (TextView) view.findViewById(R.id.tvNome);

        ivLogo.setImageResource(items.get(position).getLogo());
        tvNome.setText(items.get(position).getName());

        return view;
    }
}
