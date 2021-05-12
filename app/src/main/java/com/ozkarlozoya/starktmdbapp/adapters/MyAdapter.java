package com.ozkarlozoya.starktmdbapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.ozkarlozoya.starktmdbapp.MovieDetails;
import com.ozkarlozoya.starktmdbapp.R;
import com.ozkarlozoya.starktmdbapp.modulos.MovieInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends PagerAdapter {

    Context context;
    List<MovieInfo> movieList;

    public MyAdapter(Context context, List<MovieInfo> movieList){
        this.context=context;
        this.movieList=movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_item,container,false);
        ImageView movie_image=(ImageView)view.findViewById(R.id.movie_image);
        TextView movie_title=(TextView)view.findViewById(R.id.movie_title);
        TextView movide_description=(TextView)view.findViewById(R.id.description);
        TextView movide_calificacion=(TextView)view.findViewById(R.id.calificacionT);


        Picasso.get().load(movieList.get(position).getImage()).into(movie_image);

        //movie_image.setImageResource(movieList.get(position).getImage());
        movie_title.setText(movieList.get(position).getName());
        movide_description.setText("Fecha de estreno: "+movieList.get(position).getDescription());
        int unicode = 0x1F4AB;
        String emoji = new String(Character.toChars(unicode));
        movide_calificacion.setText("Calificacion: "+ emoji+" "+movieList.get(position).getCalificacionT());

        view.setOnClickListener(v -> {
            Toast.makeText(context, "id: "+movieList.get(position).getId(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(view.getContext(), MovieDetails.class);
            intent.putExtra("idmovie",movieList.get(position).getId()+"");
            view.getContext().startActivity(intent);
        });

        container.addView(view);
        return view;
    }
}

