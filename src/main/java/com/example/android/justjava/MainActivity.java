package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder (View view) {

        CheckBox ch = (CheckBox)findViewById(R.id.checkbox);
        boolean addWhippedCream = ch.isChecked();
        CheckBox ch2 = (CheckBox)findViewById(R.id.checkbox2);
        boolean addChocolate = ch2.isChecked();


        display(quantity);
        displayMessage(createOrderSummary(addWhippedCream,addChocolate));


    }
    int quantity=0;
    int price;
    // This function is used to increase quantity
    public  int increment(View view){
        quantity++;
        display(quantity);
        displayPrice(quantity*5);
        price = quantity*5;
        return price;



    }
    // This function is used to decrease quantity
    public  int  decrement(View view){

        displayPrice(quantity*5-5);
        quantity--;
        display(quantity);
        price= quantity*5-5;


        return price;

    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.summary_text_view);
        priceTextView.setText(message);
    }


        private void display(int number) {
            TextView quantityTextView = findViewById(R.id.size_text_view);
            quantityTextView.setText(""+number);
        }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText("" +NumberFormat.getCurrencyInstance().format(number));
    }

    private String createOrderSummary( boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: MBA Chaiwala";
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $"+ price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

}