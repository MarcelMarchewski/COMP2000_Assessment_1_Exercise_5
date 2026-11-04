package com.example.comp2000_assessment_1_exercise_5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder>
{
    private List<Booking> bookings;

    public BookingAdapter(List<Booking> bookings)
    {
        this.bookings = bookings;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item, parent, false);

        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position)
    {
        Booking booking = bookings.get(position);

        holder.roomName.setText(booking.getRoomName());

        holder.bookingDateTime.setText(booking.getDate() + "\n\n" + booking.getTime());

        holder.manageButton.setOnClickListener(x -> OnManageButtonClick(holder, position));
    }

    private void OnManageButtonClick(@NonNull BookingViewHolder holder, int position)
    {
        int currentPos = holder.getBindingAdapterPosition();

        if (currentPos != RecyclerView.NO_POSITION)
        {
            Booking selectedBooking = bookings.get(currentPos);

            // TODO: swap to manage booking screen with this data
        }
    }

    @Override
    public int getItemCount()
    {
        return bookings.size();
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder
    {
        TextView roomName;
        TextView bookingDateTime;
        Button manageButton;

        public BookingViewHolder(@NonNull View itemView)
        {
            super(itemView);

            roomName = itemView.findViewById(R.id.roomName);
            bookingDateTime = itemView.findViewById(R.id.bookingDateTime);
            manageButton = itemView.findViewById(R.id.manageButton);
        }
    }
}
