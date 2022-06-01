package adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.movie_deck.R;

public class ListAdapter extends BaseAdapter {
    private String[] titles = {"Gone Girl","Inception","Mad Max","Jurassic World","Psycho"};
    private int [] images = {R.drawable.gonegirl, R.drawable.inception,R.drawable.madmax,R.drawable.jurassicworld,R.drawable.psycho};
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = getLayoutInflater().inflate(R.layout.card, parent,false);
        ImageView mImageView = convertView.findViewById(R.id.movieImage);
        TextView mTextView = convertView.findViewById(R.id.movieTitle);
        mTextView.setText(titles[position]);
        mImageView.setImageResource(images[position]);

        return convertView;
    }
}
