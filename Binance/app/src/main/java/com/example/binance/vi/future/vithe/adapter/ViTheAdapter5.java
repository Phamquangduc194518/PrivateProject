//package com.example.binance.vi.future.vithe.adapter;
//
//import android.annotation.SuppressLint;
//import android.os.Handler;
//import android.os.Looper;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.binance.R;
//import com.example.binance.vi.future.vithe.ApiService;
//import com.example.binance.vi.future.vithe.Currency;
//
//import java.util.List;
//import java.util.Timer;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class ViTheAdapter5 extends RecyclerView.Adapter<ViTheAdapter5.ViTheViewHolder5> {
//    private List<Currency> mlist5;
//    private Handler mHandler5 = new Handler(Looper.getMainLooper());
//    private Timer mTimer;
//    private Runnable runnableCode5;
//    private Currency currencyValue5;
//
//    @SuppressLint("NotifyDataSetChanged")
//    public void setData5(List<Currency> list) {
//        this.mlist5 = list;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public ViTheViewHolder5 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemvithe, parent, false);
//        return new ViTheViewHolder5(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViTheViewHolder5 holder, int position) {
//        Currency currency = mlist5.get(position);
//        runnableCode5= new Runnable() {
//            @Override
//            public void run() {
//                ApiService.apiService.callApi1("MATIC").enqueue(new Callback<Currency>() {
//                    @Override
//                    public void onResponse(Call<Currency> call, Response<Currency> response) {
//                        currencyValue5 = response.body();
//                        if (currencyValue5!= null) {
//                            holder.costOut.setText(currencyValue5.getCost());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Currency> call, Throwable t) {
//                        return;
//                    }
//                });
//                mHandler5.postDelayed(this, 100);
//            }
//        };
//        mHandler5.post(runnableCode5);
//        holder.nameCoin.setText(currency.getNameCoin());
//        holder.length.setText(currency.getKt());
//    }
//
//    @Override
//    public int getItemCount() {
//        if (mlist5 != null) {
//            return mlist5.size();
//        }
//        return 0;
//    }
//
//
//    public class ViTheViewHolder5 extends RecyclerView.ViewHolder {
//
//        private TextView nameCoin;
//        private TextView profit;
//        private TextView roe;
//        private TextView costIn;
//        private TextView costOut;
//        private TextView length;
//
//        public ViTheViewHolder5(@NonNull View itemView) {
//            super(itemView);
//            profit = itemView.findViewById(R.id.tv_profit);
//            nameCoin = itemView.findViewById(R.id.tv_name_coin);
//            roe = itemView.findViewById(R.id.tv_roe);
//            costIn = itemView.findViewById(R.id.tv_cost_in);
//            costOut = itemView.findViewById(R.id.tv_cost_out);
//            length = itemView.findViewById(R.id.tv_kt);
//        }
//    }
//}
