package com.agarwal.newsapp.feature.newslisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.agarwal.newsapp.R;
import com.agarwal.newsapp.feature.newslisting.network.Articles;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.List;

public class NewsListingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private List<Articles> newsList = new ArrayList<>();

  private final Context context;

  public NewsListingAdapter(Context context) {
    this.context = context;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
    return new ViewHolderNews(view);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ViewHolderNews ViewHolderNews = (ViewHolderNews) holder;
    Articles articles = newsList.get(position);
    ViewHolderNews.tvAuthor.setText(articles.getAuthor());
    ViewHolderNews.tvDesc.setText(articles.getDescription());
    ViewHolderNews.tvTitle.setText(articles.getTitle());
    Glide.with(context)
        .setDefaultRequestOptions(
            new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background))
        .load(articles.getUrlToImage())
        .into(ViewHolderNews.ivNews);
  }

  @Override
  public int getItemCount() {
    return newsList.size();
  }

  public void setNewsList(List<Articles> newsList) {
    this.newsList = newsList;
    notifyDataSetChanged();
  }

  static class ViewHolderNews extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_news)
    AppCompatImageView ivNews;

    @BindView(R.id.tv_title)
    AppCompatTextView tvTitle;

    @BindView(R.id.tv_author)
    AppCompatTextView tvAuthor;

    @BindView(R.id.tv_desc)
    AppCompatTextView tvDesc;

    ViewHolderNews(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
