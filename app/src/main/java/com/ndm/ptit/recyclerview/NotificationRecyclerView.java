package com.ndm.ptit.recyclerview;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.ndm.ptit.R;
import com.ndm.ptit.activity.AppointmentpageInfoActivity;
import com.ndm.ptit.activity.BookingpageInfoActivity;
import com.ndm.ptit.enitities.notification.Notification;
import com.ndm.ptit.helper.Tooltip;

import java.util.List;
import java.util.Objects;

public class NotificationRecyclerView extends RecyclerView.Adapter<NotificationRecyclerView.ViewHolder>{


    private final Context context;
    private final List<Notification> list;
    private final Callback callback;


    public NotificationRecyclerView(Context context, List<Notification> list, Callback callback)
    {
        this.context = context;
        this.list = list;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_view_element_notification, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notification notification = list.get(position);

        int id = notification.getId();
        String message = notification.getMessage();
        int recordId = notification.getRecordId();
        String recordType = notification.getRecordType();
        String createAt = Tooltip.beautifierDatetime(context, notification.getCreateAt() );
        int isRead = notification.getIsRead();

        /*set text color*/
        int colorRead = context.getColor(R.color.colorTextBlack);
        holder.message.setTextColor(colorRead);


        /*set text color for unread notification*/
        if( isRead == 0)
        {
            int colorUnread = context.getColor(R.color.colorBlue);
            holder.message.setTextColor(colorUnread);
        }

        holder.datetime.setText(createAt);
        holder.message.setText(message);
        holder.layout.setOnClickListener(view->{
            /*set color for notification we clicks on*/
            holder.message.setTextColor(colorRead);


            if(isRead == 0)
            {
                callback.markAsRead( String.valueOf(id) );
            }

            Intent intent;
            if(Objects.equals(recordType, "booking"))
            {
                intent = new Intent(context, BookingpageInfoActivity.class);

            }
            else
            {
                intent = new Intent(context, AppointmentpageInfoActivity.class);
            }
            intent.putExtra("id", String.valueOf(recordId));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final LinearLayout layout;
        private final TextView message;
        private final TextView datetime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.elementLayout);
            message = itemView.findViewById(R.id.elementMessage);
            datetime = itemView.findViewById(R.id.elementDatetime);
        }
    }

    public interface Callback{
        void markAsRead(String notificationId);
    }
}
